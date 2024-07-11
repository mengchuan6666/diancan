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
 * 场地管理对象 site_info
 *
 * @author guzj
 * @date 2023-07-23
 */
public class SiteInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 运动类别id
	 */
	@Excel(name = "运动类别标识")
	private String exerciseTypeSign;

	/**
	 * 是否半场(0是  1否)
	 */
	@Excel(name = "是否半场")
	private String isExerciseType;

	/**
	 * 运动类别名称
	 */
	@Excel(name = "运动类别名称")
	private String exerciseTypeName;

	/**
	 * 场馆id
	 */
	@Excel(name = "场馆id")
	private String venueId;

	/**
	 * 场馆名称
	 */
	@Excel(name = "场馆名称")
	private String venueName;

	/**
	 * 场地名称
	 */
	@Excel(name = "场地名称")
	private String siteName;

	/**
	 * 开放时间
	 */
	@Excel(name = "开放时间")
	private String openTime;

	/**
	 * 关闭时间
	 */
	@Excel(name = "关闭时间")
	private String closeTime;

	/**
	 * 场地地址
	 */
	@Excel(name = "场地地址")
	private String siteAddress;

	/**
	 * 开放预约角色
	 */
	@Excel(name = "开放预约角色")
	private String siteRole;

	/**
	 * 是否删除（1 未删除  2 删除）
	 */
	@Excel(name = "是否删除", readConverterExp = "1未删除,2删除")
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
	 * 时间段
	 */
	@Excel(name = "时间段")
	private String feeTime;

	/**
	 * 价格
	 */
	@Excel(name = "价格")
	private String siteFee;
	private String siteFeeId;

	private int siteStatus;

	private String feeTimeStudent;
	private String feeTimeTeacher;
	private String feeTimeVip;
	private String siteFeeWorkDay;
	private String siteFeeHolidayDay;
	private String siteFeeWorkNight;
	private String siteFeeHolidayNight;

	/**
	 * 时间段
	 */
	@Excel(name = "时间段")
	private String feeTimeDay;
	/**
	 * 时间段
	 */
	@Excel(name = "时间段")
	private String feeTimeNight;


	public String getSiteFeeId() {
		return siteFeeId;
	}

	public void setSiteFeeId(String siteFeeId) {
		this.siteFeeId = siteFeeId;
	}

	public String getFeeTimeDay() {
		return feeTimeDay;
	}

	public void setFeeTimeDay(String feeTimeDay) {
		this.feeTimeDay = feeTimeDay;
	}

	public String getFeeTimeNight() {
		return feeTimeNight;
	}

	public void setFeeTimeNight(String feeTimeNight) {
		this.feeTimeNight = feeTimeNight;
	}

	public String getFeeTimeStudent() {
		return feeTimeStudent;
	}

	public void setFeeTimeStudent(String feeTimeStudent) {
		this.feeTimeStudent = feeTimeStudent;
	}

	public String getFeeTimeTeacher() {
		return feeTimeTeacher;
	}

	public void setFeeTimeTeacher(String feeTimeTeacher) {
		this.feeTimeTeacher = feeTimeTeacher;
	}

	public String getFeeTimeVip() {
		return feeTimeVip;
	}

	public void setFeeTimeVip(String feeTimeVip) {
		this.feeTimeVip = feeTimeVip;
	}

	public String getSiteFeeWorkDay() {
		return siteFeeWorkDay;
	}

	public void setSiteFeeWorkDay(String siteFeeWorkDay) {
		this.siteFeeWorkDay = siteFeeWorkDay;
	}

	public String getSiteFeeHolidayDay() {
		return siteFeeHolidayDay;
	}

	public void setSiteFeeHolidayDay(String siteFeeHolidayDay) {
		this.siteFeeHolidayDay = siteFeeHolidayDay;
	}

	public String getSiteFeeWorkNight() {
		return siteFeeWorkNight;
	}

	public void setSiteFeeWorkNight(String siteFeeWorkNight) {
		this.siteFeeWorkNight = siteFeeWorkNight;
	}

	public String getSiteFeeHolidayNight() {
		return siteFeeHolidayNight;
	}

	public void setSiteFeeHolidayNight(String siteFeeHolidayNight) {
		this.siteFeeHolidayNight = siteFeeHolidayNight;
	}

	public int getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(int siteStatus) {
		this.siteStatus = siteStatus;
	}

	public String getFeeTime() {
		return feeTime;
	}

	public void setFeeTime(String feeTime) {
		this.feeTime = feeTime;
	}

	public String getSiteFee() {
		return siteFee;
	}

	public void setSiteFee(String siteFee) {
		this.siteFee = siteFee;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setExerciseTypeSign(String exerciseTypeSign) {
		this.exerciseTypeSign = exerciseTypeSign;
	}

	public String getExerciseTypeSign() {
		return exerciseTypeSign;
	}

	public void setIsExerciseType(String isExerciseType) {
		this.isExerciseType = isExerciseType;
	}

	public String getIsExerciseType() {
		return isExerciseType;
	}

	public void setExerciseTypeName(String exerciseTypeName) {
		this.exerciseTypeName = exerciseTypeName;
	}

	public String getExerciseTypeName() {
		return exerciseTypeName;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public String getVenueId() {
		return venueId;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteRole(String siteRole) {
		this.siteRole = siteRole;
	}

	public String getSiteRole() {
		return siteRole;
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

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("exerciseTypeId", getExerciseTypeSign())
			.append("isExerciseType", getIsExerciseType())
			.append("exerciseTypeName", getExerciseTypeName())
			.append("venueId", getVenueId())
			.append("venueName", getVenueName())
			.append("siteName", getSiteName())
			.append("openTime", getOpenTime())
			.append("closeTime", getCloseTime())
			.append("siteAddress", getSiteAddress())
			.append("siteRole", getSiteRole())
			.append("deleted", getDeleted())
			.append("createdBy", getCreatedBy())
			.append("createdTime", getCreatedTime())
			.append("updatedBy", getUpdatedBy())
			.append("updatedTime", getUpdatedTime())
			.toString();
	}
}
