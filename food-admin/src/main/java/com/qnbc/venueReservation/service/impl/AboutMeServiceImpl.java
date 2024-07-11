package com.qnbc.venueReservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.AboutMeMapper;
import com.qnbc.venueReservation.domain.AboutMe;
import com.qnbc.venueReservation.service.IAboutMeService;

/**
 * 关于我们Service业务层处理
 *
 * @author guzj
 * @date 2023-08-05
 */
@Service
public class AboutMeServiceImpl implements IAboutMeService {
	@Autowired
	private AboutMeMapper aboutMeMapper;

	/**
	 * 查询关于我们
	 *
	 * @param id 关于我们主键
	 * @return 关于我们
	 */
	@Override
	public AboutMe selectAboutMeById(Long id) {
		return aboutMeMapper.selectAboutMeById(id);
	}

	/**
	 * 查询关于我们列表
	 *
	 * @param aboutMe 关于我们
	 * @return 关于我们
	 */
	@Override
	public List<AboutMe> selectAboutMeList(AboutMe aboutMe) {
		return aboutMeMapper.selectAboutMeList(aboutMe);
	}

	/**
	 * 新增关于我们
	 *
	 * @param aboutMe 关于我们
	 * @return 结果
	 */
	@Override
	public int insertAboutMe(AboutMe aboutMe) {
		return aboutMeMapper.insertAboutMe(aboutMe);
	}

	/**
	 * 修改关于我们
	 *
	 * @param aboutMe 关于我们
	 * @return 结果
	 */
	@Override
	public int updateAboutMe(AboutMe aboutMe) {
		return aboutMeMapper.updateAboutMe(aboutMe);
	}

	/**
	 * 批量删除关于我们
	 *
	 * @param ids 需要删除的关于我们主键
	 * @return 结果
	 */
	@Override
	public int deleteAboutMeByIds(Long[] ids) {
		return aboutMeMapper.deleteAboutMeByIds(ids);
	}

	/**
	 * 删除关于我们信息
	 *
	 * @param id 关于我们主键
	 * @return 结果
	 */
	@Override
	public int deleteAboutMeById(Long id) {
		return aboutMeMapper.deleteAboutMeById(id);
	}
}
