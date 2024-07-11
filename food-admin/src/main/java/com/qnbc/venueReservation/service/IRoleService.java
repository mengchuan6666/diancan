package com.qnbc.venueReservation.service;

import com.qnbc.venueReservation.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qnbc.venueReservation.param.RoleMenuRequest;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author
 * @since 2022-02-10
 */
public interface IRoleService extends IService<Role> {

    void setRoleMenu(Integer roleId, RoleMenuRequest menuIds);

    List<Integer> getRoleMenu(Integer roleId);
}
