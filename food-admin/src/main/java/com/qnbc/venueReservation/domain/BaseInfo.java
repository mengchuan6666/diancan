package com.qnbc.venueReservation.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.qnbc.venueReservation.core.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 基本信息配置对象 base_info
 *
 * @author guzj
 * @date 2023-08-05
 */
public class BaseInfo implements Serializable {
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
	private String nameKey;

	/**
	 * 开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date startTime;

	/**
	 * 结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date endTime;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setNameKey(String nameKey) {
		this.nameKey = nameKey;
	}

	public String getNameKey() {
		return nameKey;
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

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("nameKey", getNameKey())
			.append("startTime", getStartTime())
			.append("endTime", getEndTime())
			.toString();
	}
}
