package com.qnbc.venueReservation.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.qnbc.venueReservation.core.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 活动对象 activity_info
 *
 * @author guzj
 * @date 2023-07-31
 */
public class ActivityInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 活动名称
	 */
	@Excel(name = "活动名称")
	private String activityName;

	/**
	 * 金额
	 */
	@Excel(name = "金额")
	private Long activityMoney;

	/**
	 * 开始日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
	private Date startTime;

	/**
	 * 结束日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
	private Date endTime;

	/**
	 * 注意事项
	 */
	@Excel(name = "注意事项")
	private String announcements;

	/**
	 * 场馆
	 */
	@Excel(name = "场馆")
	private Long venueId;
	/**
	 * 场馆
	 */
	@Excel(name = "场馆名称")
	private String venueName;

	/**
	 * 是否删除（1 未删除  2 删除）
	 */
	@Excel(name = "是否删除", readConverterExp = "1=,未=删除,2=,删=除")
	private Long deleted;

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
	 * 服务范围
	 */
	@Excel(name = "服务范围")
	private String serviceScope;

	/**
	 * 主题
	 */
	@Excel(name = "主题")
	private String cardThem;
	private String pic;

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityMoney(Long activityMoney) {
		this.activityMoney = activityMoney;
	}

	public Long getActivityMoney() {
		return activityMoney;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setAnnouncements(String announcements) {
		this.announcements = announcements;
	}

	public String getAnnouncements() {
		return announcements;
	}

	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}

	public Long getVenueId() {
		return venueId;
	}

	public void setDeleted(Long deleted) {
		this.deleted = deleted;
	}

	public Long getDeleted() {
		return deleted;
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

	public void setServiceScope(String serviceScope) {
		this.serviceScope = serviceScope;
	}

	public String getServiceScope() {
		return serviceScope;
	}

	public void setCardThem(String cardThem) {
		this.cardThem = cardThem;
	}

	public String getCardThem() {
		return cardThem;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("activityName", getActivityName())
			.append("activityMoney", getActivityMoney())
			.append("startTime", getStartTime())
			.append("endTime", getEndTime())
			.append("announcements", getAnnouncements())
			.append("venueId", getVenueId())
			.append("deleted", getDeleted())
			.append("createdBy", getCreatedBy())
			.append("createdTime", getCreatedTime())
			.append("updatedBy", getUpdatedBy())
			.append("updatedTime", getUpdatedTime())
			.append("serviceScope", getServiceScope())
			.append("cardThem", getCardThem())
			.toString();
	}
}
