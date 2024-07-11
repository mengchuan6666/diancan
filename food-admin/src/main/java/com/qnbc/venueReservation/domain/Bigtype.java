package com.qnbc.venueReservation.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;


/**
 * 【请填写功能名称】对象 bigtype
 *
 * @author guzj
 * @date 2023-12-27
 */


@Data
public class Bigtype implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@ApiModelProperty("id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 商品大类名称
	 */
	@Excel(name = "商品大类名称")
	private String name;

	/**
	 * 大类封面图片
	 */
	@Excel(name = "大类封面图片")
	private String image;

	private String remark;

	@TableField(select = false)
	private List<Smalltype> smallTypeList;//商品小类集合

}
