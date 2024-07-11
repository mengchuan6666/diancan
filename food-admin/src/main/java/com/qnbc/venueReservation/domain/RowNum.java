package com.qnbc.venueReservation.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 排号记录对象 row_num
 *
 * @author guzj
 * @date 2023-12-27
 */
public class RowNum extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 餐厅 id */
    @Excel(name = "餐厅 id")
    private String canteenId;

    /** 号码 */
    @Excel(name = "号码")
    private Long getNum;

    /** 预计等待时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计等待时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date waitTime;

    /** 桌号 */
    @Excel(name = "桌号")
    private Long tableNum;

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
    public void setGetNum(Long getNum)
    {
        this.getNum = getNum;
    }

    public Long getGetNum()
    {
        return getNum;
    }
    public void setWaitTime(Date waitTime)
    {
        this.waitTime = waitTime;
    }

    public Date getWaitTime()
    {
        return waitTime;
    }
    public void setTableNum(Long tableNum)
    {
        this.tableNum = tableNum;
    }

    public Long getTableNum()
    {
        return tableNum;
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
            .append("getNum", getGetNum())
            .append("waitTime", getWaitTime())
            .append("tableNum", getTableNum())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
