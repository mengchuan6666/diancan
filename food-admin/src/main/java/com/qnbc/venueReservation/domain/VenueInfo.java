package com.qnbc.venueReservation.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * 场馆管理对象 venue_info
 *
 * @author guzj
 * @date 2023-07-23
 */
public class VenueInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 场馆名称
	 */
	@Excel(name = "场馆名称")
	private String venueName;

	/**
	 * 图片 1
	 */
	@Excel(name = "图片 1")
	private String pic1;

	/**
	 * 图片 2
	 */
	@Excel(name = "图片 2")
	private String pic2;

	/**
	 * 图片 3
	 */
	@Excel(name = "图片 3")
	private String pic3;

	/**
	 * 地址
	 */
	@Excel(name = "地址")
	private String venueAddress;

	/**
	 * 营业日期
	 */
	@Excel(name = "营业日期")
	private String venueDobusDate;

	/**
	 * 营业开始时间
	 */
	@Excel(name = "营业开始时间")
	private String dobusStartTime;

	/**
	 * 营业结束时间
	 */
	@Excel(name = "营业结束时间")
	private String dobusEndTime;

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
	 * 运动类别
	 */
	@Excel(name = "运动类别")
	private String exerciseTypeName;
	/**
	 * 运动类别标识
	 */
	@Excel(name = "运动类别标识")
	private String exerciseTypeSign;

	/**
	 * 撤销预约提前时间（单位：分）
	 */
	@Excel(name = "撤销预约提前时间", readConverterExp = "单=位：分")
	private String backAppointment;


	private String phone;

	/**
	 * 场地数
	 */
	private int siteNum;

	public int getSiteNum() {
		return siteNum;
	}

	public void setSiteNum(int siteNum) {
		this.siteNum = siteNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBackAppointment() {
		return backAppointment;
	}

	public void setBackAppointment(String backAppointment) {
		this.backAppointment = backAppointment;
	}

	public String getExerciseTypeSign() {
		return exerciseTypeSign;
	}

	public void setExerciseTypeSign(String exerciseTypeSign) {
		this.exerciseTypeSign = exerciseTypeSign;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}

	public String getPic3() {
		return pic3;
	}

	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}

	public String getVenueAddress() {
		return venueAddress;
	}

	public void setVenueDobusDate(String venueDobusDate) {
		this.venueDobusDate = venueDobusDate;
	}

	public String getVenueDobusDate() {
		return venueDobusDate;
	}

	public void setDobusStartTime(String dobusStartTime) {
		this.dobusStartTime = dobusStartTime;
	}

	public String getDobusStartTime() {
		return dobusStartTime;
	}

	public void setDobusEndTime(String dobusEndTime) {
		this.dobusEndTime = dobusEndTime;
	}

	public String getDobusEndTime() {
		return dobusEndTime;
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

	public void setExerciseTypeName(String exerciseTypeName) {
		this.exerciseTypeName = exerciseTypeName;
	}

	public String getExerciseTypeName() {
		return exerciseTypeName;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("venueName", getVenueName())
			.append("pic1", getPic1())
			.append("pic2", getPic2())
			.append("pic3", getPic3())
			.append("venueAddress", getVenueAddress())
			.append("venueDobusDate", getVenueDobusDate())
			.append("dobusStartTime", getDobusStartTime())
			.append("dobusEndTime", getDobusEndTime())
			.append("deleted", getDeleted())
			.append("revision", getRevision())
			.append("createdBy", getCreatedBy())
			.append("createdTime", getCreatedTime())
			.append("updatedBy", getUpdatedBy())
			.append("updatedTime", getUpdatedTime())
			.append("exerciseTypeName", getExerciseTypeName())
			.toString();
	}
}
