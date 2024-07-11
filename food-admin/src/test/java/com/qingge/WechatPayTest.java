package com.qingge;

import com.qnbc.venueReservation.config.MyRSAAutoCertificateConfig;
import com.wechat.pay.java.service.payments.jsapi.JsapiServiceExtension;
import com.wechat.pay.java.service.payments.jsapi.model.*;
import com.wechat.pay.java.service.payments.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description TODO
 * @Author gzj
 * @Date 2023/9/19 21:36
 * @Version 1.0
 **/

@Slf4j
@SpringBootTest
public class WechatPayTest {

	/** 商户号 */
	public static String merchantId = "";

	/** 商户证书序列号 */
	public static String merchantSerialNumber = "";
	/** 商户APIV3密钥 */
	public static String apiV3key = "";
	/*appid*/
	public static String appid= "";


	@Autowired
	private MyRSAAutoCertificateConfig config;//这里没有用Cinfig接口接收，直接用MyRSAAutoCertificateConfig接收了，后文会说为啥这样

	@Autowired
	private JsapiServiceExtension jsapiServiceExtension;





	/*
	 * 创建预支付工单
	 * */
	@Test
	public void createOrder() throws Exception {
		// request.setXxx(val)设置所需参数，具体参数可见Request定义
		PrepayRequest request = new PrepayRequest();
		Amount amount = new Amount();
		amount.setTotal(1);
		Payer payer = new Payer();
		payer.setOpenid("");
		request.setAmount(amount);
		request.setAppid(appid);
		request.setMchid(merchantId);
		request.setDescription("测试商品标题");
		request.setNotifyUrl("");//回调地址
		request.setOutTradeNo("11111111115");
		request.setPayer(payer);

		// response包含了调起支付所需的所有参数，可直接用于前端调起支付
		PrepayWithRequestPaymentResponse response = jsapiServiceExtension.prepayWithRequestPayment(request);
		System.out.println(response);
	}


	/*
	 * 查询微信支付订单，根据商户工单
	 * */
	@Test
	public void queryOrderByOutTradeNo(){
		//todo 微信支付订单号查询订单
		QueryOrderByOutTradeNoRequest orderByOutTradeNoRequest = new QueryOrderByOutTradeNoRequest();
		orderByOutTradeNoRequest.setMchid(merchantId);
		orderByOutTradeNoRequest.setOutTradeNo("11111111115");
		Transaction transaction = jsapiServiceExtension.queryOrderByOutTradeNo(orderByOutTradeNoRequest);
		System.out.println(transaction);
	}


	/*
	 * 唤醒小程序支付请求参数的签名
	 * */
//	@Test
//	public void awakenAppletSign(){
//		AwakenAppletSignReq req = new AwakenAppletSignReq();
//		req.setAppId(appid);
//		req.setTimeStamp(System.currentTimeMillis() + "");
//		req.setNonceStr(IdWorker.getIdStr());
//		req.setOrderPackage("prepay_id=wx26171828262790b07fc8eexxxcedb0000");
//		String s = WechatSignUtil.awakenAppletSign(req, config.createSigner());
//		System.out.println(s);
//	}







}
