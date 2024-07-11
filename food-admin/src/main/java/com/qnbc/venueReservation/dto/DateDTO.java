package com.qnbc.venueReservation.dto;

import lombok.Data;

/**
 * @Description 日期
 * @Author gzj
 * @Date 2023/7/31 10:44
 * @Version 1.0
 **/

@Data
public class DateDTO {

	//日期
	private String dateRi;

	//周几
	private String weekRi;

	//索引  本周的第几天
	private  int index;
}
