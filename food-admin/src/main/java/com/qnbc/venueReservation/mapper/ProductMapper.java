package com.qnbc.venueReservation.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qnbc.venueReservation.domain.Product;
import com.qnbc.venueReservation.entity.User;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author guzj
 * @date 2023-12-27
 */
public interface ProductMapper extends BaseMapper<Product> {
	/**
	 * 查询【请填写功能名称】
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 【请填写功能名称】
	 */
	public Product selectProductById(Long id);

	/**
	 * 查询【请填写功能名称】列表
	 *
	 * @param product 【请填写功能名称】
	 * @return 【请填写功能名称】集合
	 */
	public List<Product> selectProductList(Product product);

	/**
	 * 新增【请填写功能名称】
	 *
	 * @param product 【请填写功能名称】
	 * @return 结果
	 */
	public int insertProduct(Product product);

	/**
	 * 修改【请填写功能名称】
	 *
	 * @param product 【请填写功能名称】
	 * @return 结果
	 */
	public int updateProduct(Product product);

	/**
	 * 删除【请填写功能名称】
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 结果
	 */
	public int deleteProductById(Long id);

	/**
	 * 批量删除【请填写功能名称】
	 *
	 * @param ids 需要删除的数据主键集合
	 * @return 结果
	 */
	public int deleteProductByIds(Long[] ids);
}
