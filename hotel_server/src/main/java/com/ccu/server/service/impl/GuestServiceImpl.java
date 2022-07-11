package com.ccu.server.service.impl;

import com.ccu.server.dao.VipDao;
import com.ccu.server.entity.Guest;
import com.ccu.server.dao.GuestDao;
import com.ccu.server.entity.Vip;
import com.ccu.server.service.GuestService;
import com.ccu.server.service.VipService;
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

    @Autowired
    private VipDao vipDao;

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
        //如果当前用户为超级管理员，查找所有顾客
        //如果当前用户为普通前台用户，只查找未删除的顾客
        guest = this.initDel(guest);
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
        //如果当前用户为超级管理员，继续查找
        //如果当前用户为普通前台用户，只查找未删除的顾客
        Guest guest = new Guest();
        guest.setGuestId(id);
        guest = this.initDel(guest);
        return this.guestDao.queryAll(guest).get(0);
    }

    /**
     * 插入一条数据
     *
     * @param guest 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer insert(Guest guest) {
        int num1 = 0;
        int num2 = 0;
        Guest newGuest = new Guest();
        newGuest.setGuestIdcard(guest.getGuestIdcard());
        //根据顾客身份证号查询顾客
        List<Guest> list = this.queryByPage(newGuest, 1, 1).getData();
        if(list.size() > 0){
            //该顾客已经是普通顾客了
            guest.setGuestId(list.get(0).getGuestId());
            if(this.queryByPage(guest, 1, 1).getData().size() == 0){
                //该顾客的信息不准确，更新顾客信息
                num1 = this.update(guest);
            }
        }else {
            //该顾客还不是普通顾客
            guest = this.initDel(guest);
            num2 = this.guestDao.insert(guest);
        }
        return num1 + num2;
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
            num += this.insert(guest);
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
        //如果当前用户为超级管理员，直接删除
        //return this.guestDao.deleteById(id);
        //如果当前用户为普通前台用户，调用更新，进行逻辑删除
        Guest guest = new Guest();
        guest.setGuestId(id);
        guest = this.setDel(guest, 1);
        return this.update(guest);
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
     * 升级为VIP
     *
     * @param guest 顾客实体
     * @return 受影响行数
     */
    @Override
    public Integer upToVip(Guest guest){
        Vip vip = new Vip();
        vip.setGuest(guest);
        return vipDao.insert(vip);
    }

    /**
     * 初始化删除字段
     *
     * @param guest 房间类型
     * @return 房间类型实体
     */
    private Guest initDel(Guest guest){
        return this.setDel(guest, 0);
    }

    /**
     * 设置删除字段
     *
     * @param  guest 房间实体
     * @param del 是否删除
     * @return 房间实体
     */
    private Guest setDel(Guest guest, Integer del){
        if (guest == null) {
            guest = new Guest();
        }
        guest.setGuestDel(del);
        return guest;
    }

}
