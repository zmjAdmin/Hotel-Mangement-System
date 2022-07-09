package com.ccu.server.controller;

import com.ccu.server.entity.SystemInfo;
import com.ccu.server.service.SystemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import com.ccu.server.common.utils.web.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (SystemInfo)控制层
 *
 * @author zmj
 * @since 2022-07-09 13:47:46
 */
@RestController
@RequestMapping("systemInfo")
public class SystemInfoController {

    /**
     * 服务对象
     */
    @Autowired
    private SystemInfoService systemInfoService;

    /**
     * 分页查询
     *
     * @param systemInfo 筛选条件
     * @param page       当前页
     * @param pageSize   每页的条数
     * @return 查询结果
     */
    @GetMapping("/{page}/{pageSize}")
    public AjaxResult queryByPage(@RequestParam SystemInfo systemInfo, @PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        return AjaxResult.querySuccess(this.systemInfoService.queryByPage(systemInfo, page, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public AjaxResult queryById(@PathVariable("id") Integer id) {
        return AjaxResult.querySuccess(this.systemInfoService.queryById(id));
    }

    /**
     * 插入一条数据
     *
     * @param systemInfo 实体
     * @return 插入结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody SystemInfo systemInfo) {
        return AjaxResult.insertSuccess(this.systemInfoService.insert(systemInfo));
    }

    /**
     * 批量插入数据
     *
     * @param systemInfoList 实体列表
     * @return 插入结果
     */
    @PostMapping
    public AjaxResult batchInsert(@RequestBody List<SystemInfo> systemInfoList) {
        return AjaxResult.insertSuccess(this.systemInfoService.batchInsert(systemInfoList));
    }

    /**
     * 通过主键修改数据
     *
     * @param systemInfo 实体
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody SystemInfo systemInfo) {
        return AjaxResult.updateSuccess(this.systemInfoService.update(systemInfo));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public AjaxResult deleteById(@PathVariable("id") Integer id) {
        return AjaxResult.deleteSuccess(this.systemInfoService.deleteById(id));
    }

    /**
     * 通过主键批量删除数据
     *
     * @param ids 主键数组
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult batchDelete(@RequestBody Integer[] ids) {
        return AjaxResult.deleteSuccess(this.systemInfoService.batchDelete(ids));
    }

}

