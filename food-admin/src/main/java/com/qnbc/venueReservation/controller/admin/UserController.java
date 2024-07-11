package com.qnbc.venueReservation.controller.admin;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qnbc.venueReservation.config.interceptor.AuthAccess;
import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.dto.UserPasswordDTO;
import com.qnbc.venueReservation.entity.User;
import com.qnbc.venueReservation.exception.ServiceException;
import com.qnbc.venueReservation.param.UserRequest;
import com.qnbc.venueReservation.response.UserResponse;
import com.qnbc.venueReservation.service.IUserService;
import com.qnbc.venueReservation.common.Constants;
import com.qnbc.venueReservation.common.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * user 接口
 *
 * @author
 * @since 2022-01-26
 */

@RestController
@RequestMapping("/venueReservation/user")
public class UserController {

	@Resource
	private IUserService userService;

	@PostMapping("/login")
	public Result login(@RequestBody UserRequest userDTO) {
		String username = userDTO.getUsername();
		String password = userDTO.getPassword();
		if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
			return Result.error(Constants.CODE_400, "参数错误");
		}
		UserResponse dto = userService.login(userDTO);
		if (null == dto) {
			return Result.error(500, "用户名或者密码错误");
		}
		return Result.success(dto);
	}


	/**
	 * 获取待审核数据
	 */
	@PostMapping("/getAuditStatusUser")
	public Result getAuditStatusUser() {
		QueryWrapper<User> queryWrapper = new QueryWrapper();
		queryWrapper.eq("audit_status", "3");
		List<User> dto = userService.list(queryWrapper);
		return Result.success(dto);
	}


	@AuthAccess
	@PostMapping("/register")
	public Result register(@RequestBody UserRequest userDTO) {

		String username = userDTO.getUsername();
		String password = userDTO.getPassword();
		if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
			return Result.error(Constants.CODE_400, "参数错误");
		}
		if (StringUtils.isEmpty(userDTO.getNickname())) {
			userDTO.setNickname(userDTO.getUsername());
		}
		userDTO.setCreateTime(new Date());
		userDTO.setUsername(userDTO.getUsername());
		userDTO.setPassword(password);
		return Result.success(userService.register(userDTO));
	}

	// 新增或者更新
	@PostMapping
	public Result save(@RequestBody User user) {
		String username = user.getUsername();
		if (StrUtil.isBlank(username)) {
			return Result.error(Constants.CODE_400, "参数错误");
		}
		if (user.getId() != null) {
			user.setPassword(null);
		} else {
			user.setNickname(user.getUsername());
			if (user.getPassword() == null) {
				user.setPassword("123");
			}
		}
		return Result.success(userService.saveOrUpdate(user));
	}

	/**
	 * 修改密码
	 *
	 * @param userPasswordDTO
	 * @return
	 */
	@PostMapping("/password")
	public Result password(@RequestBody UserPasswordDTO userPasswordDTO) {
		userService.updatePassword(userPasswordDTO);
		return Result.success();
	}

	@AuthAccess
	@PutMapping("/reset")
	public Result reset(@RequestBody UserPasswordDTO userPasswordDTO) {
		if (StrUtil.isBlank(userPasswordDTO.getUsername()) || StrUtil.isBlank(userPasswordDTO.getPhone())) {
			throw new ServiceException(-1, "参数异常");
		}
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", userPasswordDTO.getUsername());
		queryWrapper.eq("phone", userPasswordDTO.getPhone());
		List<User> list = userService.list(queryWrapper);
		if (CollUtil.isNotEmpty(list)) {
			User user = list.get(0);
			user.setPassword("123");
			userService.updateById(user);
		}
		return Result.success();
	}

	@DeleteMapping("/{id}")
	public Result delete(@PathVariable Integer id) {
		return Result.success(userService.removeById(id));
	}

	@PostMapping("/del/batch")
	public Result deleteBatch(@RequestBody List<Integer> ids) {
		return Result.success(userService.removeByIds(ids));
	}

	@GetMapping
	public Result findAll() {
		return Result.success(userService.list());
	}


	@GetMapping("/count")
	public AjaxResult findAllCount() {
		Map<String, Long> map = new HashMap<>();

		// 创建 Calendar 对象并设置为当前时间
		Calendar calendar = Calendar.getInstance();
		// 将日期向前调整一天（即昨天）
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		// 格式化日期输出
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String yesterdayDate = dateFormat.format(calendar.getTime());
		System.out.println("昨天的日期是：" + yesterdayDate);

		LambdaQueryWrapper<User> lambdaQueryWrapper1 = new LambdaQueryWrapper();
		lambdaQueryWrapper1.eq(User::getRole, "ROLE_USER");
		lambdaQueryWrapper1.like(User::getCreateTime, yesterdayDate);
		long listCount = userService.count(lambdaQueryWrapper1);
		map.put("listCount", listCount);

		// 创建 Calendar 对象并设置为当前时间
		Calendar calendar1 = Calendar.getInstance();
		// 将日期向前调整一天（即昨天）
		calendar1.add(Calendar.DAY_OF_MONTH, 0);
		// 格式化日期输出
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		String yesterdayDate1 = dateFormat1.format(calendar1.getTime());
		System.out.println("昨天的日期是：" + yesterdayDate1);

		LambdaQueryWrapper<User> lambdaQueryWrapper2 = new LambdaQueryWrapper();
		lambdaQueryWrapper2.eq(User::getRole, "ROLE_USER");
		lambdaQueryWrapper2.like(User::getCreateTime, yesterdayDate1);
		long listCoun2 = userService.count(lambdaQueryWrapper2);
		map.put("listCoun2", listCoun2);
		// 创建 Calendar 对象并设置为当前时间
		Calendar calendar3 = Calendar.getInstance();
		// 将日期向前调整一天（即昨天）
		calendar3.add(Calendar.DAY_OF_MONTH, -1);
		// 格式化日期输出
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM");
		String yesterdayDate3 = dateFormat3.format(calendar3.getTime());
		System.out.println("昨天的日期是：" + yesterdayDate);

		LambdaQueryWrapper<User> lambdaQueryWrapper3 = new LambdaQueryWrapper();
		lambdaQueryWrapper3.eq(User::getRole, "ROLE_USER");
		lambdaQueryWrapper3.like(User::getCreateTime, yesterdayDate3);
		long count3 = userService.count(lambdaQueryWrapper3);
		map.put("count3", count3);

		return AjaxResult.success(map);
	}

	@GetMapping("/{id}")
	public Result findOne(@PathVariable Integer id) {
		return Result.success(userService.getById(id));
	}

	@GetMapping("/openId")
	public Result findOneOpenId(@RequestParam @Validated String openId) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("open_id", openId);
		User one = userService.getOne(queryWrapper);
		if (null == one) {
			return Result.success();
		}
		if (StringUtils.isEmpty(one.getAuditStatus()) || "2".equals(one.getAuditStatus())) {
			one.setRole("VISITOR");
		}
		return Result.success(one);
	}

	@GetMapping("/username/{username}")
	public Result findByUsername(@PathVariable String username) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", username);
		User one = userService.getOne(queryWrapper);
		return Result.success(one);
	}

	@GetMapping("/page")
	public Result findPage(@RequestParam Integer pageNum,
						   @RequestParam Integer pageSize,
						   @RequestParam(defaultValue = "") String username,
						   @RequestParam(defaultValue = "") String role,
						   @RequestParam(defaultValue = "") String auditStatus) {

		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("id");
		if (!"".equals(username)) {
			queryWrapper.like("username", username);
		}
		if (!"".equals(role)) {
			queryWrapper.eq("role", role);
		}
		if (!"".equals(auditStatus)) {
			queryWrapper.inSql("audit_status", auditStatus);
		}
		Page<User> page = userService.page(new Page<>(pageNum, pageSize), queryWrapper);

		return Result.success(page);
	}

	@GetMapping("/page/role")
	public Result findPageRole(@RequestParam Integer pageNum,
							   @RequestParam Integer pageSize,
							   @RequestParam(defaultValue = "") String username,
							   @RequestParam(defaultValue = "") String role,
							   @RequestParam(defaultValue = "") String auditStatus) {

		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("id");
		if (!"".equals(username)) {
			queryWrapper.like("username", username);
		}
		if (!"".equals(role)) {
			queryWrapper.inSql("role", role);
		}
		if (!"".equals(auditStatus)) {
			queryWrapper.inSql("audit_status", auditStatus);
		}

		return Result.success(userService.page(new Page<>(pageNum, pageSize), queryWrapper));
	}

	/**
	 * 导出接口
	 */
	@GetMapping("/export")
	public void export(HttpServletResponse response) throws Exception {
		// 从数据库查询出所有的数据
		List<User> list = userService.list();
		// 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
		// 在内存操作，写出到浏览器
		ExcelWriter writer = ExcelUtil.getWriter(true);
		//自定义标题别名
		writer.addHeaderAlias("username", "用户名");
		writer.addHeaderAlias("password", "密码");
		writer.addHeaderAlias("nickname", "昵称");
		writer.addHeaderAlias("email", "邮箱");
		writer.addHeaderAlias("phone", "电话");
		writer.addHeaderAlias("address", "地址");
		writer.addHeaderAlias("createTime", "创建时间");
		writer.addHeaderAlias("avatarUrl", "头像");

		// 一次性写出list内的对象到excel，使用默认样式，强制输出标题
		writer.write(list, true);

		// 设置浏览器响应的格式
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
		String fileName = URLEncoder.encode("用户信息", "UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

		ServletOutputStream out = response.getOutputStream();
		writer.flush(out, true);
		out.close();
		writer.close();
	}

}

