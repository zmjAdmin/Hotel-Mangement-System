package com.ccu.server.service.impl;

import com.ccu.server.entity.RoomType;
import com.ccu.server.dao.RoomTypeDao;
import com.ccu.server.service.RoomTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ccu.server.common.utils.web.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (RoomType)表服务实现类
 *
 * @author zmj
 * @since 2022-07-09 13:47:30
 */
@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeDao roomTypeDao;

    /**
     * 分页查询
     *
     * @param roomType 筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    @Override
    public PageEntity<RoomType> queryByPage(RoomType roomType, Integer page, Integer pageSize) {
        //如果当前用户为超级管理员，查找所有房间类型
        //如果当前用户为普通前台用户，只查找未删除的房间类型
        roomType = this.initDel(roomType);
        PageHelper.startPage(page, pageSize);
        PageInfo<RoomType> pageInfo = new PageInfo<>(this.roomTypeDao.queryAll(roomType));
        return new PageEntity<RoomType>(pageInfo.getList(), (long) pageInfo.getPageNum(), pageInfo.getTotal());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Override
    public RoomType queryById(Integer id) {
        //如果当前用户为超级管理员，继续查找
        //如果当前用户为普通前台用户，只查找未删除的房间
        RoomType roomType = new RoomType();
        roomType.setRoomTypeId(id);
        roomType = this.initDel(roomType);
        return this.roomTypeDao.queryAll(roomType).get(0);
    }

    /**
     * 插入一条数据
     *
     * @param roomType 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer insert(RoomType roomType) {
        //初始化删除字段
        roomType = this.initDel(roomType);
        return this.roomTypeDao.insert(roomType);
    }

    /**
     * 批量插入数据
     *
     * @param roomTypeList 实体列表
     * @return 受影响行数
     */
    @Override
    public Integer batchInsert(List<RoomType> roomTypeList) {
        int num = 0;
        for (RoomType roomType : roomTypeList) {
            num += this.roomTypeDao.insert(roomType);
        }
        return num;
    }

    /**
     * 通过主键修改数据
     *
     * @param roomType 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer update(RoomType roomType) {
        return this.roomTypeDao.update(roomType);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 受影响行数
     */
    @Override
    public Integer deleteById(Integer id) {
        //如果当前用户为超级管理员，直接删除
        //return this.roomTypeDao.deleteById(id);
        //如果当前用户为普通前台用户，调用更新，进行逻辑删除
        RoomType roomType = new RoomType();
        roomType.setRoomTypeId(id);
        roomType = this.setDel(roomType, 1);
        return this.update(roomType);
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
            num += this.deleteById(id);
        }
        return num;
    }

    /**
     * 初始化删除字段
     *
     * @param roomType 房间类型
     * @return 房间类型实体
     */
    private RoomType initDel(RoomType roomType){
        return this.setDel(roomType, 0);
    }

    /**
     * 设置删除字段
     *
     * @param roomType 房间实体
     * @param del 是否删除
     * @return 房间实体
     */
    private RoomType setDel(RoomType roomType, Integer del){
        if (roomType == null) {
            roomType = new RoomType();
        }
        roomType.setRoomTypeDel(del);
        return roomType;
    }

}
