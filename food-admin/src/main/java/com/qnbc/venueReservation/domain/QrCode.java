package com.qnbc.venueReservation.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 二维码管理对象 QR_code
 *
 * @author guzj
 * @date 2023-12-27
 */
public class QrCode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
	@ApiModelProperty("id")
	@TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /** 餐厅 id */
    @Excel(name = "餐厅 id")
    private String canteenId;

    /** 桌号 */
    @Excel(name = "桌号")
    private String tableNum;

    /** 二维码图片 */
    @Excel(name = "二维码图片")
    private String codeUrl;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createdBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updatedBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCanteenId(String canteenId)
    {
        this.canteenId = canteenId;
    }

    public String getCanteenId()
    {
        return canteenId;
    }
    public void setTableNum(String tableNum)
    {
        this.tableNum = tableNum;
    }

    public String getTableNum()
    {
        return tableNum;
    }
    public void setCodeUrl(String codeUrl)
    {
        this.codeUrl = codeUrl;
    }

    public String getCodeUrl()
    {
        return codeUrl;
    }
    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }
    public void setCreatedTime(Date createdTime)
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime()
    {
        return createdTime;
    }
    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy()
    {
        return updatedBy;
    }
    public void setUpdatedTime(Date updatedTime)
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime()
    {
        return updatedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("canteenId", getCanteenId())
            .append("tableNum", getTableNum())
            .append("codeUrl", getCodeUrl())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
