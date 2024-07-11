package com.qnbc.venueReservation.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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


/**
 * 【请填写功能名称】对象 product_swiper_image
 *
 * @author guzj
 * @date 2023-12-27
 */
@Data
@Setter
@Getter
public class ProductSwiperImage implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */

	@ApiModelProperty("id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 图片
	 */
	@Excel(name = "图片")
	private String image;

	/**
	 * 排序
	 */
	@Excel(name = "排序")
	private Long sort;

	/**
	 * 所属商品id
	 */
	@Excel(name = "所属商品id")
	private Long productid;

}
