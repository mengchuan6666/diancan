package com.qnbc.venueReservation.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.qnbc.venueReservation.core.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 订单对象 orders_site
 *
 * @author ruoyi
 * @date 2023-08-13
 */
public class OrdersSite {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

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
	 * 费用
	 */
	@Excel(name = "费用")
	private BigDecimal siteFee;

	/**
	 * 订单 id
	 */
	@Excel(name = "订单 id")
	private String orderId;

	/**
	 * 支付凭证
	 */
	@Excel(name = "支付凭证")
	private String sitePayKey;

	/**
	 * 付款状态（1 已支付  2 未支付 3 申请退款 4已退款 5已完成）
	 */
	@Excel(name = "付款状态", readConverterExp = "1=,已=支付,2=,未=支付,3=,申=请退款,4=已退款,5=已完成")
	private String payStatus;

	/**
	 * 是否删除（1 未删除  2 删除）
	 */
	@Excel(name = "是否删除", readConverterExp = "1=,未=删除,2=,删=除")
	private Long deleted;

	/**
	 * 乐观锁
	 */
	@Excel(name = "乐观锁")
	private Long revision;

	/**
	 * 创建人
	 */
	@Excel(name = "创建人")
	private String createdBy;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date createdTime;

	/**
	 * 更新人
	 */
	@Excel(name = "更新人")
	private String updatedBy;

	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date updatedTime;

	/**
	 * 场馆 id
	 */
	@Excel(name = "场馆 id")
	private Long venueId;

	/**
	 * 场馆名称
	 */
	@Excel(name = "场馆名称")
	private String venueName;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
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

	public void setSiteFee(BigDecimal siteFee) {
		this.siteFee = siteFee;
	}

	public BigDecimal getSiteFee() {
		return siteFee;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setSitePayKey(String sitePayKey) {
		this.sitePayKey = sitePayKey;
	}

	public String getSitePayKey() {
		return sitePayKey;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setDeleted(Long deleted) {
		this.deleted = deleted;
	}

	public Long getDeleted() {
		return deleted;
	}

	public void setRevision(Long revision) {
		this.revision = revision;
	}

	public Long getRevision() {
		return revision;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}

	public Long getVenueId() {
		return venueId;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueName() {
		return venueName;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("siteId", getSiteId())
			.append("siteName", getSiteName())
			.append("siteUseDate", getSiteUseDate())
			.append("siteUseTime", getSiteUseTime())
			.append("siteFee", getSiteFee())
			.append("orderId", getOrderId())
			.append("sitePayKey", getSitePayKey())
			.append("payStatus", getPayStatus())
			.append("deleted", getDeleted())
			.append("revision", getRevision())
			.append("createdBy", getCreatedBy())
			.append("createdTime", getCreatedTime())
			.append("updatedBy", getUpdatedBy())
			.append("updatedTime", getUpdatedTime())
			.append("venueId", getVenueId())
			.append("venueName", getVenueName())
			.toString();
	}
}
