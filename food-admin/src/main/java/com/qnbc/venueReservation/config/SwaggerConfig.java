package com.qnbc.venueReservation.config;

import com.qnbc.venueReservation.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {


//	@Override
//	public SwaggerProperties swaggerProperties() {
//		return SwaggerProperties.builder()
//			.apiBasePackage("com.qnbc.venueReservation.controller")
//			.title("订餐小程序后端服务")
//			.description("订餐小程序服务相关接口文档")
//			.contactName("guzj")
//			.version("1.0")
//			.enableSecurity(false)
//			.build();
//	}
//
//	@Bean
//	public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
//		return generateBeanPostProcessor();
//	}


//	@Override
//	@Bean
//	public Docket createRestApi() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//			.apis(RequestHandlerSelectors.basePackage("com.qnbc.venueReservation.controller")).paths(PathSelectors.any())
//			.build();
//
//	}
//
//
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder().title("action-swagger").description("swagger实战").termsOfServiceUrl("")
//			.version("1.0").build();
//	}

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.OAS_30) // v2 不同
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.qnbc.venueReservation.controller")) // 设置扫描路径
			.build();
	}


}
