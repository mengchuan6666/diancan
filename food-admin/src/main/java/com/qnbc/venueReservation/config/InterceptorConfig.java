package com.qnbc.venueReservation.config;

//import com.qnbc.venueReservation.config.interceptor.JwtInterceptor;

import com.qnbc.venueReservation.config.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations(
			"classpath:/static/");
		registry.addResourceHandler("/doc.html").addResourceLocations(
			"classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations(
			"classpath:/META-INF/resources/webjars/");


		registry.addResourceHandler("/uploadPic/**").addResourceLocations("file:/Users/gzj/Documents/workspace/mywork/GraduationDesign/订餐小程序/2.项目/food/picfile/");
		registry.addResourceHandler("/venueReservation/image/swiper/**").addResourceLocations("file:/Users/gzj/Documents/workspace/mywork/GraduationDesign/订餐小程序/2.项目/food/picfile/swiperImgs/");
		registry.addResourceHandler("/venueReservation/image/bigType/**").addResourceLocations("file:/Users/gzj/Documents/workspace/mywork/GraduationDesign/订餐小程序/2.项目/food/picfile/bigTypeImgs/");
		registry.addResourceHandler("/venueReservation/image/product/**").addResourceLocations("file:/Users/gzj/Documents/workspace/mywork/GraduationDesign/订餐小程序/2.项目/food/picfile/productImgs/");
		registry.addResourceHandler("/venueReservation/image/productSwiperImgs/**").addResourceLocations("file:/Users/gzj/Documents/workspace/mywork/GraduationDesign/订餐小程序/2.项目/food/picfile/productSwiperImgs/");
		registry.addResourceHandler("/venueReservation/image/productIntroImgs/**").addResourceLocations("file:/Users/gzj/Documents/workspace/mywork/GraduationDesign/订餐小程序/2.项目/food/picfile/productIntroImgs/");
		registry.addResourceHandler("/venueReservation/image/productParaImgs/**").addResourceLocations("file:/Users/gzj/Documents/workspace/mywork/GraduationDesign/订餐小程序/2.项目/food/picfile/productParaImgs/");
		super.addResourceHandlers(registry);
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor())
			.addPathPatterns("/**")
			.excludePathPatterns("/venueReservation/user/login", "/user/openId", "/venueReservation/user/register", "/**/export", "/**/import", "/file/**", "/uploadPic/**", "/news/**", "/notice/**", "/comment/**", "/role/**", "/venueReservation/product/**", "/venueReservation/bigtype/**", "/venueReservation/appletuser/wxlogin", "/weixinpay/**", "/venueReservation/collect/**", "/venueReservation/image/**", "/venueReservation/AboutMe/**", "/venueReservation/config/**","/venueReservation/alipay/**")
			.excludePathPatterns("/doc.html", "/swagger**/**", "/webjars/**", "/v3/**", "/*.html");
		super.addInterceptors(registry);
	}

	@Bean
	public JwtInterceptor jwtInterceptor() {
		return new JwtInterceptor();
	}

}
