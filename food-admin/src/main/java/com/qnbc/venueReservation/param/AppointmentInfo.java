package com.qnbc.venueReservation.param;

import com.qnbc.venueReservation.core.annotation.Excel;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author gzj
 * @Date 2023/8/14 14:52
 * @Version 1.0
 **/

@Data
public class AppointmentInfo {

	private List<TimeValue> value;

	/**
	 * 场地id
	 */
	private String siteId;

	/**
	 * 场地名称
	 */
	private String siteName;




}
