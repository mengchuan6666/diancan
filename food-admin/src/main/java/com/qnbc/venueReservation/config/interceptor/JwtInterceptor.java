package com.qnbc.venueReservation.config.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qnbc.venueReservation.core.utils.StringUtils;
import com.qnbc.venueReservation.domain.Wxuserinfo;
import com.qnbc.venueReservation.entity.User;
import com.qnbc.venueReservation.exception.ServiceException;
import com.qnbc.venueReservation.service.IUserService;
import com.qnbc.venueReservation.common.Constants;
import com.qnbc.venueReservation.service.IWxuserinfoService;
import org.jsoup.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class JwtInterceptor implements HandlerInterceptor {

	@Autowired
	private IUserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		String token = request.getHeader("token");
		if (StringUtils.isEmpty(token)) {
			token = request.getParameter("token");
		}
		// 如果不是映射到方法直接通过
		if (handler instanceof HandlerMethod) {
			AuthAccess annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthAccess.class);
			if (annotation != null) {
				return true;
			}
		}
		// 执行认证
		if (StrUtil.isBlank(token)) {
			throw new ServiceException(Constants.CODE_401, "无token，请重新登录");
		}
		// 获取 token 中的 user id
		String userId;
		try {
			userId = JWT.decode(token).getAudience().get(0);
		} catch (JWTDecodeException j) {
			throw new ServiceException(Constants.CODE_401, "token验证失败，请重新登录");
		}

		// 根据token中的userid查询数据库
		LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
		lambdaQueryWrapper.eq(User::getOpenId, userId);
		User user = userService.getOne(lambdaQueryWrapper);
		if (user == null) {
			throw new ServiceException(Constants.CODE_401, "用户不存在，请重新登录");
		}
		// 用户密码加签验证 token
		JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
		try {
			jwtVerifier.verify(token); // 验证token
		} catch (JWTVerificationException e) {
			throw new ServiceException(Constants.CODE_401, "token验证失败，请重新登录");
		}
		return true;
	}
}
