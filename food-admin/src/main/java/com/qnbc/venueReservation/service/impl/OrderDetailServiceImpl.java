package com.qnbc.venueReservation.service.impl;

import java.util.List;

import afu.org.checkerframework.checker.oigj.qual.O;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.OrderDetailMapper;
import com.qnbc.venueReservation.domain.OrderDetail;
import com.qnbc.venueReservation.service.IOrderDetailService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author guzj
 * @date 2023-12-27
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {
	@Autowired
	private OrderDetailMapper orderDetailMapper;

	/**
	 * 查询【请填写功能名称】
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 【请填写功能名称】
	 */
	@Override
	public OrderDetail selectOrderDetailById(Long id) {
		return orderDetailMapper.selectOrderDetailById(id);
	}

	/**
	 * 查询【请填写功能名称】列表
	 *
	 * @param orderDetail 【请填写功能名称】
	 * @return 【请填写功能名称】
	 */
	@Override
	public List<OrderDetail> selectOrderDetailList(OrderDetail orderDetail) {
		return orderDetailMapper.selectOrderDetailList(orderDetail);
	}

	/**
	 * 新增【请填写功能名称】
	 *
	 * @param orderDetail 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int insertOrderDetail(OrderDetail orderDetail) {
		return orderDetailMapper.insertOrderDetail(orderDetail);
	}

	/**
	 * 修改【请填写功能名称】
	 *
	 * @param orderDetail 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int updateOrderDetail(OrderDetail orderDetail) {
		return orderDetailMapper.updateOrderDetail(orderDetail);
	}

	/**
	 * 批量删除【请填写功能名称】
	 *
	 * @param ids 需要删除的【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteOrderDetailByIds(Long[] ids) {
		return orderDetailMapper.deleteOrderDetailByIds(ids);
	}

	/**
	 * 删除【请填写功能名称】信息
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteOrderDetailById(Long id) {
		return orderDetailMapper.deleteOrderDetailById(id);
	}
}
