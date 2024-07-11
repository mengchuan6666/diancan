package com.qnbc.venueReservation.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品评论对象 comment
 *
 * @author guzj
 * @date 2023-12-27
 */
@Getter
@Setter
@Data
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
	private Date addtime;

	/**
	 * 关联表id
	 */
	@Excel(name = "关联表id")
	private Long refid;

	/**
	 * 用户id
	 */
	@Excel(name = "用户id")
	private Long userid;

	/**
	 * 用户名
	 */
	@Excel(name = "用户名")
	private String nickname;

	/**
	 * 评论内容
	 */
	@Excel(name = "评论内容")
	private String content;

	/**
	 * 回复内容
	 */
	@Excel(name = "回复内容")
	private String reply;

	@TableField(exist = false)
	private List<OrderDetail> orderDetails;
}
