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
 * 运动分类管理对象 exercise_type
 *
 * @author guzj
 * @date 2023-07-23
 */
public class ExerciseType  implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 运动分类标识
	 */
	@Excel(name = "运动分类标识")
	private String exerciseTypeSign;

	/**
	 * 运动分类名称
	 */
	@Excel(name = "运动分类名称")
	private String exerciseTypeName;

	/**
	 * 是否半场
	 */
	@Excel(name = "是否半场")
	private String isHalfCourt;
	/**
	 * 分类图片
	 */
	@Excel(name = "图片")
	private String pic;

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


	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
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

	public void setExerciseTypeName(String exerciseTypeName) {
		this.exerciseTypeName = exerciseTypeName;
	}

	public String getExerciseTypeName() {
		return exerciseTypeName;
	}

	public void setIsHalfCourt(String isHalfCourt) {
		this.isHalfCourt = isHalfCourt;
	}

	public String getIsHalfCourt() {
		return isHalfCourt;
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
			.append("exerciseTypeSign", getExerciseTypeSign())
			.append("exerciseTypeName", getExerciseTypeName())
			.append("isHalfCourt", getIsHalfCourt())
			.append("deleted", getDeleted())
			.append("revision", getRevision())
			.append("createdBy", getCreatedBy())
			.append("createdTime", getCreatedTime())
			.append("updatedBy", getUpdatedBy())
			.append("updatedTime", getUpdatedTime())
			.toString();
	}
}
