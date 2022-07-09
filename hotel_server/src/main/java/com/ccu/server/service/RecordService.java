package com.ccu.server.service;

import com.ccu.server.entity.Record;
import com.ccu.server.common.utils.web.PageEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Record)表服务接口
 *
 * @author zmj
 * @since 2022-07-09 13:46:50
 */
@Transactional
public interface RecordService {

    /**
     * 分页查询
     *
     * @param record   筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    PageEntity<Record> queryByPage(Record record, Integer page, Integer pageSize);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    Record queryById(Integer id);

    /**
     * 插入一条数据
     *
     * @param record 实例对象
     * @return 受影响行数
     */
    Integer insert(Record record);

    /**
     * 批量插入数据
     *
     * @param recordList 实体列表
     * @return 受影响行数
     */
    Integer batchInsert(List<Record> recordList);

    /**
     * 修改数据
     *
     * @param record 实例对象
     * @return 受影响行数
     */
    Integer update(Record record);

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
