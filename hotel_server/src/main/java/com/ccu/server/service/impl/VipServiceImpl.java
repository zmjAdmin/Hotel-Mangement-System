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
        //如果当前用户为超级管理员，查找所有Vip客户
        //如果当前用户为普通前台用户，只查找未删除的Vip客户
        vip = this.initDel(vip);
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
        //如果当前用户为超级管理员，继续查找
        //如果当前用户为普通前台用户，只查找未删除的房间
        Vip vip = new Vip();
        vip.setVipId(id);
        vip = this.initDel(vip);
        return this.vipDao.queryAll(vip).get(0);
    }

    /**
     * 插入一条数据
     *
     * @param vip 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer insert(Vip vip) {
        //初始化删除字段
        vip = this.initDel(vip);
        vip.setVipCard(this.generateVipCard());
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
        //如果当前用户为超级管理员，直接删除
        //return this.update(roomType);
        //如果当前用户为普通前台用户，调用更新，进行逻辑删除
        Vip vip = new Vip();
        vip.setVipId(id);
        vip = this.setDel(vip, 1);
        return this.update(vip);
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
     * @param vip 房间类型
     * @return 房间类型实体
     */
    private Vip initDel(Vip vip){
        return this.setDel(vip, 0);
    }

    /**
     * 设置删除字段
     *
     * @param vip 房间实体
     * @param del 是否删除
     * @return 房间实体
     */
    private Vip setDel(Vip vip, Integer del){
        if (vip == null) {
            vip = new Vip();
        }
        vip.setVipDel(del);
        return vip;
    }

    private String generateVipCard(){
        return null;
    }

}
