package com.qnbc.venueReservation.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qnbc.venueReservation.domain.OrderDetail;
import com.qnbc.venueReservation.entity.User;
import com.qnbc.venueReservation.service.IOrderDetailService;
import com.qnbc.venueReservation.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.CommentMapper;
import com.qnbc.venueReservation.domain.Comment;
import com.qnbc.venueReservation.service.ICommentService;

/**
 * 商品评论Service业务层处理
 *
 * @author guzj
 * @date 2023-12-27
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {
	@Autowired
	private CommentMapper commentMapper;

	@Autowired
	private IOrderDetailService orderDetailService;

	/**
	 * 查询商品评论
	 *
	 * @param id 商品评论主键
	 * @return 商品评论
	 */
	@Override
	public Comment selectCommentById(Long id) {
		return commentMapper.selectCommentById(id);
	}

	/**
	 * 查询商品评论列表
	 *
	 * @param comment 商品评论
	 * @return 商品评论
	 */
	@Override
	public List<Comment> selectCommentList(Comment comment) {
		return commentMapper.selectCommentList(comment);
	}

	/**
	 * 新增商品评论
	 *
	 * @param comment 商品评论
	 * @return 结果
	 */
	@Override
	public int insertComment(Comment comment) {
		User currentUser = TokenUtils.getCurrentUser();
		comment.setUserid(Long.valueOf(currentUser.getId()));
		return commentMapper.insertComment(comment);
	}

	/**
	 * 修改商品评论
	 *
	 * @param comment 商品评论
	 * @return 结果
	 */
	@Override
	public int updateComment(Comment comment) {
		return commentMapper.updateComment(comment);
	}

	/**
	 * 批量删除商品评论
	 *
	 * @param ids 需要删除的商品评论主键
	 * @return 结果
	 */
	@Override
	public int deleteCommentByIds(Long[] ids) {
		return commentMapper.deleteCommentByIds(ids);
	}

	/**
	 * 删除商品评论信息
	 *
	 * @param id 商品评论主键
	 * @return 结果
	 */
	@Override
	public int deleteCommentById(Long id) {
		return commentMapper.deleteCommentById(id);
	}

	@Override
	public List<Comment> appletList(Comment comment) {
		User currentUser = TokenUtils.getCurrentUser();

		LambdaQueryWrapper<Comment> lambdaQueryWrapperComment = new LambdaQueryWrapper();
		lambdaQueryWrapperComment.eq(Comment::getUserid, currentUser.getId());
		List<Comment> list = commentMapper.selectList(lambdaQueryWrapperComment);

		for (Comment comment1 : list) {
			LambdaQueryWrapper<OrderDetail> lambdaQueryWrapper = new LambdaQueryWrapper();
			lambdaQueryWrapper.eq(OrderDetail::getMid, comment1.getRefid());
			List<OrderDetail> list1 = orderDetailService.list(lambdaQueryWrapper);
			comment1.setOrderDetails(list1);
		}
		return list;
	}
}
