package com.qnbc.venueReservation.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qnbc.venueReservation.domain.Comment;

/**
 * 商品评论Service接口
 *
 * @author guzj
 * @date 2023-12-27
 */
public interface ICommentService extends IService<Comment> {
	/**
	 * 查询商品评论
	 *
	 * @param id 商品评论主键
	 * @return 商品评论
	 */
	public Comment selectCommentById(Long id);

	/**
	 * 查询商品评论列表
	 *
	 * @param comment 商品评论
	 * @return 商品评论集合
	 */
	public List<Comment> selectCommentList(Comment comment);

	/**
	 * 新增商品评论
	 *
	 * @param comment 商品评论
	 * @return 结果
	 */
	public int insertComment(Comment comment);

	/**
	 * 修改商品评论
	 *
	 * @param comment 商品评论
	 * @return 结果
	 */
	public int updateComment(Comment comment);

	/**
	 * 批量删除商品评论
	 *
	 * @param ids 需要删除的商品评论主键集合
	 * @return 结果
	 */
	public int deleteCommentByIds(Long[] ids);

	/**
	 * 删除商品评论信息
	 *
	 * @param id 商品评论主键
	 * @return 结果
	 */
	public int deleteCommentById(Long id);

	List<Comment> appletList(Comment comment);
}
