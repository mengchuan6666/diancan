
package com.qnbc.venueReservation.service.impl;


import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qnbc.venueReservation.entity.ConfigEntity;
import com.qnbc.venueReservation.mapper.ConfigDao;
import com.qnbc.venueReservation.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigDao, ConfigEntity> implements ConfigService {
	@Autowired
	private ConfigDao configMapper;

	@Override
	public List<ConfigEntity> queryPage(ConfigEntity params) {
		return configMapper.selectList(new QueryWrapper<>());
	}

	@Override
	public int deleteBatchIds(List<Long> list) {
		int i = configMapper.deleteBatchIds(list);
		return i;
	}

	@Override
	public int deleteId(Long id) {
		int i = configMapper.deleteById(id);
		return i;
	}
}
