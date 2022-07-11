package com.ccu.server.service;

import com.ccu.server.entity.RecordGuest;
import com.ccu.server.common.utils.web.PageEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 入住记录-顾客(RecordGuest)表服务接口
 *
 * @author zmj
 * @since 2022-07-11 12:27:50
 */
@Transactional
public interface RecordGuestService {

    /**
     * 分页查询
     *
     * @param recordGuest 筛选条件
     * @param page        当前页
     * @param pageSize    每页的条数
     * @return 查询结果
     */
    PageEntity<RecordGuest> queryByPage(RecordGuest recordGuest, Integer page, Integer pageSize);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    RecordGuest queryById(Integer id);

    /**
     * 插入一条数据
     *
     * @param recordGuest 实例对象
     * @return 受影响行数
     */
    Integer insert(RecordGuest recordGuest);

    /**
     * 批量插入数据
     *
     * @param recordGuestList 实体列表
     * @return 受影响行数
     */
    Integer batchInsert(List<RecordGuest> recordGuestList);

    /**
     * 修改数据
     *
     * @param recordGuest 实例对象
     * @return 受影响行数
     */
    Integer update(RecordGuest recordGuest);

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
     * 入住登记
     *
     * @param recordGuests 入住记录-顾客实体
     * @return 受影响行数
     */
    Integer checkIn(RecordGuest[] recordGuests);

}
