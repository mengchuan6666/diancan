package com.qnbc.venueReservation.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * wxpayinfo对象 wx_pay_info
 *
 * @author guzj
 * @date 2023-10-03
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WxPayInfo extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.columnComment
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * $column.columnComment
	 */
	@Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
	private String appId;

	/**
	 * $column.columnComment
	 */
	@Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
	private String timeStamp;

	/**
	 * $column.columnComment
	 */
	@Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
	private String nonceStr;

	/**
	 * $column.columnComment
	 */
	@Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
	private String packageVal;

	/**
	 * $column.columnComment
	 */
	@Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
	private String signType;

	/**
	 * $column.columnComment
	 */
	@Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
	private String paySign;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getSignType() {
		return signType;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}

	public String getPaySign() {
		return paySign;
	}

	public String getPackageVal() {
		return packageVal;
	}

	public void setPackageVal(String packageVal) {
		this.packageVal = packageVal;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("appid", getAppId())
			.append("timeStamp", getTimeStamp())
			.append("nonceStr", getNonceStr())
			.append("packageVal", getPackageVal())
			.append("signType", getSignType())
			.append("paySign", getPaySign())
			.toString();
	}
}
