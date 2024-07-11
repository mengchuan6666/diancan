package com.qnbc.venueReservation.mapper;

import com.qnbc.venueReservation.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author
 * @since 2022-02-10
 */
public interface RoleMapper extends BaseMapper<Role> {

	@Select("select id from sys_role where flag = #{flag}")
	Integer selectByFlag(@Param("flag") String flag);


	List<Role> selectByRoleKey(String siteRole);
}
