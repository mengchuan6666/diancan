package com.qnbc.venueReservation.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 充值配置对象 pay_set
 *
 * @author guzj
 * @date 2023-07-23
 */
public class PaySet implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 充值起点
	 */
	@Excel(name = "充值起点")
	private String payStart;

	/**
	 * 积分兑换比例
	 */
	@Excel(name = "积分兑换比例")
	private String conversionRatio;

	/**
	 * 充值类型（1 普通充值 2 大额充值）
	 */
	@Excel(name = "充值类型", readConverterExp = "1 普通充值, 2 大额充值")
	private String paySetType;

	/**
	 * 积分有效期
	 */
	@Excel(name = "积分有效期")
	private String integralValidity;

	/**
	 * 退款人图片
	 */
	private String refundPic;

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


	public String getRefundPic() {
		return refundPic;
	}

	public void setRefundPic(String refundPic) {
		this.refundPic = refundPic;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setPayStart(String payStart) {
		this.payStart = payStart;
	}

	public String getPayStart() {
		return payStart;
	}

	public void setConversionRatio(String conversionRatio) {
		this.conversionRatio = conversionRatio;
	}

	public String getConversionRatio() {
		return conversionRatio;
	}

	public void setPaySetType(String paySetType) {
		this.paySetType = paySetType;
	}

	public String getPaySetType() {
		return paySetType;
	}

	public void setIntegralValidity(String integralValidity) {
		this.integralValidity = integralValidity;
	}

	public String getIntegralValidity() {
		return integralValidity;
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

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("payStart", getPayStart())
			.append("conversionRatio", getConversionRatio())
			.append("paySetType", getPaySetType())
			.append("integralValidity", getIntegralValidity())
			.append("deleted", getDeleted())
			.append("revision", getRevision())
			.append("createdBy", getCreatedBy())
			.append("createdTime", getCreatedTime())
			.append("updatedBy", getUpdatedBy())
			.append("updatedTime", getUpdatedTime())
			.toString();
	}
}
