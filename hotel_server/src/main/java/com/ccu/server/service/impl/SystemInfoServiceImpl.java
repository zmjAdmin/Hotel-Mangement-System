package com.ccu.server.service.impl;

import com.ccu.server.entity.SystemInfo;
import com.ccu.server.dao.SystemInfoDao;
import com.ccu.server.service.SystemInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ccu.server.common.utils.web.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (SystemInfo)表服务实现类
 *
 * @author zmj
 * @since 2022-07-09 13:47:46
 */
@Service
public class SystemInfoServiceImpl implements SystemInfoService {

    @Autowired
    private SystemInfoDao systemInfoDao;

    /**
     * 分页查询
     *
     * @param systemInfo 筛选条件
     * @param page       当前页
     * @param pageSize   每页的条数
     * @return 查询结果
     */
    @Override
    public PageEntity<SystemInfo> queryByPage(SystemInfo systemInfo, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        PageInfo<SystemInfo> pageInfo = new PageInfo<>(this.systemInfoDao.queryAll(systemInfo));
        return new PageEntity<SystemInfo>(pageInfo.getList(), (long) pageInfo.getPageNum(), pageInfo.getTotal());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Override
    public SystemInfo queryById(Integer id) {
        return this.systemInfoDao.queryById(id);
    }

    /**
     * 插入一条数据
     *
     * @param systemInfo 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer insert(SystemInfo systemInfo) {
        return this.systemInfoDao.insert(systemInfo);
    }

    /**
     * 批量插入数据
     *
     * @param systemInfoList 实体列表
     * @return 受影响行数
     */
    @Override
    public Integer batchInsert(List<SystemInfo> systemInfoList) {
        int num = 0;
        for (SystemInfo systemInfo : systemInfoList) {
            num += this.systemInfoDao.insert(systemInfo);
        }
        return num;
    }

    /**
     * 通过主键修改数据
     *
     * @param systemInfo 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer update(SystemInfo systemInfo) {
        return this.systemInfoDao.update(systemInfo);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 受影响行数
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.systemInfoDao.deleteById(id);
    }

    /**
     * 通过主键批量删除数据
     *
     * @param ids 主键数组
     * @return 受影响行数
     */
    @Override
    public Integer batchDelete(Integer[] ids) {
        int num = 0;
        for (Integer id : ids) {
            num += this.systemInfoDao.deleteById(id);
        }
        return num;
    }

}
