package com.qnbc.venueReservation.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.qnbc.venueReservation.core.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户积分对象 integral
 *
 * @author guzj
 * @date 2023-08-10
 */
public class Integral implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 积分
	 */
	@Excel(name = "积分")
	private BigDecimal userIntegral;

	/**
	 * 用户id
	 */
	@Excel(name = "用户id")
	private String userId;

	/**
	 * 微信 id
	 */
	@Excel(name = "微信 id")
	private String openId;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setUserIntegral(BigDecimal userIntegral) {
		this.userIntegral = userIntegral;
	}

	public BigDecimal getUserIntegral() {
		return userIntegral;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getOpenId() {
		return openId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("integral", getUserIntegral())
			.append("userId", getUserId())
			.append("openId", getOpenId())
			.toString();
	}
}
