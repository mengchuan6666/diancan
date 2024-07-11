package com.qnbc.venueReservation.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.WxuserinfoMapper;
import com.qnbc.venueReservation.domain.Wxuserinfo;
import com.qnbc.venueReservation.service.IWxuserinfoService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author guzj
 * @date 2023-12-27
 */
@Service
public class WxuserinfoServiceImpl extends ServiceImpl<WxuserinfoMapper, Wxuserinfo> implements IWxuserinfoService {
	@Autowired
	private WxuserinfoMapper wxuserinfoMapper;

	/**
	 * 查询【请填写功能名称】
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 【请填写功能名称】
	 */
	@Override
	public Wxuserinfo selectWxuserinfoById(Long id) {
		return wxuserinfoMapper.selectWxuserinfoById(id);
	}

	@Override
	public Wxuserinfo selectWxuserinfoByOpenId(String openId) {
		LambdaQueryWrapper<Wxuserinfo> lambdaQueryWrapper = new LambdaQueryWrapper();
		lambdaQueryWrapper.eq(Wxuserinfo::getOpenid, openId);
		Wxuserinfo wxuserinfo = wxuserinfoMapper.selectOne(lambdaQueryWrapper);
		return wxuserinfo;
	}

	/**
	 * 查询【请填写功能名称】列表
	 *
	 * @param wxuserinfo 【请填写功能名称】
	 * @return 【请填写功能名称】
	 */
	@Override
	public List<Wxuserinfo> selectWxuserinfoList(Wxuserinfo wxuserinfo) {
		return wxuserinfoMapper.selectWxuserinfoList(wxuserinfo);
	}

	/**
	 * 新增【请填写功能名称】
	 *
	 * @param wxuserinfo 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int insertWxuserinfo(Wxuserinfo wxuserinfo) {
		return wxuserinfoMapper.insertWxuserinfo(wxuserinfo);
	}

	/**
	 * 修改【请填写功能名称】
	 *
	 * @param wxuserinfo 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int updateWxuserinfo(Wxuserinfo wxuserinfo) {
		return wxuserinfoMapper.updateWxuserinfo(wxuserinfo);
	}

	/**
	 * 批量删除【请填写功能名称】
	 *
	 * @param ids 需要删除的【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteWxuserinfoByIds(Long[] ids) {
		return wxuserinfoMapper.deleteWxuserinfoByIds(ids);
	}

	/**
	 * 删除【请填写功能名称】信息
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteWxuserinfoById(Long id) {
		return wxuserinfoMapper.deleteWxuserinfoById(id);
	}
}
