package com.qnbc.venueReservation.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;


/**
 * 【请填写功能名称】对象 order
 *
 * @author guzj
 * @date 2023-12-27
 */
@Data
@Getter
@Setter
@ApiModel(value = "订单表", description = "分页查询参数")
public class FoodOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.columnComment
	 */

	@ApiModelProperty("id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 订单号
	 */
	@Excel(name = "订单号")
	private String orderno;

	/**
	 * openId微信用户ID
	 */
	@Excel(name = "openId微信用户ID")
	private String userid;

	/**
	 * 总价
	 */
	@Excel(name = "总价")
	private BigDecimal totalprice;

	/**
	 * 收货地址
	 */
	@Excel(name = "收货地址")
	private String address;

	/**
	 * 收货人
	 */
	@Excel(name = "收货人")
	private String consignee;

	/**
	 * 联系电话
	 */
	@Excel(name = "联系电话")
	private String telnumber;

	/**
	 * 订单创建日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "订单创建日期", width = 30, dateFormat = "yyyy-MM-dd")
	private Date createdate;


	/**
	 * 订单过期日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "订单过期日期", width = 30, dateFormat = "yyyy-MM-dd")
	private Date outTimeDate;

	/**
	 * 订单支付日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "订单支付日期", width = 30, dateFormat = "yyyy-MM-dd")
	private Date paydate;

	/**
	 * 订单状态 1 取消订单 2 待上餐 3 评价  4 完成
	 */
	@Excel(name = "订单状态 0 未支付 1 已经支付")
	private Long status;

	/**
	 * 订单状态 0 未支付 1 已经支付
	 */
	@Excel(name = "订单是否开始制作状态 0 未开始 1 已开始")
	private Long createdStatus;

	private String alipayTraceNo;

	/**
	 * 订单id
	 */
	private String orderId;

	/**
	 * 桌号
	 */
	@ApiModelProperty("桌号")
	private String tableNum;

	/**
	 * 就餐人数
	 */
	@ApiModelProperty("就餐人数")
	private String eatNum;

	/**
	 * 备注
	 */
	@ApiModelProperty("备注")
	private String message;


	@TableField(exist = false)
	private List<OrderDetail> goods;//订单商品详情
}
