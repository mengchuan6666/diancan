
package com.qnbc.venueReservation.controller.admin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.qnbc.venueReservation.config.interceptor.AuthAccess;
import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.core.utils.PageUtils;
import com.qnbc.venueReservation.entity.ConfigEntity;
import com.qnbc.venueReservation.service.ConfigService;
import com.qnbc.venueReservation.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录相关
 */
@RequestMapping("/venueReservation/config")
@RestController
public class ConfigController {

	@Autowired
	private ConfigService configService;

	/**
	 * 列表
	 */
	@AuthAccess
	@PostMapping("/list")
	public AjaxResult list(@RequestBody ConfigEntity config) {
		List<ConfigEntity> page = configService.queryPage(config);
		return AjaxResult.success(page);
	}

	/**
	 * 保存
	 */
	@PostMapping("/save")
	public AjaxResult save(@RequestBody ConfigEntity config) {
		if (null != config.getId()) {
			configService.updateById(config);
			return AjaxResult.success();
		}
		configService.save(config);
		return AjaxResult.success();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public AjaxResult update(@RequestBody ConfigEntity config) {
		configService.updateById(config);//全部更新
		return AjaxResult.success();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete/{id}")
	public AjaxResult delete(@PathVariable Long id) {
		configService.deleteId(id);
		return AjaxResult.success();
	}
}
