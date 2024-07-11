package com.qnbc.venueReservation.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 【请填写功能名称】对象 address
 *
 * @author guzj
 * @date 2023-12-27
 */
public class Address extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** openId微信用户ID */
    @Excel(name = "openId微信用户ID")
    private String userid;

    /** 收货地址 */
    @Excel(name = "收货地址")
    private String address;

    /** 收货人 */
    @Excel(name = "收货人")
    private String consignee;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String telnumber;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdate;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getUserid()
    {
        return userid;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setConsignee(String consignee)
    {
        this.consignee = consignee;
    }

    public String getConsignee()
    {
        return consignee;
    }
    public void setTelnumber(String telnumber)
    {
        this.telnumber = telnumber;
    }

    public String getTelnumber()
    {
        return telnumber;
    }
    public void setCreatedate(Date createdate)
    {
        this.createdate = createdate;
    }

    public Date getCreatedate()
    {
        return createdate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userid", getUserid())
            .append("address", getAddress())
            .append("consignee", getConsignee())
            .append("telnumber", getTelnumber())
            .append("createdate", getCreatedate())
            .toString();
    }
}
