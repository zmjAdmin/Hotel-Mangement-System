package com.ccu.server.service.impl;

import com.ccu.server.entity.Vip;
import com.ccu.server.dao.VipDao;
import com.ccu.server.service.VipService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ccu.server.common.utils.web.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Vip)表服务实现类
 *
 * @author zmj
 * @since 2022-07-09 13:48:06
 */
@Service
public class VipServiceImpl implements VipService {

    @Autowired
    private VipDao vipDao;

    /**
     * 分页查询
     *
     * @param vip      筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    @Override
    public PageEntity<Vip> queryByPage(Vip vip, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        PageInfo<Vip> pageInfo = new PageInfo<>(this.vipDao.queryAll(vip));
        return new PageEntity<Vip>(pageInfo.getList(), (long) pageInfo.getPageNum(), pageInfo.getTotal());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Override
    public Vip queryById(Integer id) {
        return this.vipDao.queryById(id);
    }

    /**
     * 插入一条数据
     *
     * @param vip 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer insert(Vip vip) {
        return this.vipDao.insert(vip);
    }

    /**
     * 批量插入数据
     *
     * @param vipList 实体列表
     * @return 受影响行数
     */
    @Override
    public Integer batchInsert(List<Vip> vipList) {
        int num = 0;
        for (Vip vip : vipList) {
            num += this.vipDao.insert(vip);
        }
        return num;
    }

    /**
     * 通过主键修改数据
     *
     * @param vip 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer update(Vip vip) {
        return this.vipDao.update(vip);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 受影响行数
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.vipDao.deleteById(id);
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
            num += this.vipDao.deleteById(id);
        }
        return num;
    }

}
