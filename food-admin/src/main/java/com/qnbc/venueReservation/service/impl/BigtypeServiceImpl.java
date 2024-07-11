package com.qnbc.venueReservation.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.BigtypeMapper;
import com.qnbc.venueReservation.domain.Bigtype;
import com.qnbc.venueReservation.service.IBigtypeService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author guzj
 * @date 2023-12-27
 */
@Service
public class BigtypeServiceImpl extends ServiceImpl<BigtypeMapper, Bigtype> implements IBigtypeService {
	@Autowired
	private BigtypeMapper bigtypeMapper;

	/**
	 * 查询【请填写功能名称】
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 【请填写功能名称】
	 */
	@Override
	public Bigtype selectBigtypeById(Long id) {
		return bigtypeMapper.selectBigtypeById(id);
	}

	/**
	 * 查询【请填写功能名称】列表
	 *
	 * @param bigtype 【请填写功能名称】
	 * @return 【请填写功能名称】
	 */
	@Override
	public List<Bigtype> selectBigtypeList(Bigtype bigtype) {
		return bigtypeMapper.selectBigtypeList(bigtype);
	}

	/**
	 * 新增【请填写功能名称】
	 *
	 * @param bigtype 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int insertBigtype(Bigtype bigtype) {
		return bigtypeMapper.insertBigtype(bigtype);
	}

	/**
	 * 修改【请填写功能名称】
	 *
	 * @param bigtype 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int updateBigtype(Bigtype bigtype) {
		return bigtypeMapper.updateBigtype(bigtype);
	}

	/**
	 * 批量删除【请填写功能名称】
	 *
	 * @param ids 需要删除的【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteBigtypeByIds(Long[] ids) {
		return bigtypeMapper.deleteBigtypeByIds(ids);
	}

	/**
	 * 删除【请填写功能名称】信息
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteBigtypeById(Long id) {
		return bigtypeMapper.deleteBigtypeById(id);
	}
}
