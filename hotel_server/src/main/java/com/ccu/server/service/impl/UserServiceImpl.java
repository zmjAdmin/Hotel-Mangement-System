package com.ccu.server.service.impl;

import com.ccu.server.entity.User;
import com.ccu.server.dao.UserDao;
import com.ccu.server.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ccu.server.common.utils.web.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author zmj
 * @since 2022-07-09 13:45:12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 分页查询
     *
     * @param user     筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    @Override
    public PageEntity<User> queryByPage(User user, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(this.userDao.queryAll(user));
        return new PageEntity<User>(pageInfo.getList(), (long) pageInfo.getPageNum(), pageInfo.getTotal());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 插入一条数据
     *
     * @param user 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer insert(User user) {
        return this.userDao.insert(user);
    }

    /**
     * 批量插入数据
     *
     * @param userList 实体列表
     * @return 受影响行数
     */
    @Override
    public Integer batchInsert(List<User> userList) {
        int num = 0;
        for (User user : userList) {
            num += this.userDao.insert(user);
        }
        return num;
    }

    /**
     * 通过主键修改数据
     *
     * @param user 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer update(User user) {
        return this.userDao.update(user);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 受影响行数
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.userDao.deleteById(id);
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
            num += this.userDao.deleteById(id);
        }
        return num;
    }

}
