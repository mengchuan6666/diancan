package com.qnbc.venueReservation.dto;

import com.qnbc.venueReservation.core.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 订单对象 orders
 *
 * @author guzj
 * @date 2023-07-23
 */
public class SiteAppointmentDto implements Serializable {

	/**
	 * 场地id
	 */

	@Excel(name = "场地id")
	private String siteId;

	/**
	 * 场地名称
	 */
	@Excel(name = "场地名称")
	private String siteName;


	/**
	 * 场地使用日期
	 */
	@Excel(name = "场地使用日期")
	private String siteUseDate;

	/**
	 * 场地使用时间
	 */
	@Excel(name = "场地使用时间")
	private String siteUseTime;

	/**
	 * openid
	 */
	@Excel(name = "用户 ID")
	private String openId;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteUseDate(String siteUseDate) {
		this.siteUseDate = siteUseDate;
	}

	public String getSiteUseDate() {
		return siteUseDate;
	}

	public void setSiteUseTime(String siteUseTime) {
		this.siteUseTime = siteUseTime;
	}

	public String getSiteUseTime() {
		return siteUseTime;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("siteId", getSiteId())
			.append("siteName", getSiteName())
			.append("siteUseDate", getSiteUseDate())
			.append("siteUseTime", getSiteUseTime())
			.toString();
	}
}
