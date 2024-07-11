package com.qnbc.venueReservation.mapper;

import java.util.List;
import com.qnbc.venueReservation.domain.RowNum;

/**
 * 排号记录Mapper接口
 * 
 * @author guzj
 * @date 2023-12-27
 */
public interface RowNumMapper 
{
    /**
     * 查询排号记录
     * 
     * @param id 排号记录主键
     * @return 排号记录
     */
    public RowNum selectRowNumById(Long id);

    /**
     * 查询排号记录列表
     * 
     * @param rowNum 排号记录
     * @return 排号记录集合
     */
    public List<RowNum> selectRowNumList(RowNum rowNum);

    /**
     * 新增排号记录
     * 
     * @param rowNum 排号记录
     * @return 结果
     */
    public int insertRowNum(RowNum rowNum);

    /**
     * 修改排号记录
     * 
     * @param rowNum 排号记录
     * @return 结果
     */
    public int updateRowNum(RowNum rowNum);

    /**
     * 删除排号记录
     * 
     * @param id 排号记录主键
     * @return 结果
     */
    public int deleteRowNumById(Long id);

    /**
     * 批量删除排号记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRowNumByIds(Long[] ids);
}
