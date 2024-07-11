package com.qnbc.venueReservation.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.ehcache.spi.serialization.Serializer;
import org.ehcache.xml.model.SerializerType;


/**
 * 【请填写功能名称】对象 wxuserinfo
 *
 * @author guzj
 * @date 2023-12-27
 */
@Getter
@Data
public class Wxuserinfo  implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户编号
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 用户唯一标识
	 */
	@Excel(name = "用户唯一标识")
	private String openid;

	/**
	 * 用户昵称
	 */
	@Excel(name = "用户昵称")
	private String nickname;

	/**
	 * 用户头像图片的 URL
	 */
	@Excel(name = "用户头像图片的 URL")
	private String avatarurl;

	/**
	 * 注册日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "注册日期", width = 30, dateFormat = "yyyy-MM-dd")
	private Date registerdate;

	/**
	 * 最后登录日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Excel(name = "最后登录日期", width = 30, dateFormat = "yyyy-MM-dd")
	private Date lastlogindate;

	@TableField( exist = false)
	private String code;//微信用户code前端传来的


}
