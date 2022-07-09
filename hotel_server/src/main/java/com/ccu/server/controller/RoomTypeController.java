package com.ccu.server.controller;

import com.ccu.server.entity.RoomType;
import com.ccu.server.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import com.ccu.server.common.utils.web.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (RoomType)控制层
 *
 * @author zmj
 * @since 2022-07-09 18:43:34
 */
@RestController
@RequestMapping("/roomType")
public class RoomTypeController {

    /**
     * 服务对象
     */
    @Autowired
    private RoomTypeService roomTypeService;

    /**
     * 分页查询
     *
     * @param roomType 筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    @GetMapping("/{page}/{pageSize}")
    public AjaxResult queryByPage(RoomType roomType, @PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        return AjaxResult.querySuccess(this.roomTypeService.queryByPage(roomType, page, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public AjaxResult queryById(@PathVariable("id") Integer id) {
        return AjaxResult.querySuccess(this.roomTypeService.queryById(id));
    }

    /**
     * 插入一条数据
     *
     * @param roomType 实体
     * @return 插入结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody RoomType roomType) {
        return AjaxResult.insertSuccess(this.roomTypeService.insert(roomType));
    }

    /**
     * 批量插入数据
     *
     * @param roomTypeList 实体列表
     * @return 插入结果
     */
    @PostMapping("/batch")
    public AjaxResult batchInsert(@RequestBody List<RoomType> roomTypeList) {
        return AjaxResult.insertSuccess(this.roomTypeService.batchInsert(roomTypeList));
    }

    /**
     * 通过主键修改数据
     *
     * @param roomType 实体
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody RoomType roomType) {
        return AjaxResult.updateSuccess(this.roomTypeService.update(roomType));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public AjaxResult deleteById(@PathVariable("id") Integer id) {
        return AjaxResult.deleteSuccess(this.roomTypeService.deleteById(id));
    }

    /**
     * 通过主键批量删除数据
     *
     * @param ids 主键数组
     * @return 删除结果
     */
    @DeleteMapping("/batch")
    public AjaxResult batchDelete(@RequestBody Integer[] ids) {
        return AjaxResult.deleteSuccess(this.roomTypeService.batchDelete(ids));
    }

}

