package com.qnbc.venueReservation.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qnbc.venueReservation.domain.Wxuserinfo;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author guzj
 * @date 2023-12-27
 */
public interface WxuserinfoMapper extends BaseMapper<Wxuserinfo>
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Wxuserinfo selectWxuserinfoById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param wxuserinfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Wxuserinfo> selectWxuserinfoList(Wxuserinfo wxuserinfo);

    /**
     * 新增【请填写功能名称】
     *
     * @param wxuserinfo 【请填写功能名称】
     * @return 结果
     */
    public int insertWxuserinfo(Wxuserinfo wxuserinfo);

    /**
     * 修改【请填写功能名称】
     *
     * @param wxuserinfo 【请填写功能名称】
     * @return 结果
     */
    public int updateWxuserinfo(Wxuserinfo wxuserinfo);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteWxuserinfoById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWxuserinfoByIds(Long[] ids);
}
