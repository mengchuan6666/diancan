package com.qnbc.venueReservation.param;

import com.qnbc.venueReservation.core.annotation.Excel;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author gzj
 * @Date 2023/8/14 22:29
 * @Version 1.0
 **/

@Data
public class TimeValue {

	//日期
	private Date data;

	//时间
	private List<String> time;



}
