package com.ccu.server.controller;

import com.ccu.server.entity.Vip;
import com.ccu.server.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import com.ccu.server.common.utils.web.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Vip)控制层
 *
 * @author zmj
 * @since 2022-07-09 13:48:06
 */
@RestController
@RequestMapping("vip")
public class VipController {

    /**
     * 服务对象
     */
    @Autowired
    private VipService vipService;

    /**
     * 分页查询
     *
     * @param vip      筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    @GetMapping("/{page}/{pageSize}")
    public AjaxResult queryByPage(@RequestParam Vip vip, @PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        return AjaxResult.querySuccess(this.vipService.queryByPage(vip, page, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public AjaxResult queryById(@PathVariable("id") Integer id) {
        return AjaxResult.querySuccess(this.vipService.queryById(id));
    }

    /**
     * 插入一条数据
     *
     * @param vip 实体
     * @return 插入结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody Vip vip) {
        return AjaxResult.insertSuccess(this.vipService.insert(vip));
    }

    /**
     * 批量插入数据
     *
     * @param vipList 实体列表
     * @return 插入结果
     */
    @PostMapping
    public AjaxResult batchInsert(@RequestBody List<Vip> vipList) {
        return AjaxResult.insertSuccess(this.vipService.batchInsert(vipList));
    }

    /**
     * 通过主键修改数据
     *
     * @param vip 实体
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody Vip vip) {
        return AjaxResult.updateSuccess(this.vipService.update(vip));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public AjaxResult deleteById(@PathVariable("id") Integer id) {
        return AjaxResult.deleteSuccess(this.vipService.deleteById(id));
    }

    /**
     * 通过主键批量删除数据
     *
     * @param ids 主键数组
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult batchDelete(@RequestBody Integer[] ids) {
        return AjaxResult.deleteSuccess(this.vipService.batchDelete(ids));
    }

}

