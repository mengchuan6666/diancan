package com.qnbc.venueReservation.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qnbc.venueReservation.domain.Comment;

/**
 * 商品评论Mapper接口
 *
 * @author guzj
 * @date 2023-12-27
 */
public interface CommentMapper extends BaseMapper<Comment> {
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
	 * 删除商品评论
	 *
	 * @param id 商品评论主键
	 * @return 结果
	 */
	public int deleteCommentById(Long id);

	/**
	 * 批量删除商品评论
	 *
	 * @param ids 需要删除的数据主键集合
	 * @return 结果
	 */
	public int deleteCommentByIds(Long[] ids);
}
