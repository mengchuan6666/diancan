package com.qnbc.venueReservation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qnbc.venueReservation.core.controller.BaseController;
import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.core.page.TableDataInfo;
import com.qnbc.venueReservation.core.utils.poi.ExcelUtil;
import com.qnbc.venueReservation.domain.Collect;
import com.qnbc.venueReservation.domain.ProductSwiperImage;
import com.qnbc.venueReservation.service.ICollectService;
import com.qnbc.venueReservation.service.IProductSwiperImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qnbc.venueReservation.domain.Product;
import com.qnbc.venueReservation.service.IProductService;

/**
 * 【请填写功能名称】
 *
 * @author guzj
 * @date 2023-12-27
 */
@RestController
@RequestMapping("/venueReservation/product")
public class ProductController extends BaseController {
	@Autowired
	private IProductService productService;
	@Autowired
	private ICollectService collectService;
	@Autowired
	private IProductSwiperImageService productSwiperImageService;


	//统计
	@GetMapping("/getProductCount")
	public AjaxResult getProductCount() {
		Map<String, Object> map = new HashMap<>();
		List<Product> list = productService.list();
		long count = list.stream().filter(w -> "1".equals(w.getProStatus())).count();
		long count1 = list.stream().filter(w -> "2".equals(w.getProStatus())).count();
		map.put("upCount", count);
		map.put("downCount", count1);
		map.put("total", list.size());
		return AjaxResult.success(map);
	}


	/*
	 * 关键字搜索
	 * */
	@GetMapping("/search")
	public AjaxResult search(String q) {
		List<Product> productList = productService.list(new QueryWrapper<Product>().like("name", q));
		Map<String, Object> map = new HashMap<>();
		map.put("message", productList);
		return AjaxResult.success(map);
	}

	/*
	 * 根据id查询商品详情
	 * */
	@GetMapping("/detail")
	public AjaxResult detail(Integer id) {
		Product product = productService.getById(id);
		LambdaQueryWrapper<Collect> queryWrapper = Wrappers.lambdaQuery();
		queryWrapper.eq(Collect::getUserid, "1");
		queryWrapper.eq(Collect::getProductid, id);
		Collect one = collectService.getOne(queryWrapper);
		if (null != one) {
			product.setCollect(1);
		} else {
			product.setCollect(2);// 为收藏
		}
		List<ProductSwiperImage> productSwiperImageList = productSwiperImageService.list(new QueryWrapper<ProductSwiperImage>().eq("productid", product.getId()).orderByAsc("sort"));
		product.setProductSwiperImageList(productSwiperImageList);
		Map<String, Object> map = new HashMap<>();
		map.put("message", product);
		return AjaxResult.success(map);
	}


	/*
	 * 查询轮播商品
	 * */
	@GetMapping("/findSwiper")
	public AjaxResult findSwiper() {
		List<Product> swiperProductList = productService.list(new QueryWrapper<Product>().eq("isSwiper", true).orderByAsc("swiperSort"));
		Map<String, Object> map = new HashMap<>();
		map.put("message", swiperProductList);
		return AjaxResult.success(map);
	}


	/*
	 * 查询热门推荐4个
	 * */
	@GetMapping("/findHot")
	public AjaxResult findHot() {
		Page<Product> page = new Page<>(0, 8);
		Page<Product> pageProduct = productService.page(page, new QueryWrapper<Product>().eq("isHot", true).orderByAsc("hotDateTime"));
		List<Product> hotProductList = pageProduct.getRecords();
		Map<String, Object> map = new HashMap<>();
		map.put("message", hotProductList);
		return AjaxResult.success(map);
	}

	/**
	 * 查询【请填写功能名称】列表
	 */
	@GetMapping("/list")
	public TableDataInfo list(Product product) {
		startPage();
		List<Product> list = productService.selectProductList(product);
		return getDataTable(list);
	}

	/**
	 * 导出【请填写功能名称】列表
	 */
	@PostMapping("/export")
	public void export(HttpServletResponse response, Product product) {
		List<Product> list = productService.selectProductList(product);
		ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
		util.exportExcel(response, list, "【请填写功能名称】数据");
	}

	/**
	 * 获取【请填写功能名称】详细信息
	 */
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") Long id) {
		return AjaxResult.success(productService.selectProductById(id));
	}

	/**
	 * 新增【请填写功能名称】
	 */
	@PostMapping
	public AjaxResult add(@RequestBody Product product) {
		return toAjax(productService.insertProduct(product));
	}

	/**
	 * 修改【请填写功能名称】
	 */
	@PutMapping
	public AjaxResult edit(@RequestBody Product product) {
		return toAjax(productService.updateProduct(product));
	}

	/**
	 * 删除【请填写功能名称】
	 */
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable Long[] ids) {
		return toAjax(productService.deleteProductByIds(ids));
	}
}
