package com.qnbc.venueReservation.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.qnbc.venueReservation.domain.Product;
import com.qnbc.venueReservation.domain.Wxuserinfo;
import com.qnbc.venueReservation.entity.User;
import com.qnbc.venueReservation.mapper.ProductMapper;
import com.qnbc.venueReservation.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.CartMapper;
import com.qnbc.venueReservation.domain.Cart;
import com.qnbc.venueReservation.service.ICartService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author guzj
 * @date 2023-12-27
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {
	@Autowired
	private CartMapper cartMapper;


	@Autowired
	private ProductMapper productMapper;

	/**
	 * 查询【请填写功能名称】
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 【请填写功能名称】
	 */
	@Override
	public Cart selectCartById(Long id) {
		return cartMapper.selectCartById(id);
	}

	/**
	 * 查询【请填写功能名称】列表
	 *
	 * @param cart 【请填写功能名称】
	 * @return 【请填写功能名称】
	 */
	@Override
	public List<Cart> selectCartList(Cart cart) {
		User currentUser = TokenUtils.getCurrentUser();
		String openId = currentUser.getOpenId();
		MPJLambdaWrapper<Cart> wrapper = new MPJLambdaWrapper<Cart>()
			.selectAll(Cart.class)//查询user表全部字段
			.selectAs(Product::getName, Cart::getName)
			.selectAs(Product::getPropic, Cart::getPropic)
			.select(Product::getPrice)
			.leftJoin(Product.class, Product::getId, Cart::getProductid)
			.eq(Cart::getUserid, openId);

		List<Cart> carts = cartMapper.selectList(wrapper);
		for (Cart cart1 : carts) {
			cart1.setPrice(cart1.getPrice());
			cart1.setStock(cart1.getNum());
		}

		return carts;
	}

	/**
	 * 新增【请填写功能名称】
	 *
	 * @param cart 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int insertCart(Cart cart) {
		User currentUser = TokenUtils.getCurrentUser();
		String userId = currentUser.getOpenId();
		cart.setUserid(userId);
		cart.setCreateTime(new Date());
		MPJLambdaWrapper<Cart> wrapper = new MPJLambdaWrapper<Cart>()
			.selectAll(Cart.class)//查询user表全部字段
			.eq(Cart::getUserid, userId);
		List<Cart> carts = cartMapper.selectList(wrapper);
		int i1 = 0;
		for (Cart cart1 : carts) {
			if (cart1.getProductid().equals(cart.getProductid())) {
				int i = cart1.getNum() + 1;
				cart1.setNum(i);
				i1 = cartMapper.updateById(cart1);
				return i1;
			}
		}
		i1 = cartMapper.insert(cart);
		return i1;
	}

	/**
	 * 修改【请填写功能名称】
	 *
	 * @param cart 【请填写功能名称】
	 * @return 结果
	 */
	@Override
	public int updateCart(Cart cart) {
		return cartMapper.updateCart(cart);
	}

	/**
	 * 批量删除【请填写功能名称】
	 *
	 * @param ids 需要删除的【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteCartByIds(Long[] ids) {
		return cartMapper.deleteCartByIds(ids);
	}

	/**
	 * 删除【请填写功能名称】信息
	 *
	 * @param id 【请填写功能名称】主键
	 * @return 结果
	 */
	@Override
	public int deleteCartById(Long id) {
		return cartMapper.deleteCartById(id);
	}

	@Override
	public Integer getTotalNum() {
		User currentUser = TokenUtils.getCurrentUser();
		String userId = currentUser.getOpenId();
		LambdaQueryWrapper<Cart> queryWrapper = Wrappers.lambdaQuery();
		queryWrapper.eq(Cart::getUserid, userId);
		List<Cart> infos = cartMapper.selectList(queryWrapper);
		return infos.stream().mapToInt(Cart::getNum).sum();
	}

	@Override
	public Integer getTotalPrice() {
		User currentUser = TokenUtils.getCurrentUser();
		String openid = currentUser.getOpenId();
		LambdaQueryWrapper<Cart> queryWrapper = Wrappers.lambdaQuery();
		queryWrapper.eq(Cart::getUserid, openid);
		List<Cart> infos = cartMapper.selectList(queryWrapper);
		List<Product> products = new ArrayList<>();
		for (Cart info : infos) {
			Product product = productMapper.selectById(info.getProductid());
			if (info.getNum() > 1) {
				product.setPrice(product.getPrice().multiply(new BigDecimal(info.getNum())));
			}
			products.add(product);
		}

//计算 总金额
		BigDecimal discount = products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
		return discount.intValue();
	}
}
