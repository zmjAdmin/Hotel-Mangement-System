package com.ccu.server.service;

import com.ccu.server.entity.SystemInfo;
import com.ccu.server.common.utils.web.PageEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (SystemInfo)表服务接口
 *
 * @author zmj
 * @since 2022-07-09 13:47:46
 */
@Transactional
public interface SystemInfoService {

    /**
     * 分页查询
     *
     * @param systemInfo 筛选条件
     * @param page       当前页
     * @param pageSize   每页的条数
     * @return 查询结果
     */
    PageEntity<SystemInfo> queryByPage(SystemInfo systemInfo, Integer page, Integer pageSize);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    SystemInfo queryById(Integer id);

    /**
     * 插入一条数据
     *
     * @param systemInfo 实例对象
     * @return 受影响行数
     */
    Integer insert(SystemInfo systemInfo);

    /**
     * 批量插入数据
     *
     * @param systemInfoList 实体列表
     * @return 受影响行数
     */
    Integer batchInsert(List<SystemInfo> systemInfoList);

    /**
     * 修改数据
     *
     * @param systemInfo 实例对象
     * @return 受影响行数
     */
    Integer update(SystemInfo systemInfo);

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
