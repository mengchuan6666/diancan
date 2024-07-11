package com.qnbc.venueReservation.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qnbc.venueReservation.domain.Smalltype;

/**
 * 【请填写功能名称】Service接口
 *
 * @author guzj
 * @date 2023-12-27
 */
public interface ISmalltypeService extends IService<Smalltype> {
	/**
	 * 查询【请填写功能名称】
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 【请填写功能名称】
	 */
	public Smalltype selectSmalltypeById(Long id);

	/**
	 * 查询【请填写功能名称】列表
	 *
	 * @param smalltype 【请填写功能名称】
	 * @return 【请填写功能名称】集合
	 */
	public List<Smalltype> selectSmalltypeList(Smalltype smalltype);

	/**
	 * 新增【请填写功能名称】
	 *
	 * @param smalltype 【请填写功能名称】
	 * @return 结果
	 */
	public int insertSmalltype(Smalltype smalltype);

	/**
	 * 修改【请填写功能名称】
	 *
	 * @param smalltype 【请填写功能名称】
	 * @return 结果
	 */
	public int updateSmalltype(Smalltype smalltype);

	/**
	 * 批量删除【请填写功能名称】
	 *
	 * @param ids 需要删除的【请填写功能名称】主键集合
	 * @return 结果
	 */
	public int deleteSmalltypeByIds(Long[] ids);

	/**
	 * 删除【请填写功能名称】信息
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 结果
	 */
	public int deleteSmalltypeById(Long id);
}
