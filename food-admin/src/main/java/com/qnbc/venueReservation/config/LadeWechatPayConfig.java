package com.qnbc.venueReservation.config;

import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.service.payments.jsapi.JsapiServiceExtension;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @Description TODO
 * @Author gzj
 * @Date 2023/9/19 21:34
 * @Version 1.0
 **/
@Slf4j
//@Configuration
public class LadeWechatPayConfig {

	/**
	 * 商户号
	 */
	private String merchantId = "1652725222";
	/**
	 * 商户证书序列号（这是你自己的证书序列号哈，不是平台的）
	 */
	private String merchantSerialNumber = "16D947EDAC72AF7122B3146D9262BC8A3B3DD085";
	/**
	 * 商户APIV3密钥
	 */
	private String apiV3key = "wuhantiyuxueyuantiyukejixy302039";


	private ClassPathResource keyClassPath = new ClassPathResource("./cert/apiclient_key.pem");//获取到resources包下指定文件

	/*
	 * 初始化config对象，这个对象在构建各种支付执行器对象的时候需要传入，并且可复用
	 * */
	@Bean
	public MyRSAAutoCertificateConfig getMyRSAConfig() {
		MyRSAAutoCertificateConfig config = null;
		try {
			config = new MyRSAAutoCertificateConfig.Builder()
				.privateKeyFromInputStream(keyClassPath.getInputStream())
				.merchantId(merchantId)
				.merchantSerialNumber(merchantSerialNumber)
				.apiV3Key(apiV3key)
				.build();//这个是我自己定义的那个对象，可以用stream加载证书文件
		} catch (IOException e) {
			log.error("--------------初始化微信支付config异常----------------"+e.toString());
		}
		return config;
	}


	/*
	 * 构建微信支付jsapi执行器对象
	 * */
	@Bean
	public JsapiServiceExtension getJsapiServiceExtension(@Autowired Config config) {
		return new JsapiServiceExtension.Builder().config(config).build();
	}
}
