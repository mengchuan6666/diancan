package com.qnbc.venueReservation.response;

import com.qnbc.venueReservation.entity.Menu;
import com.qnbc.venueReservation.entity.User;
import lombok.Data;

import java.util.List;

/**
 * 接受前端登录请求的参数
 */
@Data
public class UserResponse extends User {
	private Integer id;
	private String username;
	private String password;
	private String nickname;
	private String avatarUrl;
	private String token;
	private String role;
	private List<Menu> menus;
}
