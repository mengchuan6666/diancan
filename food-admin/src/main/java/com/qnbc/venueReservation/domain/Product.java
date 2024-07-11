package com.qnbc.venueReservation.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 【商品详情】对象 product
 *
 * @author guzj
 * @date 2023-12-27
 */

@Getter
@Setter
@TableName("product")
@ApiModel(value = "商品对象", description = "")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */

	@ApiModelProperty("id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 商品名称
	 */
	@Excel(name = "商品名称")
	private String name;

	/**
	 * 商品价格
	 */
	@Excel(name = "商品价格")
	private BigDecimal price;

	/**
	 * 库存
	 */
	@Excel(name = "库存")
	private Long stock;

	/**
	 * 商品图片
	 */
	@Excel(name = "商品图片")
	private String propic;

	/**
	 * 是否热门推荐商品
	 */
	@Excel(name = "是否热门推荐商品")
	private Integer ishot;

	/**
	 * 是否轮播图片商品
	 */
	@Excel(name = "是否轮播图片商品")
	private Integer isswiper;

	/**
	 * 商品轮播图片
	 */
	@Excel(name = "商品轮播图片")
	private String swiperpic;

	/**
	 * 轮播排序
	 */
	@Excel(name = "轮播排序")
	private Long swipersort;

	/**
	 * 商品类别编号
	 */
	@Excel(name = "商品类别编号")
	private Long typeid;

	/**
	 * 设置热卖日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "设置热卖日期", width = 30, dateFormat = "yyyy-MM-dd")
	private Date hotdatetime;

	/**
	 * 商品介绍图片
	 */
	@Excel(name = "商品介绍图片")
	private String productintroimgs;

	/**
	 * 商品规格参数图片
	 */
	@Excel(name = "商品规格参数图片")
	private String productparaimgs;

	/**
	 * 商品描述
	 */
	@Excel(name = "商品描述")
	private String description;

	private String proStatus;


	@TableField(select = false)
	private List<ProductSwiperImage> productSwiperImageList;

	@TableField(select = false)
	private List<Map<String, String>> sizeList;

	@TableField(select = false)
	private Smalltype type;//商品类别

	@TableField(select = false)
	private Integer collect;//收藏
	@TableField(select = false)
	private Integer pageNum;//收藏
	@TableField(select = false)
	private Integer pageSize;//收藏

}
