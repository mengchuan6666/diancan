package com.qnbc.venueReservation.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qnbc.venueReservation.domain.FoodOrder;
import com.qnbc.venueReservation.domain.OrderDetail;

/**
 * 【请填写功能名称】Service接口
 *
 * @author guzj
 * @date 2023-12-27
 */
public interface IOrderDetailService extends IService<OrderDetail>
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public OrderDetail selectOrderDetailById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param orderDetail 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<OrderDetail> selectOrderDetailList(OrderDetail orderDetail);

    /**
     * 新增【请填写功能名称】
     *
     * @param orderDetail 【请填写功能名称】
     * @return 结果
     */
    public int insertOrderDetail(OrderDetail orderDetail);

    /**
     * 修改【请填写功能名称】
     *
     * @param orderDetail 【请填写功能名称】
     * @return 结果
     */
    public int updateOrderDetail(OrderDetail orderDetail);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteOrderDetailByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteOrderDetailById(Long id);
}
