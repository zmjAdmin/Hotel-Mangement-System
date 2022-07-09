package com.ccu.server.controller;

import com.ccu.server.entity.User;
import com.ccu.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.ccu.server.common.utils.web.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (User)控制层
 *
 * @author zmj
 * @since 2022-07-09 17:53:28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    /**
     * 分页查询
     *
     * @param user     筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    @GetMapping("/{page}/{pageSize}")
    public AjaxResult queryByPage(@RequestParam User user, @PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        return AjaxResult.querySuccess(this.userService.queryByPage(user, page, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public AjaxResult queryById(@PathVariable("id") Integer id) {
        return AjaxResult.querySuccess(this.userService.queryById(id));
    }

    /**
     * 插入一条数据
     *
     * @param user 实体
     * @return 插入结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody User user) {
        return AjaxResult.insertSuccess(this.userService.insert(user));
    }

    /**
     * 批量插入数据
     *
     * @param userList 实体列表
     * @return 插入结果
     */
    @PostMapping("/batch")
    public AjaxResult batchInsert(@RequestBody List<User> userList) {
        return AjaxResult.insertSuccess(this.userService.batchInsert(userList));
    }

    /**
     * 通过主键修改数据
     *
     * @param user 实体
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody User user) {
        return AjaxResult.updateSuccess(this.userService.update(user));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public AjaxResult deleteById(@PathVariable("id") Integer id) {
        return AjaxResult.deleteSuccess(this.userService.deleteById(id));
    }

    /**
     * 通过主键批量删除数据
     *
     * @param ids 主键数组
     * @return 删除结果
     */
    @DeleteMapping("/batch")
    public AjaxResult batchDelete(@RequestBody Integer[] ids) {
        return AjaxResult.deleteSuccess(this.userService.batchDelete(ids));
    }

}

