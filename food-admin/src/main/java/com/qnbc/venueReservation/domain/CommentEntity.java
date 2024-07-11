package com.qnbc.venueReservation.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 商品评论表
 * 数据库通用操作实体类（普通增删改查）
 *
 * @author
 * @email
 * @date 2022-05-03 10:36:55
 */
@Setter
@Getter
@TableName("comment")
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 关联表id
	 */

	private Long refid;

	/**
	 * 用户id
	 */

	private Long userid;

	/**
	 * 用户名
	 */

	private String nickname;

	/**
	 * 评论内容
	 */

	private String content;

	/**
	 * 回复内容
	 */

	private String reply;


	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;
}
