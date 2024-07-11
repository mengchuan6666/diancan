//package com.qnbc.venueReservation.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * @Description TODO
// * @Author gzj
// * @Date 2023/7/23 17:53
// * @Version 1.0
// **/
//
//@Configuration
//@EnableWebMvc
//public class WebConfig extends WebMvcConfigurerAdapter {
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/user/login")
//			.allowedOrigins("http://localhost:8080") // 允许来自 http://localhost:8080 的请求
//			.allowedMethods("POST") // 允许的请求方法
//			.allowedHeaders("*") // 允许的请求头
//			.allowCredentials(true); // 允许发送身份凭证（例如Cookies）
//	}
//}
