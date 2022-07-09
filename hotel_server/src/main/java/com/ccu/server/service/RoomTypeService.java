package com.ccu.server.service;

import com.ccu.server.entity.RoomType;
import com.ccu.server.common.utils.web.PageEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (RoomType)表服务接口
 *
 * @author zmj
 * @since 2022-07-09 13:47:30
 */
@Transactional
public interface RoomTypeService {

    /**
     * 分页查询
     *
     * @param roomType 筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    PageEntity<RoomType> queryByPage(RoomType roomType, Integer page, Integer pageSize);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    RoomType queryById(Integer id);

    /**
     * 插入一条数据
     *
     * @param roomType 实例对象
     * @return 受影响行数
     */
    Integer insert(RoomType roomType);

    /**
     * 批量插入数据
     *
     * @param roomTypeList 实体列表
     * @return 受影响行数
     */
    Integer batchInsert(List<RoomType> roomTypeList);

    /**
     * 修改数据
     *
     * @param roomType 实例对象
     * @return 受影响行数
     */
    Integer update(RoomType roomType);

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

}
