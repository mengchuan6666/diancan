package com.qnbc.venueReservation.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.core.utils.StringUtils;
import com.qnbc.venueReservation.domain.Integral;
import com.qnbc.venueReservation.domain.UserTeacher;
import com.qnbc.venueReservation.dto.UserPasswordDTO;
import com.qnbc.venueReservation.exception.ServiceException;
import com.qnbc.venueReservation.common.Constants;
import com.qnbc.venueReservation.entity.Menu;
import com.qnbc.venueReservation.entity.User;
import com.qnbc.venueReservation.mapper.RoleMapper;
import com.qnbc.venueReservation.mapper.RoleMenuMapper;
import com.qnbc.venueReservation.mapper.UserMapper;
import com.qnbc.venueReservation.param.UserRequest;
import com.qnbc.venueReservation.response.UserResponse;
import com.qnbc.venueReservation.service.IMenuService;
import com.qnbc.venueReservation.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qnbc.venueReservation.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author
 * @since 2022-01-26
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


	@Resource
	private UserMapper userMapper;


	@Resource
	private RoleMapper roleMapper;

	@Resource
	private RoleMenuMapper roleMenuMapper;

	@Resource
	private IMenuService menuService;


	@Override
	public UserResponse login(UserRequest userDTO) {
		User one = getUserInfo(userDTO);
		UserResponse userResponse = new UserResponse();
		if (one != null) {
			BeanUtil.copyProperties(one, userResponse, true);
			// 设置token
			String token = TokenUtils.genToken(one.getOpenId(), one.getPassword());
			userResponse.setToken(token);
			String role = one.getRole(); // ROLE_ADMIN
			// 设置用户的菜单列表
			List<Menu> roleMenus = getRoleMenus(role);
			userResponse.setMenus(roleMenus);
			return userResponse;
		}
		return null;
	}

	@Override
	public User register(UserRequest userDTO) {
		User one = getOne(Wrappers.<User>lambdaQuery().eq(User::getOpenId, userDTO.getOpenId()).or().eq(User::getPhone, userDTO.getPhone()));
		if (one == null) {
			one = new User();
			BeanUtil.copyProperties(userDTO, one, true);
			save(one);
			if (StringUtils.isEmpty(one.getOpenId())) {
				one.setOpenId(String.valueOf(one.getId()));
				updateById(one);// 把 copy完之后的用户对象存储到数据库
			}
		} else {
			throw new ServiceException(Constants.CODE_600, "用户已存在");
		}
		return one;
	}

	@Override
	public void updatePassword(UserPasswordDTO userPasswordDTO) {
		int update = userMapper.updatePassword(userPasswordDTO);
		if (update < 1) {
			throw new ServiceException(Constants.CODE_600, "密码错误");
		}
	}


    private User getUserInfo(UserRequest userDTO) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", userDTO.getUsername());
		queryWrapper.eq("password", userDTO.getPassword());
		User one;
		try {
			one = getOne(queryWrapper); // 从数据库查询用户信息
		} catch (Exception e) {
			log.error(e.toString());
			throw new ServiceException(Constants.CODE_500, "系统错误");
		}
		return one;
	}

	/**
	 * 获取当前角色的菜单列表
	 *
	 * @param roleFlag
	 * @return
	 */
	private List<Menu> getRoleMenus(String roleFlag) {
		Integer roleId = roleMapper.selectByFlag(roleFlag);
		// 当前角色的所有菜单id集合
		List<Integer> menuIds = roleMenuMapper.selectByRoleId(roleId);

		// 查出系统所有的菜单(树形)
		List<Menu> menus = menuService.findMenus("");
		// new一个最后筛选完成之后的list
		List<Menu> roleMenus = new ArrayList<>();
		// 筛选当前用户角色的菜单
		for (Menu menu : menus) {
			if (menuIds.contains(menu.getId())) {
				roleMenus.add(menu);
			}
			List<Menu> children = menu.getChildren();
			// removeIf()  移除 children 里面不在 menuIds集合中的 元素
			children.removeIf(child -> !menuIds.contains(child.getId()));
		}
		return roleMenus;
	}

}
