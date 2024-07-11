package com.qnbc.venueReservation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户信息
 *
 * @author
 * @since 2022-01-26
 */
@Getter
@Setter
@TableName("sys_user")
@ApiModel(value = "User对象", description = "")
@ToString
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("id")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@ApiModelProperty("用户名")
	private String username;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("昵称")
	private String nickname;

	@ApiModelProperty("邮箱")
	private String email;

	@ApiModelProperty("电话")
	private String phone;

	@ApiModelProperty("地址")
	private String address;

	@JsonFormat(pattern = "yyyy-mm-dd HH:ss:mm")
	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("头像")
	private String avatarUrl;

	@ApiModelProperty("角色")
	private String role;

	@ApiModelProperty("微信唯一标识")
	private String openId;

	/**
	 * 学号
	 */
	@ApiModelProperty(name = "学号", notes = "")
	private String schoolNum;
	/**
	 * 专业
	 */
	@ApiModelProperty(name = "专业", notes = "")
	private String studentMajor;
	/**
	 * 年级
	 */
	@ApiModelProperty(name = "年级", notes = "")
	private String studentClass;
	/**
	 * 照片
	 */
	@ApiModelProperty(name = "照片", notes = "")
	private String studentPic;
	/**
	 * 微信昵称
	 */
	@ApiModelProperty(name = "微信昵称", notes = "")
	private String wechatNickname;
	/**
	 * 微信头像
	 */
	@ApiModelProperty(name = "微信头像", notes = "")
	private String wechatAvatar;

	/**
	 * 教工类型（1 在职教师 2 行政人员 3 后勤服务人员 4物业管理人员）
	 */
	@ApiModelProperty(name = "教工类型（1 在职教师 2 行政人员 3 后勤服务人员 4物业管理人员）", notes = "")
	private String teacheType;
	/**
	 * 教工部门
	 */
	@ApiModelProperty(name = "教工部门", notes = "")
	private String teacheDpte;

	/**
	 * VIP的单位信息
	 */
	@ApiModelProperty(name = "VIP的单位信息", notes = "")
	private String vipCompany;
	/**
	 * 审核原因
	 */
	@ApiModelProperty(name = "审核原因", notes = "")
	private String auditBecause;
	/**
	 * 审核状态（1 审核通过  2 未通过）
	 */
	@ApiModelProperty(name = "审核状态（1 审核通过  2 未通过）", notes = "")
	private String auditStatus;


}
