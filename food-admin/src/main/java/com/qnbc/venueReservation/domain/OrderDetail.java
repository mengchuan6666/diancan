package com.qnbc.venueReservation.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 【请填写功能名称】对象 order_detail
 *
 * @author guzj
 * @date 2023-12-27
 */
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@ApiModelProperty("id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 订单主表ID
	 */
	@Excel(name = "订单主表ID")
	private Long mid;

	/**
	 * 商品ID
	 */
	@Excel(name = "商品ID")
	private Long goodsid;

	/**
	 * 商品购买数量
	 */
	@Excel(name = "商品购买数量")
	private Long goodsnumber;

	/**
	 * 商品单价
	 */
	@Excel(name = "商品单价")
	private BigDecimal goodsprice;

	/**
	 * 商品名称
	 */
	@Excel(name = "商品名称")
	private String goodsname;

	/**
	 * 商品图片
	 */
	@Excel(name = "商品图片")
	private String goodspic;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public Long getMid() {
		return mid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public Long getGoodsid() {
		return goodsid;
	}

	public void setGoodsnumber(Long goodsnumber) {
		this.goodsnumber = goodsnumber;
	}

	public Long getGoodsnumber() {
		return goodsnumber;
	}

	public void setGoodsprice(BigDecimal goodsprice) {
		this.goodsprice = goodsprice;
	}

	public BigDecimal getGoodsprice() {
		return goodsprice;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodspic(String goodspic) {
		this.goodspic = goodspic;
	}

	public String getGoodspic() {
		return goodspic;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("mid", getMid())
			.append("goodsid", getGoodsid())
			.append("goodsnumber", getGoodsnumber())
			.append("goodsprice", getGoodsprice())
			.append("goodsname", getGoodsname())
			.append("goodspic", getGoodspic())
			.toString();
	}
}
