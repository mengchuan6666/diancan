package com.qnbc.venueReservation.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.qnbc.venueReservation.core.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 学生导入数据对象 user_student
 *
 * @author guzj
 * @date 2023-08-07
 */
public class UserStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 用户名
	 */
	@ExcelProperty("姓名")
	@Excel(name = "姓名")
	private String username;

	/**
	 * 电话
	 */
	@ExcelProperty("电话")
	@Excel(name = "电话")
	private String phone;

	/**
	 * 学号
	 */
	@ExcelProperty("学号")
	@Excel(name = "学号")
	private String schoolNum;

	/**
	 * 专业
	 */
	@ExcelProperty("专业")
	@Excel(name = "专业")
	private String studentMajor;

	/**
	 * 年级
	 */
	@ExcelProperty("年级")
	@Excel(name = "年级")
	private String studentClass;

	/**
	 * 照片
	 */
	@ExcelProperty("照片")
	@Excel(name = "照片")
	private String studentPic;

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

	public void setSchoolNum(String schoolNum) {
		this.schoolNum = schoolNum;
	}

	public String getSchoolNum() {
		return schoolNum;
	}

	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}

	public String getStudentMajor() {
		return studentMajor;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentPic(String studentPic) {
		this.studentPic = studentPic;
	}

	public String getStudentPic() {
		return studentPic;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("username", getUsername())
			.append("phone", getPhone())
			.append("schoolNum", getSchoolNum())
			.append("studentMajor", getStudentMajor())
			.append("studentClass", getStudentClass())
			.append("studentPic", getStudentPic())
			.toString();
	}
}
