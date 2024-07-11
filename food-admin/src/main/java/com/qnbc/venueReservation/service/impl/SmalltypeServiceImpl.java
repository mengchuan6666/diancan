package com.qnbc.venueReservation.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.SmalltypeMapper;
import com.qnbc.venueReservation.domain.Smalltype;
import com.qnbc.venueReservation.service.ISmalltypeService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author guzj
 * @date 2023-12-27
 */
@Service
public class SmalltypeServiceImpl extends ServiceImpl<SmalltypeMapper, Smalltype> implements ISmalltypeService {
	@Autowired
	private SmalltypeMapper smalltypeMapper;

	/**
	 * 查询【请填写功能名称】
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 【请填写功能名称】
	 */
	@Override
	public Smalltype selectSmalltypeById(Long id) {
		return smalltypeMapper.selectSmalltypeById(id);
	}

	/**
	 * 查询【请填写功能名称】列表
	 *
	 * @param smalltype 【请填写功能名称】
	 * @return 【请填写功能名称】
	 */
	@Override
	public List<Smalltype> selectSmalltypeList(Smalltype smalltype) {
		return smalltypeMapper.selectSmalltypeList(smalltype);
	}

	/**
	 * 新增【请填写功能名称】
	 *
	 * @param smalltype 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int insertSmalltype(Smalltype smalltype) {
		return smalltypeMapper.insertSmalltype(smalltype);
	}

	/**
	 * 修改【请填写功能名称】
	 *
	 * @param smalltype 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int updateSmalltype(Smalltype smalltype) {
		return smalltypeMapper.updateSmalltype(smalltype);
	}

	/**
	 * 批量删除【请填写功能名称】
	 *
	 * @param ids 需要删除的【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteSmalltypeByIds(Long[] ids) {
		return smalltypeMapper.deleteSmalltypeByIds(ids);
	}

	/**
	 * 删除【请填写功能名称】信息
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteSmalltypeById(Long id) {
		return smalltypeMapper.deleteSmalltypeById(id);
	}
}
