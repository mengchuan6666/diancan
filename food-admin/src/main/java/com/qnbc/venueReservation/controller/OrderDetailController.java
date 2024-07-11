package com.qnbc.venueReservation.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.qnbc.venueReservation.core.controller.BaseController;
import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.core.page.TableDataInfo;
import com.qnbc.venueReservation.core.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qnbc.venueReservation.domain.OrderDetail;
import com.qnbc.venueReservation.service.IOrderDetailService;


/**
 * 【请填写功能名称】
 *
 * @author guzj
 * @date 2023-12-27
 */
@RestController
@RequestMapping("/venueReservation/detail")
public class OrderDetailController extends BaseController {
	@Autowired
	private IOrderDetailService orderDetailService;

	/**
	 * 查询【请填写功能名称】列表
	 */
	@GetMapping("/list")
	public TableDataInfo list(OrderDetail orderDetail) {
		startPage();
		List<OrderDetail> list = orderDetailService.selectOrderDetailList(orderDetail);
		return getDataTable(list);
	}

	/**
	 * 导出【请填写功能名称】列表
	 */
	@PostMapping("/export")
	public void export(HttpServletResponse response, OrderDetail orderDetail) {
		List<OrderDetail> list = orderDetailService.selectOrderDetailList(orderDetail);
		ExcelUtil<OrderDetail> util = new ExcelUtil<OrderDetail>(OrderDetail.class);
		util.exportExcel(response, list, "【请填写功能名称】数据");
	}

	/**
	 * 获取【请填写功能名称】详细信息
	 */
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") Long id) {
		return AjaxResult.success(orderDetailService.selectOrderDetailById(id));
	}

	/**
	 * 新增【请填写功能名称】
	 */
	@PostMapping
	public AjaxResult add(@RequestBody OrderDetail orderDetail) {
		return toAjax(orderDetailService.insertOrderDetail(orderDetail));
	}

	/**
	 * 修改【请填写功能名称】
	 */
	@PutMapping
	public AjaxResult edit(@RequestBody OrderDetail orderDetail) {
		return toAjax(orderDetailService.updateOrderDetail(orderDetail));
	}

	/**
	 * 删除【请填写功能名称】
	 */
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable Long[] ids) {
		return toAjax(orderDetailService.deleteOrderDetailByIds(ids));
	}
}
