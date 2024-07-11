package com.qnbc.venueReservation.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 【请填写功能名称】对象 collect
 *
 * @author guzj
 * @date 2023-12-27
 */
@Data
@Getter
@Setter
public class Collect implements Serializable {
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
	@Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
	private String userid;

	/**
	 * $column.columnComment
	 */
	@Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
	private Long productid;

	@TableField(select = false)
	private String productName;

	@TableField(select = false)
	private BigDecimal price;

	@TableField(select = false)
	private String proPic;


}
