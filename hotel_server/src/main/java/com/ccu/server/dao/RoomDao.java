package com.ccu.server.dao;

import com.ccu.server.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Room)表数据库访问层
 *
 * @author zmj
 * @since 2022-07-09 13:47:10
 */
@Mapper
public interface RoomDao {

    /**
     * 查询所有数据
     *
     * @param room 查询条件
     * @return 对象列表
     */
    List<Room> queryAll(Room room);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Room queryById(@Param("id") Integer id);

    /**
     * 插入一条数据
     *
     * @param room 实例对象
     * @return 受影响行数
     */
    int insert(Room room);

    /**
     * 通过主键修改数据
     *
     * @param room 实例对象
     * @return 受影响行数
     */
    int update(Room room);

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
     * @param room 查询条件
     * @return 统计总行数
     */
    long count(Room room);

}

