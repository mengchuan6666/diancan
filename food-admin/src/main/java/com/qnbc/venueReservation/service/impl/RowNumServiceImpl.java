package com.qnbc.venueReservation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.RowNumMapper;
import com.qnbc.venueReservation.domain.RowNum;
import com.qnbc.venueReservation.service.IRowNumService;

/**
 * 排号记录Service业务层处理
 * 
 * @author guzj
 * @date 2023-12-27
 */
@Service
public class RowNumServiceImpl implements IRowNumService 
{
    @Autowired
    private RowNumMapper rowNumMapper;

    /**
     * 查询排号记录
     * 
     * @param id 排号记录主键
     * @return 排号记录
     */
    @Override
    public RowNum selectRowNumById(Long id)
    {
        return rowNumMapper.selectRowNumById(id);
    }

    /**
     * 查询排号记录列表
     * 
     * @param rowNum 排号记录
     * @return 排号记录
     */
    @Override
    public List<RowNum> selectRowNumList(RowNum rowNum)
    {
        return rowNumMapper.selectRowNumList(rowNum);
    }

    /**
     * 新增排号记录
     * 
     * @param rowNum 排号记录
     * @return 结果
     */
    @Override
    public int insertRowNum(RowNum rowNum)
    {
        return rowNumMapper.insertRowNum(rowNum);
    }

    /**
     * 修改排号记录
     * 
     * @param rowNum 排号记录
     * @return 结果
     */
    @Override
    public int updateRowNum(RowNum rowNum)
    {
        return rowNumMapper.updateRowNum(rowNum);
    }

    /**
     * 批量删除排号记录
     * 
     * @param ids 需要删除的排号记录主键
     * @return 结果
     */
    @Override
    public int deleteRowNumByIds(Long[] ids)
    {
        return rowNumMapper.deleteRowNumByIds(ids);
    }

    /**
     * 删除排号记录信息
     * 
     * @param id 排号记录主键
     * @return 结果
     */
    @Override
    public int deleteRowNumById(Long id)
    {
        return rowNumMapper.deleteRowNumById(id);
    }
}
