package com.qnbc.venueReservation.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * @Description TODO
 * @Author gzj
 * @Date 2023/7/8 15:28
 * @Version 1.0
 **/

public class FileResponse {


	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 文件名称
	 */
	private String fileName;

	/**
	 * 文件类型
	 */
	private String fileType;

	/**
	 * 业务主键
	 */
	private String bizKey;

	/**
	 * 业务名称
	 */
	private String bizName;

	/**
	 * 文件大小
	 */
	private int fileSize;

	/**
	 * 文件访问路径url
	 */
	private String fileUrl;

	/**
	 * 租户号
	 */
	private String tenantId;

	/**
	 * 乐观锁
	 */
	private String revision;

	/**
	 * 创建人
	 */
	private String createdBy;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdTime;

	/**
	 * 更新人
	 */
	private String updatedBy;

	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updatedTime;

	/**
	 * 是否有效（0 有效 1 删除）
	 */
	private Long isDeleted;


	private String remark;

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileType() {
		return fileType;
	}

	public void setBizKey(String bizKey) {
		this.bizKey = bizKey;
	}

	public String getBizKey() {
		return bizKey;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public String getBizName() {
		return bizName;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getRevision() {
		return revision;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setIsDeleted(Long isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getIsDeleted() {
		return isDeleted;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId()).append("fileName", getFileName()).append("fileType", getFileType()).append("bizKey", getBizKey()).append("bizName", getBizName()).append("fileUrl", getFileUrl()).append("tenantId", getTenantId()).append("revision", getRevision()).append("createdBy", getCreatedBy()).append("createdTime", getCreatedTime()).append("updatedBy", getUpdatedBy()).append("updatedTime", getUpdatedTime()).append("remark", getRemark()).append("isDeleted", getIsDeleted()).toString();
	}


}
