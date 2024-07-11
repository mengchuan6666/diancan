package com.qnbc.venueReservation.service.impl;

import java.util.List;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qnbc.venueReservation.domain.ProductSwiperImage;
import com.qnbc.venueReservation.service.IProductSwiperImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.ProductMapper;
import com.qnbc.venueReservation.domain.Product;
import com.qnbc.venueReservation.service.IProductService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author guzj
 * @date 2023-12-27
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private IProductSwiperImageService productSwiperImageService;

	/**
	 * 查询【请填写功能名称】
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 【请填写功能名称】
	 */
	@Override
	public Product selectProductById(Long id) {
		Product product = productMapper.selectProductById(id);
		LambdaQueryWrapper<ProductSwiperImage> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper.eq(ProductSwiperImage::getProductid, product.getId());
		List<ProductSwiperImage> list = productSwiperImageService.list(lambdaQueryWrapper);
		product.setProductSwiperImageList(list);
		return product;
	}

	/**
	 * 查询【请填写功能名称】列表
	 *
	 * @param product 【请填写功能名称】
	 * @return 【请填写功能名称】
	 */
	@Override
	public List<Product> selectProductList(Product product) {
		List<Product> products = productMapper.selectProductList(product);
		for (Product product1 : products) {
			LambdaQueryWrapper<ProductSwiperImage> lambdaQueryWrapper = new LambdaQueryWrapper<>();
			lambdaQueryWrapper.eq(ProductSwiperImage::getProductid, product1.getId());
			List<ProductSwiperImage> list = productSwiperImageService.list(lambdaQueryWrapper);
			product1.setProductSwiperImageList(list);
		}
		return products;
	}

	/**
	 * 新增【请填写功能名称】
	 *
	 * @param product 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int insertProduct(Product product) {
		return productMapper.insertProduct(product);
	}

	/**
	 * 修改【请填写功能名称】
	 *
	 * @param product 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int updateProduct(Product product) {
		if (CollectionUtil.isNotEmpty(product.getProductSwiperImageList())) {
			QueryWrapper<ProductSwiperImage> eq = new QueryWrapper<ProductSwiperImage>().eq("productid", product.getId());
			productSwiperImageService.remove(eq);
			productSwiperImageService.saveBatch(product.getProductSwiperImageList());
		}
		return productMapper.updateProduct(product);
	}

	/**
	 * 批量删除【请填写功能名称】
	 *
	 * @param ids 需要删除的【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteProductByIds(Long[] ids) {
		return productMapper.deleteProductByIds(ids);
	}

	/**
	 * 删除【请填写功能名称】信息
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteProductById(Long id) {
		return productMapper.deleteProductById(id);
	}
}
