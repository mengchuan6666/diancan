package com.qnbc.venueReservation.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qnbc.venueReservation.domain.Wxuserinfo;
import com.qnbc.venueReservation.entity.User;
import com.qnbc.venueReservation.service.IUserService;
import com.qnbc.venueReservation.service.IWxuserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class TokenUtils {

	private static IUserService staticUserService;


	private static IWxuserinfoService staticWxUserInfoService;
	@Autowired
	private IWxuserinfoService wxUserInfoService;

	@Resource
	private IUserService userService;

	@PostConstruct
	public void setUserService() {
		staticUserService = userService;
	}

	@PostConstruct
	public void setWxUserInfoService() {
		staticWxUserInfoService = wxUserInfoService;
	}

	/**
	 * 生成token
	 *
	 * @return
	 */
	public static String genToken(String userId, String sign) {
		return JWT.create().withAudience(userId)
			.withExpiresAt(DateUtil.offsetHour(new Date(), 2))
			.sign(Algorithm.HMAC256(sign));
	}

	/**
	 * 获取当前登录的用户信息
	 *
	 * @return user对象
	 */
	public static User getCurrentUser() {
		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			String token = request.getHeader("token");
			if (StrUtil.isNotBlank(token)) {
				String userId = JWT.decode(token).getAudience().get(0);
				LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
				lambdaQueryWrapper.eq(User::getOpenId, userId);
				return staticUserService.getOne(lambdaQueryWrapper);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
}
