package com.qnbc.venueReservation.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qnbc.venueReservation.mapper.FoodOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.domain.FoodOrder;
import com.qnbc.venueReservation.service.IOrderService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author guzj
 * @date 2023-12-27
 */
@Service
public class OrderServiceImpl extends ServiceImpl<FoodOrderMapper,FoodOrder> implements IOrderService
{
    @Autowired
    private FoodOrderMapper orderMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public FoodOrder selectOrderById(Long id)
    {
        return orderMapper.selectOrderById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param order 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<FoodOrder> selectOrderList(FoodOrder order)
    {
        return orderMapper.selectOrderList(order);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param order 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOrder(FoodOrder order)
    {
        return orderMapper.insertOrder(order);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param order 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateOrder(FoodOrder order)
    {
        return orderMapper.updateOrder(order);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOrderByIds(Long[] ids)
    {
        return orderMapper.deleteOrderByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOrderById(Long id)
    {
        return orderMapper.deleteOrderById(id);
    }
}
