package com.qnbc.venueReservation.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.qnbc.venueReservation.config.interceptor.AuthAccess;
import com.qnbc.venueReservation.core.controller.BaseController;
import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.core.enums.BusinessType;
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

import com.qnbc.venueReservation.domain.Smalltype;
import com.qnbc.venueReservation.service.ISmalltypeService;


/**
 * 【请填写功能名称】
 *
 * @author guzj
 * @date 2023-12-27
 */
@RestController
@RequestMapping("/venueReservation/smalltype")
public class SmalltypeController extends BaseController
{
    @Autowired
    private ISmalltypeService smalltypeService;

    /**
     * 查询【请填写功能名称】列表
     */
    @AuthAccess
    @GetMapping("/list")
    public TableDataInfo list(Smalltype smalltype)
    {
        startPage();
        List<Smalltype> list = smalltypeService.selectSmalltypeList(smalltype);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, Smalltype smalltype)
    {
        List<Smalltype> list = smalltypeService.selectSmalltypeList(smalltype);
        ExcelUtil<Smalltype> util = new ExcelUtil<Smalltype>(Smalltype.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(smalltypeService.selectSmalltypeById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PostMapping
    public AjaxResult add(@RequestBody Smalltype smalltype)
    {
        return toAjax(smalltypeService.insertSmalltype(smalltype));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PutMapping
    public AjaxResult edit(@RequestBody Smalltype smalltype)
    {
        return toAjax(smalltypeService.updateSmalltype(smalltype));
    }

    /**
     * 删除【请填写功能名称】
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(smalltypeService.deleteSmalltypeByIds(ids));
    }
}
