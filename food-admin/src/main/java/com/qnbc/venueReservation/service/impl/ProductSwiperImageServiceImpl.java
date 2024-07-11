package com.qnbc.venueReservation.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.ProductSwiperImageMapper;
import com.qnbc.venueReservation.domain.ProductSwiperImage;
import com.qnbc.venueReservation.service.IProductSwiperImageService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author guzj
 * @date 2023-12-27
 */
@Service
public class ProductSwiperImageServiceImpl extends ServiceImpl<ProductSwiperImageMapper,ProductSwiperImage> implements IProductSwiperImageService
{
    @Autowired
    private ProductSwiperImageMapper productSwiperImageMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public ProductSwiperImage selectProductSwiperImageById(Long id)
    {
        return productSwiperImageMapper.selectProductSwiperImageById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param productSwiperImage 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ProductSwiperImage> selectProductSwiperImageList(ProductSwiperImage productSwiperImage)
    {
        return productSwiperImageMapper.selectProductSwiperImageList(productSwiperImage);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param productSwiperImage 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertProductSwiperImage(ProductSwiperImage productSwiperImage)
    {
        return productSwiperImageMapper.insertProductSwiperImage(productSwiperImage);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param productSwiperImage 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateProductSwiperImage(ProductSwiperImage productSwiperImage)
    {
        return productSwiperImageMapper.updateProductSwiperImage(productSwiperImage);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteProductSwiperImageByIds(Long[] ids)
    {
        return productSwiperImageMapper.deleteProductSwiperImageByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteProductSwiperImageById(Long id)
    {
        return productSwiperImageMapper.deleteProductSwiperImageById(id);
    }
}
