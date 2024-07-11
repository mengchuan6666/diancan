package com.qnbc.venueReservation.param;

import com.qnbc.venueReservation.entity.Menu;
import com.qnbc.venueReservation.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 接受前端登录请求的参数
 */
@Data
public class UserRequest extends User {
	private String token;
	private List<Menu> menus;

	@ApiModelProperty(name = "教工工号", notes = "")
	private String jobNo;
}
