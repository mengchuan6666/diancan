package com.qnbc.venueReservation.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gzj
 * @description TODO
 * @date 2024/1/14 11:43
 */
@Data
@Setter
@Getter
public class AlipayDto {
	String id;
	String price;
	String title;
}
