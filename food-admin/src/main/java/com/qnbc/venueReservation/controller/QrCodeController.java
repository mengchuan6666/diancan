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
import com.qnbc.venueReservation.domain.QrCode;
import com.qnbc.venueReservation.service.IQrCodeService;

/**
 * 二维码管理
 *
 * @author guzj
 * @date 2023-12-27
 */
@RestController
@RequestMapping("/venueReservation/code")
public class QrCodeController extends BaseController {
	@Autowired
	private IQrCodeService qrCodeService;

	/**
	 * 查询二维码管理列表
	 */
	@GetMapping("/list")
	public TableDataInfo list(QrCode qrCode) {
		startPage();
		List<QrCode> list = qrCodeService.selectQrCodeList(qrCode);
		return getDataTable(list);
	}

	/**
	 * 导出二维码管理列表
	 */
	@PostMapping("/export")
	public void export(HttpServletResponse response, QrCode qrCode) {
		List<QrCode> list = qrCodeService.selectQrCodeList(qrCode);
		ExcelUtil<QrCode> util = new ExcelUtil<QrCode>(QrCode.class);
		util.exportExcel(response, list, "二维码管理数据");
	}

	/**
	 * 获取二维码管理详细信息
	 */
	@GetMapping(value = "/{id}")
	public AjaxResult getInfo(@PathVariable("id") Long id) {
		return AjaxResult.success(qrCodeService.selectQrCodeById(id));
	}

	/**
	 * 新增二维码管理
	 */
	@PostMapping
	public AjaxResult add(@RequestBody QrCode qrCode) {
		return toAjax(qrCodeService.insertQrCode(qrCode));
	}

	/**
	 * 修改二维码管理
	 */
	@PutMapping
	public AjaxResult edit(@RequestBody QrCode qrCode) {
		return toAjax(qrCodeService.updateQrCode(qrCode));
	}

	/**
	 * 删除二维码管理
	 */
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable Long[] ids) {
		return toAjax(qrCodeService.deleteQrCodeByIds(ids));
	}
}
