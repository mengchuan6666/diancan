package com.qnbc.venueReservation.domain;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;


/**
 * 【请填写功能名称】对象 smalltype
 *
 * @author guzj
 * @date 2023-12-27
 */
@Data
public class Smalltype implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	private Long id;

	/**
	 * 商品小类
	 */
	@Excel(name = "商品小类")
	private String name;

	private String remark;

	/**
	 * 商品大类编号
	 */
	@Excel(name = "商品大类编号")
	private Long bigtypeid;

	@TableField(select = false)
	private List<Product> productList;//商品集合

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
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

	public void setBigtypeid(Long bigtypeid) {
		this.bigtypeid = bigtypeid;
	}

	public Long getBigtypeid() {
		return bigtypeid;
	}

}
