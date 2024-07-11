package com.qnbc.venueReservation.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 【请填写功能名称】对象 cart
 *
 * @author guzj
 * @date 2023-12-27
 */

@Setter
@Getter
@Data
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.columnComment
	 */
	@ApiModelProperty("id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * $column.columnComment
	 */
	private String productid;

	/**
	 * $column.columnComment
	 */
	private String userid;

	/**
	 * $column.columnComment
	 */
	private Integer num;

	/**
	 * $column.columnComment
	 */
	private String size;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createTime;


	@TableField(exist = false)
	private String userName;

	@TableField(exist = false)
	private String name;

	@TableField(exist = false)
	private String propic;

	@TableField(exist = false)
	private BigDecimal price;

	@TableField(exist = false)
	private int stock;


}
