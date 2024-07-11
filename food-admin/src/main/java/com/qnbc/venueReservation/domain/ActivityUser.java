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
 * 活动报名用户对象 activity_user
 *
 * @author guzj
 * @date 2023-08-05
 */
public class ActivityUser implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 活动名称
	 */
	@Excel(name = "活动id")
	private String activityId;

	@Excel(name = "活动名称")
	@TableField(exist = false)
	private String activityName;

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
	 * 姓名
	 */
	@Excel(name = "姓名")
	private String usernameActivity;

	/**
	 * 联系电话
	 */
	@Excel(name = "联系电话")
	private String usernamePhone;

	/**
	 * 单位名称
	 */
	@Excel(name = "单位名称")
	private String usernameCompany;
	private String userPic;
	private String openId;

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
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

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityId() {
		return activityId;
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

	public void setUsernameActivity(String usernameActivity) {
		this.usernameActivity = usernameActivity;
	}

	public String getUsernameActivity() {
		return usernameActivity;
	}

	public void setUsernamePhone(String usernamePhone) {
		this.usernamePhone = usernamePhone;
	}

	public String getUsernamePhone() {
		return usernamePhone;
	}

	public void setUsernameCompany(String usernameCompany) {
		this.usernameCompany = usernameCompany;
	}

	public String getUsernameCompany() {
		return usernameCompany;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("activityId", getActivityId())
			.append("deleted", getDeleted())
			.append("createdBy", getCreatedBy())
			.append("createdTime", getCreatedTime())
			.append("updatedBy", getUpdatedBy())
			.append("updatedTime", getUpdatedTime())
			.append("usernameActivity", getUsernameActivity())
			.append("usernamePhone", getUsernamePhone())
			.append("usernameCompany", getUsernameCompany())
			.toString();
	}
}
