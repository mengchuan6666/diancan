package com.qnbc.venueReservation.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.qnbc.venueReservation.core.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 关于我们对象 about_me
 *
 * @author guzj
 * @date 2023-08-05
 */
@Setter
@Getter
@ApiModel(value = "餐厅信息账单表", description = "分页查询参数")
public class AboutMe implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */

	@ApiModelProperty("id")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 名称
	 */
	@Excel(name = "名称")
	private String name;
	/**
	 * 名称
	 */
	@Excel(name = "名称")
	private String phone;
	/**
	 * 名称
	 */
	@Excel(name = "名称")
	private String address;

	/**
	 * 描述
	 */
	@Excel(name = "描述")
	private String content;

	/**
	 * 图片
	 */
	@Excel(name = "图片 ")
	private String pic;


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPic() {
		return pic;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("name", getName())
			.append("content", getContent())
			.append("pic", getPic())
			.toString();
	}
}
