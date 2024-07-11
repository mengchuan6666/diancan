package com.qnbc.venueReservation.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 教职员工对象 faculty_staff
 *
 * @author guzj
 * @date 2023-07-23
 */
public class FacultyStaff implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
	@JsonSerialize(using = ToStringSerializer.class)
    private Long id;

	private String staffName;


	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .toString();
    }
}
