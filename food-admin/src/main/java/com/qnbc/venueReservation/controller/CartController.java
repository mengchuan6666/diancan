package com.qnbc.venueReservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qnbc.venueReservation.core.controller.BaseController;
import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.core.enums.BusinessType;
import com.qnbc.venueReservation.core.page.TableDataInfo;
import com.qnbc.venueReservation.core.utils.poi.ExcelUtil;
import com.qnbc.venueReservation.domain.Wxuserinfo;
import com.qnbc.venueReservation.entity.User;
import com.qnbc.venueReservation.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qnbc.venueReservation.domain.Cart;
import com.qnbc.venueReservation.service.ICartService;

/**
 * 【请填写功能名称】
 *
 * @author guzj
 * @date 2023-12-27
 */
@RestController
@RequestMapping("/venueReservation/cart")
public class CartController extends BaseController {
	@Autowired
	private ICartService cartService;


	/**
	 * 删除购物车
	 *
	 * @param id 商品id
	 * @return result
	 */
	@DeleteMapping("/goods/{id}")
	public AjaxResult deleteGoods(@PathVariable Integer id) {

		cartService.deleteCartById(Long.valueOf(id));
		return AjaxResult.success();
	}

	/**
	 * 删除购物车
	 *
	 * @return result
	 */
	@DeleteMapping("/empty")
	public AjaxResult empty() {
		User appletCurrentUser = TokenUtils.getCurrentUser();
		LambdaQueryWrapper<Cart> lambdaQueryWrapper = new LambdaQueryWrapper();
		lambdaQueryWrapper.eq(Cart::getUserid, appletCurrentUser.getOpenId());
		cartService.remove(lambdaQueryWrapper);
		return AjaxResult.success();

	}

	@GetMapping("/totalNum")
	public AjaxResult totalNum() {

		Integer totalNum = cartService.getTotalNum();
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("totalNum", totalNum);
		return AjaxResult.success(resultMap);
	}

	@GetMapping("/totalPrice")
	public AjaxResult totalPrice() {
		Integer totalPrice = cartService.getTotalPrice();
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("totalPrice", totalPrice);
		return AjaxResult.success(resultMap);
	}

	/**
	 * 查询【请填写功能名称】列表
	 */
	@GetMapping("/list")
	public TableDataInfo list(Cart cart) {
		startPage();
		List<Cart> list = cartService.selectCartList(cart);
		return getDataTable(list);
	}

	/**
	 * 导出【请填写功能名称】列表
	 */
	@PostMapping("/export")
	public void export(HttpServletResponse response, Cart cart) {
		List<Cart> list = cartService.selectCartList(cart);
		ExcelUtil<Cart> util = new ExcelUtil<Cart>(Cart.class);
		util.exportExcel(response, list, "【请填写功能名称】数据");
	}

	/**
	 * 获取【请填写功能名称】详细信息
	 */
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") Long id) {
		return AjaxResult.success(cartService.selectCartById(id));
	}

	/**
	 * 新增【请填写功能名称】
	 */
	@PostMapping
	public AjaxResult add(@RequestBody Cart cart) {
		return toAjax(cartService.insertCart(cart));
	}

	/**
	 * 修改【请填写功能名称】
	 */
	@PutMapping
	public AjaxResult edit(@RequestBody Cart cart) {
		return toAjax(cartService.updateCart(cart));
	}

	/**
	 * 删除【请填写功能名称】
	 */
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable Long[] ids) {
		return toAjax(cartService.deleteCartByIds(ids));
	}
}
