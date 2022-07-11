package com.ccu.server.controller;

import com.ccu.server.entity.RecordGuest;
import com.ccu.server.service.RecordGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import com.ccu.server.common.utils.web.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 入住记录-顾客(RecordGuest)控制层
 *
 * @author zmj
 * @since 2022-07-11 12:27:50
 */
@RestController
@RequestMapping("/recordGuest")
public class RecordGuestController {

    /**
     * 服务对象
     */
    @Autowired
    private RecordGuestService recordGuestService;

    /**
     * 分页查询
     *
     * @param recordGuest 筛选条件
     * @param page        当前页
     * @param pageSize    每页的条数
     * @return 查询结果
     */
    @GetMapping("/{page}/{pageSize}")
    public AjaxResult queryByPage(RecordGuest recordGuest, @PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        return AjaxResult.querySuccess(this.recordGuestService.queryByPage(recordGuest, page, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public AjaxResult queryById(@PathVariable("id") Integer id) {
        return AjaxResult.querySuccess(this.recordGuestService.queryById(id));
    }

//    /**
//     * 插入一条数据
//     *
//     * @param recordGuest 实体
//     * @return 插入结果
//     */
//    @PostMapping
//    public AjaxResult insert(@RequestBody RecordGuest recordGuest) {
//        return AjaxResult.insertSuccess(this.recordGuestService.insert(recordGuest));
//    }

//    /**
//     * 批量插入数据
//     *
//     * @param recordGuestList 实体列表
//     * @return 插入结果
//     */
//    @PostMapping("/batch")
//    public AjaxResult batchInsert(@RequestBody List<RecordGuest> recordGuestList) {
//        return AjaxResult.insertSuccess(this.recordGuestService.batchInsert(recordGuestList));
//    }

    /**
     * 通过主键修改数据
     *
     * @param recordGuest 实体
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody RecordGuest recordGuest) {
        return AjaxResult.updateSuccess(this.recordGuestService.update(recordGuest));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public AjaxResult deleteById(@PathVariable("id") Integer id) {
        return AjaxResult.deleteSuccess(this.recordGuestService.deleteById(id));
    }

    /**
     * 通过主键批量删除数据
     *
     * @param ids 主键数组
     * @return 删除结果
     */
    @DeleteMapping("/batch")
    public AjaxResult batchDelete(@RequestBody Integer[] ids) {
        return AjaxResult.deleteSuccess(this.recordGuestService.batchDelete(ids));
    }

    /**
     * 入住登记
     *
     * @param recordGuests 入住记录-顾客实体
     * @return 登记结果
     */
    @PostMapping("/checkIn")
    public AjaxResult checkIn(@RequestBody RecordGuest[] recordGuests){
        return AjaxResult.insertSuccess(this.recordGuestService.checkIn(recordGuests));
    }

}

