package com.qnbc.venueReservation.param;

import com.qnbc.venueReservation.domain.SiteInfo;
import lombok.Data;

/**
 * @Description TODO
 * @Author gzj
 * @Date 2023/8/12 17:52
 * @Version 1.0
 **/

@Data
public class SiteInfoRequest extends SiteInfo {

	/**
	 * 预约开始时间
	 */
	private String siteUseDate;

}
