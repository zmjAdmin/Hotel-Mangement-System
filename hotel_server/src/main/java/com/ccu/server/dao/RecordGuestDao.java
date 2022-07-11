package com.ccu.server.dao;

import com.ccu.server.entity.RecordGuest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 入住记录-顾客(RecordGuest)表数据库访问层
 *
 * @author zmj
 * @since 2022-07-11 12:27:51
 */
@Mapper
public interface RecordGuestDao {

    /**
     * 查询所有数据
     *
     * @param recordGuest 查询条件
     * @return 对象列表
     */
    List<RecordGuest> queryAll(RecordGuest recordGuest);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RecordGuest queryById(@Param("id") Integer id);

    /**
     * 插入一条数据
     *
     * @param recordGuest 实例对象
     * @return 受影响行数
     */
    int insert(RecordGuest recordGuest);

    /**
     * 通过主键修改数据
     *
     * @param recordGuest 实例对象
     * @return 受影响行数
     */
    int update(RecordGuest recordGuest);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 统计总行数
     *
     * @param recordGuest 查询条件
     * @return 统计总行数
     */
    long count(RecordGuest recordGuest);

}

