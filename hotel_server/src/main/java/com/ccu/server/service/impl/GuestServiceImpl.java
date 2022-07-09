package com.ccu.server.service.impl;

import com.ccu.server.entity.Guest;
import com.ccu.server.dao.GuestDao;
import com.ccu.server.service.GuestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ccu.server.common.utils.web.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Guest)表服务实现类
 *
 * @author zmj
 * @since 2022-07-09 13:46:06
 */
@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestDao guestDao;

    /**
     * 分页查询
     *
     * @param guest    筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    @Override
    public PageEntity<Guest> queryByPage(Guest guest, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        PageInfo<Guest> pageInfo = new PageInfo<>(this.guestDao.queryAll(guest));
        return new PageEntity<Guest>(pageInfo.getList(), (long) pageInfo.getPageNum(), pageInfo.getTotal());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Override
    public Guest queryById(Integer id) {
        return this.guestDao.queryById(id);
    }

    /**
     * 插入一条数据
     *
     * @param guest 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer insert(Guest guest) {
        return this.guestDao.insert(guest);
    }

    /**
     * 批量插入数据
     *
     * @param guestList 实体列表
     * @return 受影响行数
     */
    @Override
    public Integer batchInsert(List<Guest> guestList) {
        int num = 0;
        for (Guest guest : guestList) {
            num += this.guestDao.insert(guest);
        }
        return num;
    }

    /**
     * 通过主键修改数据
     *
     * @param guest 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer update(Guest guest) {
        return this.guestDao.update(guest);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 受影响行数
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.guestDao.deleteById(id);
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
            num += this.guestDao.deleteById(id);
        }
        return num;
    }

}
