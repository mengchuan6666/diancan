package com.qnbc.venueReservation.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author gzj
 * @description TODO
 * @date 2024/1/2 15:28
 */
@Setter
@Getter
public class GetOrderCount {
	private String date;
	private String orderCount;
	private BigDecimal orderAmount;
}
