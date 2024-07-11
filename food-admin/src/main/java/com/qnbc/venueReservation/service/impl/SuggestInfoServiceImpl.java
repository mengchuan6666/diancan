package com.qnbc.venueReservation.service.impl;

import java.util.Date;
import java.util.List;

import com.qnbc.venueReservation.entity.User;
import com.qnbc.venueReservation.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.SuggestInfoMapper;
import com.qnbc.venueReservation.domain.SuggestInfo;
import com.qnbc.venueReservation.service.ISuggestInfoService;

/**
 * 用户建议Service业务层处理
 *
 * @author guzj
 * @date 2023-12-27
 */
@Service
public class SuggestInfoServiceImpl implements ISuggestInfoService {
	@Autowired
	private SuggestInfoMapper suggestInfoMapper;

	/**
	 * 查询用户建议
	 *
	 * @param id 用户建议主键
	 * @return 用户建议
	 */
	@Override
	public SuggestInfo selectSuggestInfoById(Long id) {
		return suggestInfoMapper.selectSuggestInfoById(id);
	}

	/**
	 * 查询用户建议列表
	 *
	 * @param suggestInfo 用户建议
	 * @return 用户建议
	 */
	@Override
	public List<SuggestInfo> selectSuggestInfoList(SuggestInfo suggestInfo) {
		return suggestInfoMapper.selectSuggestInfoList(suggestInfo);
	}

	/**
	 * 新增用户建议
	 *
	 * @param suggestInfo 用户建议
	 * @return 结果
	 */
	@Override
	public int insertSuggestInfo(SuggestInfo suggestInfo) {
		User currentUser = TokenUtils.getCurrentUser();
		suggestInfo.setCreatedBy(currentUser.getNickname());
		suggestInfo.setCreatedTime(new Date());
		return suggestInfoMapper.insertSuggestInfo(suggestInfo);
	}

	/**
	 * 修改用户建议
	 *
	 * @param suggestInfo 用户建议
	 * @return 结果
	 */
	@Override
	public int updateSuggestInfo(SuggestInfo suggestInfo) {
		return suggestInfoMapper.updateSuggestInfo(suggestInfo);
	}

	/**
	 * 批量删除用户建议
	 *
	 * @param ids 需要删除的用户建议主键
	 * @return 结果
	 */
	@Override
	public int deleteSuggestInfoByIds(Long[] ids) {
		return suggestInfoMapper.deleteSuggestInfoByIds(ids);
	}

	/**
	 * 删除用户建议信息
	 *
	 * @param id 用户建议主键
	 * @return 结果
	 */
	@Override
	public int deleteSuggestInfoById(Long id) {
		return suggestInfoMapper.deleteSuggestInfoById(id);
	}
}
