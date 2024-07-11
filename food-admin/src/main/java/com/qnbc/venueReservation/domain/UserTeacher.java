package com.qnbc.venueReservation.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * 教工导入数据对象 user_teacher
 *
 * @author guzj
 * @date 2023-10-11
 */
public class UserTeacher {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 姓名
	 */
	@Excel(name = "姓名")
	private String username;

	/**
	 * 电话
	 */
	@Excel(name = "电话")
	private String phone;

	/**
	 * 工号
	 */
	@Excel(name = "工号")
	private String jobNo;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getJobNo() {
		return jobNo;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("username", getUsername())
			.append("phone", getPhone())
			.append("jobNo", getJobNo())
			.toString();
	}
}
