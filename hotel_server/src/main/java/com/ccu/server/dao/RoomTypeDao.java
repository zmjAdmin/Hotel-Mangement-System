package com.ccu.server.dao;

import com.ccu.server.entity.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (RoomType)表数据库访问层
 *
 * @author zmj
 * @since 2022-07-09 13:47:30
 */
@Mapper
public interface RoomTypeDao {

    /**
     * 查询所有数据
     *
     * @param roomType 查询条件
     * @return 对象列表
     */
    List<RoomType> queryAll(RoomType roomType);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoomType queryById(@Param("id") Integer id);

    /**
     * 插入一条数据
     *
     * @param roomType 实例对象
     * @return 受影响行数
     */
    int insert(RoomType roomType);

    /**
     * 通过主键修改数据
     *
     * @param roomType 实例对象
     * @return 受影响行数
     */
    int update(RoomType roomType);

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
     * @param roomType 查询条件
     * @return 统计总行数
     */
    long count(RoomType roomType);

}

