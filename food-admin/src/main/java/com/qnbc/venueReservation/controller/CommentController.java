package com.qnbc.venueReservation.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.qnbc.venueReservation.core.controller.BaseController;
import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.core.page.TableDataInfo;
import com.qnbc.venueReservation.core.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qnbc.venueReservation.domain.Comment;
import com.qnbc.venueReservation.service.ICommentService;

/**
 * 商品评论
 *
 * @author guzj
 * @date 2023-12-27
 */
@RestController
@RequestMapping("/venueReservation/comment")
public class CommentController extends BaseController {
	@Autowired
	private ICommentService commentService;

	/**
	 * 查询商品评论列表
	 */
	@GetMapping("/list")
	public TableDataInfo list(Comment comment) {
		startPage();
		List<Comment> list = commentService.selectCommentList(comment);
		return getDataTable(list);
	}

	/**
	 * 查询商品评论列表
	 */
	@GetMapping("/appletList")
	public AjaxResult appletList(Comment comment) {
		startPage();
		List<Comment> list = commentService.appletList(comment);
		return AjaxResult.success(list);
	}


	/**
	 * 导出商品评论列表
	 */
	@PostMapping("/export")
	public void export(HttpServletResponse response, Comment comment) {
		List<Comment> list = commentService.selectCommentList(comment);
		ExcelUtil<Comment> util = new ExcelUtil<Comment>(Comment.class);
		util.exportExcel(response, list, "商品评论数据");
	}

	/**
	 * 获取商品评论详细信息
	 */
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") Long id) {
		return AjaxResult.success(commentService.selectCommentById(id));
	}

	/**
	 * 新增商品评论
	 */
	@PostMapping
	public AjaxResult add(@RequestBody Comment comment) {
		return toAjax(commentService.insertComment(comment));
	}

	/**
	 * 修改商品评论
	 */
	@PutMapping
	public AjaxResult edit(@RequestBody Comment comment) {
		return toAjax(commentService.updateComment(comment));
	}

	/**
	 * 删除商品评论
	 */
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable Long[] ids) {
		return toAjax(commentService.deleteCommentByIds(ids));
	}
}
