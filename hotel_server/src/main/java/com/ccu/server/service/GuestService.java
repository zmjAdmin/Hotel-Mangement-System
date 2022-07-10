package com.ccu.server.service;

import com.ccu.server.entity.Guest;
import com.ccu.server.common.utils.web.PageEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Guest)表服务接口
 *
 * @author zmj
 * @since 2022-07-09 13:46:06
 */
@Transactional
public interface GuestService {

    /**
     * 分页查询
     *
     * @param guest    筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    PageEntity<Guest> queryByPage(Guest guest, Integer page, Integer pageSize);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    Guest queryById(Integer id);

    /**
     * 插入一条数据
     *
     * @param guest 实例对象
     * @return 受影响行数
     */
    Integer insert(Guest guest);

    /**
     * 批量插入数据
     *
     * @param guestList 实体列表
     * @return 受影响行数
     */
    Integer batchInsert(List<Guest> guestList);

    /**
     * 修改数据
     *
     * @param guest 实例对象
     * @return 受影响行数
     */
    Integer update(Guest guest);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 受影响行数
     */
    Integer deleteById(Integer id);

    /**
     * 通过主键批量删除数据
     *
     * @param ids 主键数组
     * @return 受影响行数
     */
    Integer batchDelete(Integer[] ids);

    /**
     * 升级为VIP
     *
     * @param guest 顾客实体
     * @return 受影响行数
     */
    Integer upToVip(Guest guest);

}
