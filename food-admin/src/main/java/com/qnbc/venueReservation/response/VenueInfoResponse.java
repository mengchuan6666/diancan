package com.qnbc.venueReservation.response;

import com.qnbc.venueReservation.domain.ExerciseType;
import com.qnbc.venueReservation.domain.VenueInfo;
import com.qnbc.venueReservation.dto.DateDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author gzj
 * @Date 2023/7/31 10:33
 * @Version 1.0
 **/

@Data
public class VenueInfoResponse extends VenueInfo {
	/**
	 * 运动类别
	 */
	private List<ExerciseType> exerciseTypes;

	/**
	 * 预约日期
	 */
	private List<DateDTO> dateDTOS;
}

