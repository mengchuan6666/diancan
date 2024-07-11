package com.qnbc.venueReservation.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.CollectMapper;
import com.qnbc.venueReservation.domain.Collect;
import com.qnbc.venueReservation.service.ICollectService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author guzj
 * @date 2023-12-27
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements ICollectService {
	@Autowired
	private CollectMapper collectMapper;

	/**
	 * 查询【请填写功能名称】
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 【请填写功能名称】
	 */
	@Override
	public Collect selectCollectById(Long id) {
		return collectMapper.selectCollectById(id);
	}

	/**
	 * 查询【请填写功能名称】列表
	 *
	 * @param collect 【请填写功能名称】
	 * @return 【请填写功能名称】
	 */
	@Override
	public List<Collect> selectCollectList(Collect collect) {
		return collectMapper.selectCollectList(collect);
	}

	/**
	 * 新增【请填写功能名称】
	 *
	 * @param collect 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int insertCollect(Collect collect) {
		return collectMapper.insertCollect(collect);
	}

	/**
	 * 修改【请填写功能名称】
	 *
	 * @param collect 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int updateCollect(Collect collect) {
		return collectMapper.updateCollect(collect);
	}

	/**
	 * 批量删除【请填写功能名称】
	 *
	 * @param ids 需要删除的【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteCollectByIds(Long[] ids) {
		return collectMapper.deleteCollectByIds(ids);
	}

	/**
	 * 删除【请填写功能名称】信息
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteCollectById(Long id) {
		return collectMapper.deleteCollectById(id);
	}
}
