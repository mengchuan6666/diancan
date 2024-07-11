package com.qnbc.venueReservation.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qnbc.venueReservation.domain.ProductSwiperImage;

/**
 * 【请填写功能名称】Service接口
 *
 * @author guzj
 * @date 2023-12-27
 */
public interface IProductSwiperImageService extends IService<ProductSwiperImage> {
	/**
	 * 查询【请填写功能名称】
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 【请填写功能名称】
	 */
	public ProductSwiperImage selectProductSwiperImageById(Long id);

	/**
	 * 查询【请填写功能名称】列表
	 *
	 * @param productSwiperImage 【请填写功能名称】
	 * @return 【请填写功能名称】集合
	 */
	public List<ProductSwiperImage> selectProductSwiperImageList(ProductSwiperImage productSwiperImage);

	/**
	 * 新增【请填写功能名称】
	 *
	 * @param productSwiperImage 【请填写功能名称】
	 * @return 结果
	 */
	public int insertProductSwiperImage(ProductSwiperImage productSwiperImage);

	/**
	 * 修改【请填写功能名称】
	 *
	 * @param productSwiperImage 【请填写功能名称】
	 * @return 结果
	 */
	public int updateProductSwiperImage(ProductSwiperImage productSwiperImage);

	/**
	 * 批量删除【请填写功能名称】
	 *
	 * @param ids 需要删除的【请填写功能名称】主键集合
	 * @return 结果
	 */
	public int deleteProductSwiperImageByIds(Long[] ids);

	/**
	 * 删除【请填写功能名称】信息
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 结果
	 */
	public int deleteProductSwiperImageById(Long id);
}
