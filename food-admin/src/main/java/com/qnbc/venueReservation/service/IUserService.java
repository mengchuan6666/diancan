package com.qnbc.venueReservation.service;

import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.dto.UserPasswordDTO;
import com.qnbc.venueReservation.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qnbc.venueReservation.param.UserRequest;
import com.qnbc.venueReservation.response.UserResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author
 * @since 2022-01-26
 */
public interface IUserService extends IService<User> {

    UserResponse login(UserRequest userDTO);

    User register(UserRequest userDTO);

    void updatePassword(UserPasswordDTO userPasswordDTO);

}
