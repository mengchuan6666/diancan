package com.qnbc.venueReservation.param;

/**
 * @Description TODO
 * @Author gzj
 * @Date 2023/7/29 10:44
 * @Version 1.0
 **/

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;


@Data
public class WechatLoginRequest {

	//登录时获取的 code，可通过wx.login获取

	@ApiModelProperty(value = "微信code", required = true)
	private String code;

	//这个入参其实里面包含了用户的信息 下面的impl层 就是解析这个json获取用户信息
	@ApiModelProperty(value = "用户非敏感字段")
	private String rawData;

	@ApiModelProperty(value = "签名")
	private String signature;

	@ApiModelProperty(value = "用户敏感字段")
	private String encryptedData;

	@ApiModelProperty(value = "解密向量")
	private String iv;
}
