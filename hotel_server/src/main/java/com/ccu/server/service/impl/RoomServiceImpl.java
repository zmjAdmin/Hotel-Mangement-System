package com.ccu.server.service.impl;

import com.ccu.server.entity.Room;
import com.ccu.server.dao.RoomDao;
import com.ccu.server.service.RoomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ccu.server.common.utils.web.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Room)表服务实现类
 *
 * @author zmj
 * @since 2022-07-09 13:47:10
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;

    /**
     * 分页查询
     *
     * @param room     筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    @Override
    public PageEntity<Room> queryByPage(Room room, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        PageInfo<Room> pageInfo = new PageInfo<>(this.roomDao.queryAll(room));
        return new PageEntity<Room>(pageInfo.getList(), (long) pageInfo.getPageNum(), pageInfo.getTotal());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Override
    public Room queryById(Integer id) {
        return this.roomDao.queryById(id);
    }

    /**
     * 插入一条数据
     *
     * @param room 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer insert(Room room) {
        return this.roomDao.insert(room);
    }

    /**
     * 批量插入数据
     *
     * @param roomList 实体列表
     * @return 受影响行数
     */
    @Override
    public Integer batchInsert(List<Room> roomList) {
        int num = 0;
        for (Room room : roomList) {
            num += this.roomDao.insert(room);
        }
        return num;
    }

    /**
     * 通过主键修改数据
     *
     * @param room 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer update(Room room) {
        return this.roomDao.update(room);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 受影响行数
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.roomDao.deleteById(id);
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
            num += this.roomDao.deleteById(id);
        }
        return num;
    }

}
