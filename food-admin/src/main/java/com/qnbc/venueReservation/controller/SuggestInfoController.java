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
import com.qnbc.venueReservation.domain.SuggestInfo;
import com.qnbc.venueReservation.service.ISuggestInfoService;

/**
 * 用户建议
 *
 * @author guzj
 * @date 2023-12-27
 */
@RestController
@RequestMapping("/venueReservation/suggestInfo")
public class SuggestInfoController extends BaseController
{
    @Autowired
    private ISuggestInfoService suggestInfoService;

    /**
     * 查询用户建议列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SuggestInfo suggestInfo)
    {
        startPage();
        List<SuggestInfo> list = suggestInfoService.selectSuggestInfoList(suggestInfo);
        return getDataTable(list);
    }

    /**
     * 导出用户建议列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, SuggestInfo suggestInfo)
    {
        List<SuggestInfo> list = suggestInfoService.selectSuggestInfoList(suggestInfo);
        ExcelUtil<SuggestInfo> util = new ExcelUtil<SuggestInfo>(SuggestInfo.class);
        util.exportExcel(response, list, "用户建议数据");
    }

    /**
     * 获取用户建议详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(suggestInfoService.selectSuggestInfoById(id));
    }

    /**
     * 新增用户建议
     */
    @PostMapping
    public AjaxResult add(@RequestBody SuggestInfo suggestInfo)
    {
        return toAjax(suggestInfoService.insertSuggestInfo(suggestInfo));
    }

    /**
     * 修改用户建议
     */
    @PutMapping
    public AjaxResult edit(@RequestBody SuggestInfo suggestInfo)
    {
        return toAjax(suggestInfoService.updateSuggestInfo(suggestInfo));
    }

    /**
     * 删除用户建议
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(suggestInfoService.deleteSuggestInfoByIds(ids));
    }
}
