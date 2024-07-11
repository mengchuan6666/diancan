package com.qnbc.venueReservation.controller.admin;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import afu.org.checkerframework.checker.oigj.qual.O;
import com.alipay.api.internal.util.AlipaySignature;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qnbc.venueReservation.config.AliPayConfig;
import com.qnbc.venueReservation.core.controller.BaseController;
import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.core.page.TableDataInfo;
import com.qnbc.venueReservation.core.utils.poi.ExcelUtil;
import com.qnbc.venueReservation.domain.OrderDetail;
import com.qnbc.venueReservation.dto.GetOrderCount;
import com.qnbc.venueReservation.service.IOrderDetailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qnbc.venueReservation.domain.FoodOrder;
import com.qnbc.venueReservation.service.IOrderService;


/**
 * 【请填写功能名称】
 *
 * @author guzj
 * @date 2023-12-27
 */
@RestController
@RequestMapping("/venueReservation/order")
public class OrderController extends BaseController {
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IOrderDetailService orderDetailService;
	@Autowired
	private AliPayConfig aliPayConfig;


	//统计
	@GetMapping("/getCount")
	public AjaxResult getCount() {
		List<GetOrderCount> getOrderCountList = new ArrayList<>();

		List<FoodOrder> list = orderService.list();
		Map<String, Integer> map = new HashMap<>();
		for (FoodOrder dateListEntry : list) {
			String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date(String.valueOf(dateListEntry.getCreatedate())));
			Object o = map.get(format);
			if (null == o) {
				map.put(format, 1);
			} else {
				map.put(format, (Integer) o + 1);
			}
		}


		for (FoodOrder foodOrder : list) {
			String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date(String.valueOf(foodOrder.getCreatedate())));
			GetOrderCount getOrderCount = new GetOrderCount();
			getOrderCount.setDate(format);
			getOrderCount.setOrderAmount(foodOrder.getTotalprice());
			getOrderCount.setOrderCount(String.valueOf(map.get(format)));
			getOrderCountList.add(getOrderCount);
		}

		ArrayList<GetOrderCount> collect1 = getOrderCountList.stream()
			.collect(Collectors.collectingAndThen(
				Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(
					s -> String.valueOf(s.getDate())))), ArrayList::new));

		List<GetOrderCount> collect = collect1.stream()
			.sorted(Comparator.comparing(GetOrderCount::getDate))
			.collect(Collectors.toList());
		return AjaxResult.success(collect);
	}


	/**
	 * 查询【请填写功能名称】列表
	 */
	@GetMapping("/list")
	public TableDataInfo list(FoodOrder order) {
		startPage();
		List<FoodOrder> orderList = orderService.selectOrderList(order);
		for (FoodOrder foodOrder : orderList) {
			LambdaQueryWrapper<OrderDetail> queryWrapper = Wrappers.lambdaQuery();
			queryWrapper.eq(OrderDetail::getMid, order.getId());
			List<OrderDetail> one = orderDetailService.list(queryWrapper);
			if (CollectionUtils.isEmpty(one)) {
				continue;
			}

			List<OrderDetail> list = new ArrayList<>();
			list.addAll(one);
			OrderDetail[] goods1 = new OrderDetail[list.size()];
			foodOrder.setGoods(list);
		}

		return getDataTable(orderList);
	}

	/**
	 * 导出【请填写功能名称】列表
	 */
	@PostMapping("/export")
	public void export(HttpServletResponse response, FoodOrder order) {
		List<FoodOrder> list = orderService.selectOrderList(order);
		ExcelUtil<FoodOrder> util = new ExcelUtil<FoodOrder>(FoodOrder.class);
		util.exportExcel(response, list, "【请填写功能名称】数据");
	}

	/**
	 * 获取【请填写功能名称】详细信息
	 */
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") Long id) {
		return AjaxResult.success(orderService.selectOrderById(id));
	}

	/**
	 * 新增【请填写功能名称】
	 */
	@PostMapping
	@ApiOperation(value = "用户下单")
	public AjaxResult add(@RequestBody FoodOrder order) {
		return toAjax(orderService.insertOrder(order));
	}

	/**
	 * 修改【请填写功能名称】
	 */
	@PutMapping
	public AjaxResult edit(@RequestBody FoodOrder order) {
		return toAjax(orderService.updateOrder(order));
	}

	/**
	 * 删除【请填写功能名称】
	 */
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable Long[] ids) {
		return toAjax(orderService.deleteOrderByIds(ids));
	}

	@PostMapping("/notify")  // 注意这里必须是POST接口
	public String payNotify(HttpServletRequest request) throws Exception {
		if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
			System.out.println("=========支付宝异步回调========");

			Map<String, String> params = new HashMap<>();
			Map<String, String[]> requestParams = request.getParameterMap();
			for (String name : requestParams.keySet()) {
				params.put(name, request.getParameter(name));
				// System.out.println(name + " = " + request.getParameter(name));
			}

			String tradeNo = params.get("out_trade_no");
			String gmtPayment = params.get("gmt_payment");
			String alipayTradeNo = params.get("trade_no");

			String sign = params.get("sign");
			String content = AlipaySignature.getSignCheckContentV1(params);
			// 支付宝验签
			boolean checkSignature = AlipaySignature.rsa256CheckContent(content, sign, aliPayConfig.getAlipayPublicKey(), "UTF-8");
			if (checkSignature) {
				// 验签通过
				System.out.println("交易名称: " + params.get("subject"));
				System.out.println("交易状态: " + params.get("trade_status"));
				System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
				System.out.println("商户订单号: " + params.get("out_trade_no"));
				System.out.println("交易金额: " + params.get("total_amount"));
				System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
				System.out.println("买家付款时间: " + params.get("gmt_payment"));
				System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));

				// 更新订单未已支付
				FoodOrder FoodorderInfo = orderService.selectOrderById(Long.valueOf(tradeNo));
				FoodorderInfo.setAlipayTraceNo(alipayTradeNo);
				FoodorderInfo.setStatus(1L);
				orderService.updateById(FoodorderInfo);
			}
		}
		return "success";
	}
}
