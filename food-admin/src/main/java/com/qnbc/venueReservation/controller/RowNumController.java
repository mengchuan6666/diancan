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
import com.qnbc.venueReservation.domain.RowNum;
import com.qnbc.venueReservation.service.IRowNumService;

/**
 * 排号记录
 *
 * @author guzj
 * @date 2023-12-27
 */
@RestController
@RequestMapping("/venueReservation/num")
public class RowNumController extends BaseController
{
    @Autowired
    private IRowNumService rowNumService;

    /**
     * 查询排号记录列表
     */
    @GetMapping("/list")
    public TableDataInfo list(RowNum rowNum)
    {
        startPage();
        List<RowNum> list = rowNumService.selectRowNumList(rowNum);
        return getDataTable(list);
    }

    /**
     * 导出排号记录列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, RowNum rowNum)
    {
        List<RowNum> list = rowNumService.selectRowNumList(rowNum);
        ExcelUtil<RowNum> util = new ExcelUtil<RowNum>(RowNum.class);
        util.exportExcel(response, list, "排号记录数据");
    }

    /**
     * 获取排号记录详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(rowNumService.selectRowNumById(id));
    }

    /**
     * 新增排号记录
     */
    @PostMapping
    public AjaxResult add(@RequestBody RowNum rowNum)
    {
        return toAjax(rowNumService.insertRowNum(rowNum));
    }

    /**
     * 修改排号记录
     */
    @PutMapping
    public AjaxResult edit(@RequestBody RowNum rowNum)
    {
        return toAjax(rowNumService.updateRowNum(rowNum));
    }

    /**
     * 删除排号记录
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rowNumService.deleteRowNumByIds(ids));
    }
}
