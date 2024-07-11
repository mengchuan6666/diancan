package com.qnbc.venueReservation.controller;
//微信用户controller

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qnbc.venueReservation.common.SystemConstant;
import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.domain.Wxuserinfo;
import com.qnbc.venueReservation.entity.User;
import com.qnbc.venueReservation.properties.WeixinProperties;
import com.qnbc.venueReservation.service.IUserService;
import com.qnbc.venueReservation.service.IWxuserinfoService;
import com.qnbc.venueReservation.utils.HttpClientUtil;
import com.qnbc.venueReservation.utils.JwtUtils;
import com.qnbc.venueReservation.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/venueReservation/appletuser")
public class UserAppletController {

	@Autowired
	private WeixinProperties weixinProperties;

	@Autowired
	private HttpClientUtil httpClientUtil;

	@Autowired
	private IWxuserinfoService wxUserInfoService;
	@Autowired
	private IUserService userService;

	//微信用户登录
	@RequestMapping("/wxlogin")
	public AjaxResult wxLogin(@RequestBody Wxuserinfo wxUserInfo) {
		System.out.println(wxUserInfo.getCode());
		//拼接生成openid
		String jscode2sessionUrl = weixinProperties.getJscode2sessionUrl() + "?appid=" + weixinProperties.getAppid() + "&secret=" + weixinProperties.getSecret() + "&js_code=" + wxUserInfo.getCode() + "&grant_type=authorization_code";
		System.out.println(jscode2sessionUrl);
		//httpClienUtil解析这个地址获取openid
		String result = httpClientUtil.sendHttpGet(jscode2sessionUrl);
		System.out.println(result);
		//JSON将openid解析出来
		JSONObject jsonObject = JSON.parseObject(result);
		String openid = jsonObject.get("openid").toString();
		System.out.println(openid);
		//插入用户到数据库 若用户不存在 插入用户  若用户存在 更新用户
		User user1 = new User();
		User user = userService.getOne(new QueryWrapper<User>().eq("open_id", openid));
		if (user == null) {
			System.out.println("不存在 插入用户");
			user1.setOpenId(openid);
			user1.setUsername(openid);
			user1.setPassword("123");
			user1.setRole("ROLE_USER");
			user1.setCreateTime(new Date());
			userService.save(user1);
		} else {
			System.out.println("存在 更新用户");
			user.setNickname(wxUserInfo.getNickname());
			userService.updateById(user);
		}

		user1 = user;
		String token = TokenUtils.genToken(openid, user1.getPassword());
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("token", token);
		return AjaxResult.success(resultMap);
	}
}
