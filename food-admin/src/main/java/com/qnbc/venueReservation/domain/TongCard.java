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
 * 通卡管理对象 tong_card
 *
 * @author guzj
 * @date 2023-07-23
 */
public class TongCard implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 名称
	 */
	@Excel(name = "名称")
	private String cardName;

	/**
	 * 主题
	 */
	@Excel(name = "主题")
	private String cardThem;

	/**
	 * 服务范围
	 */
	@Excel(name = "服务范围")
	private String serviceScope;

	/**
	 * 金额
	 */
	@Excel(name = "金额")
	private Long cardMoney;

	/**
	 * 时间期限
	 */
	@Excel(name = "时间期限")
	private String deadline;

	/**
	 * 描述
	 */
	@Excel(name = "描述")
	private String cardDescription;

	/**
	 * 备注
	 */
	@Excel(name = "备注")
	private String cardRemark;

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

	private Long activityId;

	private String activityName;

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardThem(String cardThem) {
		this.cardThem = cardThem;
	}

	public String getCardThem() {
		return cardThem;
	}

	public void setServiceScope(String serviceScope) {
		this.serviceScope = serviceScope;
	}

	public String getServiceScope() {
		return serviceScope;
	}

	public void setCardMoney(Long cardMoney) {
		this.cardMoney = cardMoney;
	}

	public Long getCardMoney() {
		return cardMoney;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setCardDescription(String cardDescription) {
		this.cardDescription = cardDescription;
	}

	public String getCardDescription() {
		return cardDescription;
	}

	public void setCardRemark(String cardRemark) {
		this.cardRemark = cardRemark;
	}

	public String getCardRemark() {
		return cardRemark;
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
			.append("cardName", getCardName())
			.append("cardThem", getCardThem())
			.append("serviceScope", getServiceScope())
			.append("cardMoney", getCardMoney())
			.append("deadline", getDeadline())
			.append("cardDescription", getCardDescription())
			.append("cardRemark", getCardRemark())
			.append("deleted", getDeleted())
			.append("revision", getRevision())
			.append("createdBy", getCreatedBy())
			.append("createdTime", getCreatedTime())
			.append("updatedBy", getUpdatedBy())
			.append("updatedTime", getUpdatedTime())
			.toString();
	}
}
