package com.qnbc.venueReservation.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qnbc.venueReservation.domain.FoodOrder;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author guzj
 * @date 2023-12-27
 */
public interface FoodOrderMapper extends BaseMapper<FoodOrder>
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public FoodOrder selectOrderById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param order 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<FoodOrder> selectOrderList(FoodOrder order);

    /**
     * 新增【请填写功能名称】
     *
     * @param order 【请填写功能名称】
     * @return 结果
     */
    public int insertOrder(FoodOrder order);

    /**
     * 修改【请填写功能名称】
     *
     * @param order 【请填写功能名称】
     * @return 结果
     */
    public int updateOrder(FoodOrder order);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteOrderById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderByIds(Long[] ids);
}
