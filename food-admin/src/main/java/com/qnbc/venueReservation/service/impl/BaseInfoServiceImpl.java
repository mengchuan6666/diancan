package com.qnbc.venueReservation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.BaseInfoMapper;
import com.qnbc.venueReservation.domain.BaseInfo;
import com.qnbc.venueReservation.service.IBaseInfoService;

/**
 * 基本信息配置Service业务层处理
 * 
 * @author guzj
 * @date 2023-08-05
 */
@Service
public class BaseInfoServiceImpl implements IBaseInfoService 
{
    @Autowired
    private BaseInfoMapper baseInfoMapper;

    /**
     * 查询基本信息配置
     * 
     * @param id 基本信息配置主键
     * @return 基本信息配置
     */
    @Override
    public BaseInfo selectBaseInfoById(Long id)
    {
        return baseInfoMapper.selectBaseInfoById(id);
    }

    /**
     * 查询基本信息配置列表
     * 
     * @param baseInfo 基本信息配置
     * @return 基本信息配置
     */
    @Override
    public List<BaseInfo> selectBaseInfoList(BaseInfo baseInfo)
    {
        return baseInfoMapper.selectBaseInfoList(baseInfo);
    }

    /**
     * 新增基本信息配置
     * 
     * @param baseInfo 基本信息配置
     * @return 结果
     */
    @Override
    public int insertBaseInfo(BaseInfo baseInfo)
    {
        return baseInfoMapper.insertBaseInfo(baseInfo);
    }

    /**
     * 修改基本信息配置
     * 
     * @param baseInfo 基本信息配置
     * @return 结果
     */
    @Override
    public int updateBaseInfo(BaseInfo baseInfo)
    {
        return baseInfoMapper.updateBaseInfo(baseInfo);
    }

    /**
     * 批量删除基本信息配置
     * 
     * @param ids 需要删除的基本信息配置主键
     * @return 结果
     */
    @Override
    public int deleteBaseInfoByIds(Long[] ids)
    {
        return baseInfoMapper.deleteBaseInfoByIds(ids);
    }

    /**
     * 删除基本信息配置信息
     * 
     * @param id 基本信息配置主键
     * @return 结果
     */
    @Override
    public int deleteBaseInfoById(Long id)
    {
        return baseInfoMapper.deleteBaseInfoById(id);
    }
}
