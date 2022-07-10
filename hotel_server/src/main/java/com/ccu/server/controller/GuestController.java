package com.ccu.server.controller;

import com.ccu.server.entity.Guest;
import com.ccu.server.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import com.ccu.server.common.utils.web.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Guest)控制层
 *
 * @author zmj
 * @since 2022-07-09 18:43:34
 */
@RestController
@RequestMapping("/guest")
public class GuestController {

    /**
     * 服务对象
     */
    @Autowired
    private GuestService guestService;

    /**
     * 分页查询
     *
     * @param guest    筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    @GetMapping("/{page}/{pageSize}")
    public AjaxResult queryByPage(Guest guest, @PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        return AjaxResult.querySuccess(this.guestService.queryByPage(guest, page, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public AjaxResult queryById(@PathVariable("id") Integer id) {
        return AjaxResult.querySuccess(this.guestService.queryById(id));
    }

    /**
     * 插入一条数据
     *
     * @param guest 实体
     * @return 插入结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody Guest guest) {
        return AjaxResult.insertSuccess(this.guestService.insert(guest));
    }

//    /**
//     * 批量插入数据
//     *
//     * @param guestList 实体列表
//     * @return 插入结果
//     */
//    @PostMapping("/batch")
//    public AjaxResult batchInsert(@RequestBody List<Guest> guestList) {
//        return AjaxResult.insertSuccess(this.guestService.batchInsert(guestList));
//    }

    /**
     * 通过主键修改数据
     *
     * @param guest 实体
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody Guest guest) {
        return AjaxResult.updateSuccess(this.guestService.update(guest));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public AjaxResult deleteById(@PathVariable("id") Integer id) {
        return AjaxResult.deleteSuccess(this.guestService.deleteById(id));
    }

    /**
     * 通过主键批量删除数据
     *
     * @param ids 主键数组
     * @return 删除结果
     */
    @DeleteMapping("/batch")
    public AjaxResult batchDelete(@RequestBody Integer[] ids) {
        return AjaxResult.deleteSuccess(this.guestService.batchDelete(ids));
    }

    /**
     * 升级为VIP
     *
     * @param guest 顾客实体
     * @return 升级结果
     */
    @PostMapping("/upToVip")
    public AjaxResult upToVip(@RequestBody Guest guest){
        return AjaxResult.insertSuccess(this.guestService.upToVip(guest));
    }

}

