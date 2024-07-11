package com.qnbc.venueReservation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
@TableName("config")
public class ConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 图片名称
	 */
	private String name;

	/**
	 * 图片链接
	 */
	private String value;

}
