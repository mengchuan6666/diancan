package com.qnbc.venueReservation.config;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.domain.FoodOrder;
import com.qnbc.venueReservation.service.IOrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AliPayConfig {
	@Value("${alipay.appId}")
	private String appId;
	@Value("${alipay.privateKey}")
	private String appPrivateKey;
	@Value("${alipay.publicKey}")
	private String alipayPublicKey;
	@Value("${alipay.notifyUrl}")
	private String notifyUrl;
	@Value("${alipay.url}")
	private String url;
	@Resource
	private IOrderService orderInfoDao;


	//    @PostConstruct
//    public void init() {
//        // 设置参数（全局只需设置一次）
//        Config config = new Config();
//        config.protocol = "https";
//        config.gatewayHost = "openapi.alipaydev.com";
//        config.signType = "RSA2";
//        config.appId = this.appId;
//        config.merchantPrivateKey = this.appPrivateKey;
//        config.alipayPublicKey = this.alipayPublicKey;
//        config.notifyUrl = this.notifyUrl;
//        Factory.setOptions(config);
//        System.out.println("=======支付宝SDK初始化成功=======");
//    }
	public String pay(String id, String price, String title) {
		AlipayClient alipayClient = new DefaultAlipayClient(url, appId, appPrivateKey, "json", "UTf-8", alipayPublicKey, "RSA2");
		AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
		alipayTradePagePayRequest.setNotifyUrl(notifyUrl);
		JSONObject bizContent = new JSONObject();
		bizContent.put("out_trade_no", id);
		bizContent.put("total_amount", price);
		bizContent.put("subject", title);
		bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");
		alipayTradePagePayRequest.setBizContent(bizContent.toString());
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return form;
	}

	public AjaxResult tui(FoodOrder orderInfo) throws AlipayApiException {
		AlipayClient alipayClient = new DefaultAlipayClient(url, appId, appPrivateKey, "json", "UTf-8", alipayPublicKey, "RSA2");
		AlipayTradeRefundRequest alipayTradeRefundRequest = new AlipayTradeRefundRequest();
		JSONObject bizContent = new JSONObject();
		bizContent.put("trade_no", orderInfo.getAlipayTraceNo());
		bizContent.put("refund_amount", orderInfo.getTotalprice());
		bizContent.put("out_request_no", orderInfo.getOrderId());
		alipayTradeRefundRequest.setBizContent(bizContent.toString());
		AlipayTradeRefundResponse response = alipayClient.execute(alipayTradeRefundRequest);
		if (response.isSuccess()) {
//            orderInfo.setStatus("以退款");
			orderInfoDao.updateOrder(orderInfo);
			return AjaxResult.success();
		} else {
			return AjaxResult.error(response.getCode(), response.getSubMsg());
		}
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppPrivateKey() {
		return appPrivateKey;
	}

	public void setAppPrivateKey(String appPrivateKey) {
		this.appPrivateKey = appPrivateKey;
	}

	public String getAlipayPublicKey() {
		return alipayPublicKey;
	}

	public void setAlipayPublicKey(String alipayPublicKey) {
		this.alipayPublicKey = alipayPublicKey;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
