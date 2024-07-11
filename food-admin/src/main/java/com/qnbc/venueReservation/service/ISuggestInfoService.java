package com.qnbc.venueReservation.service;

import java.util.List;
import com.qnbc.venueReservation.domain.SuggestInfo;

/**
 * 用户建议Service接口
 * 
 * @author guzj
 * @date 2023-12-27
 */
public interface ISuggestInfoService 
{
    /**
     * 查询用户建议
     * 
     * @param id 用户建议主键
     * @return 用户建议
     */
    public SuggestInfo selectSuggestInfoById(Long id);

    /**
     * 查询用户建议列表
     * 
     * @param suggestInfo 用户建议
     * @return 用户建议集合
     */
    public List<SuggestInfo> selectSuggestInfoList(SuggestInfo suggestInfo);

    /**
     * 新增用户建议
     * 
     * @param suggestInfo 用户建议
     * @return 结果
     */
    public int insertSuggestInfo(SuggestInfo suggestInfo);

    /**
     * 修改用户建议
     * 
     * @param suggestInfo 用户建议
     * @return 结果
     */
    public int updateSuggestInfo(SuggestInfo suggestInfo);

    /**
     * 批量删除用户建议
     * 
     * @param ids 需要删除的用户建议主键集合
     * @return 结果
     */
    public int deleteSuggestInfoByIds(Long[] ids);

    /**
     * 删除用户建议信息
     * 
     * @param id 用户建议主键
     * @return 结果
     */
    public int deleteSuggestInfoById(Long id);
}
