package com.ccu.server.controller;

import com.ccu.server.entity.Room;
import com.ccu.server.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import com.ccu.server.common.utils.web.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Room)控制层
 *
 * @author zmj
 * @since 2022-07-09 18:43:34
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    /**
     * 服务对象
     */
    @Autowired
    private RoomService roomService;

    /**
     * 分页查询
     *
     * @param room     筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    @GetMapping("/{page}/{pageSize}")
    public AjaxResult queryByPage(Room room, @PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        return AjaxResult.querySuccess(this.roomService.queryByPage(room, page, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public AjaxResult queryById(@PathVariable("id") Integer id) {
        return AjaxResult.querySuccess(this.roomService.queryById(id));
    }

    /**
     * 插入一条数据
     *
     * @param room 实体
     * @return 插入结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody Room room) {
        return AjaxResult.insertSuccess(this.roomService.insert(room));
    }

//    /**
//     * 批量插入数据
//     *
//     * @param roomList 实体列表
//     * @return 插入结果
//     */
//    @PostMapping("/batch")
//    public AjaxResult batchInsert(@RequestBody List<Room> roomList) {
//        return AjaxResult.insertSuccess(this.roomService.batchInsert(roomList));
//    }

    /**
     * 通过主键修改数据
     *
     * @param room 实体
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody Room room) {
        return AjaxResult.updateSuccess(this.roomService.update(room));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public AjaxResult deleteById(@PathVariable("id") Integer id) {
        return AjaxResult.deleteSuccess(this.roomService.deleteById(id));
    }

    /**
     * 通过主键批量删除数据
     *
     * @param ids 主键数组
     * @return 删除结果
     */
    @DeleteMapping("/batch")
    public AjaxResult batchDelete(@RequestBody Integer[] ids) {
        return AjaxResult.deleteSuccess(this.roomService.batchDelete(ids));
    }

}

