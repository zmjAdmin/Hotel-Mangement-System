package com.ccu.server.service.impl;

import com.ccu.server.entity.Record;
import com.ccu.server.entity.RecordGuest;
import com.ccu.server.dao.RecordGuestDao;
import com.ccu.server.service.GuestService;
import com.ccu.server.service.RecordGuestService;
import com.ccu.server.service.RecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ccu.server.common.utils.web.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 入住记录-顾客(RecordGuest)表服务实现类
 *
 * @author zmj
 * @since 2022-07-11 12:27:50
 */
@Service
public class RecordGuestServiceImpl implements RecordGuestService {

    @Autowired
    private RecordGuestDao recordGuestDao;

    @Autowired
    private RecordService recordService;

    @Autowired
    private GuestService guestService;

    /**
     * 分页查询
     *
     * @param recordGuest 筛选条件
     * @param page        当前页
     * @param pageSize    每页的条数
     * @return 查询结果
     */
    @Override
    public PageEntity<RecordGuest> queryByPage(RecordGuest recordGuest, Integer page, Integer pageSize) {
        if(recordGuest == null){
            recordGuest = new RecordGuest();
        }
        if(recordGuest.getRecord() == null){
            Record record = new Record();
            recordGuest.setRecord(record);
        }
        recordGuest.getRecord().setRecordDel(0);
        //recordGuest.setRecord(recordServiceImpl.initDel(recordGuest.getRecord()));
        PageHelper.startPage(page, pageSize);
        PageInfo<RecordGuest> pageInfo = new PageInfo<>(this.recordGuestDao.queryAll(recordGuest));
        return new PageEntity<RecordGuest>(pageInfo.getList(), (long) pageInfo.getPageNum(), pageInfo.getTotal());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Override
    public RecordGuest queryById(Integer id) {
        RecordGuest recordGuest = new RecordGuest();
        recordGuest.setRecordGuestId(id);
        return this.queryByPage(recordGuest, 1, 1).getData().get(0);
    }

    /**
     * 插入一条数据
     *
     * @param recordGuest 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer insert(RecordGuest recordGuest) {
        return this.recordGuestDao.insert(recordGuest);
    }

    /**
     * 批量插入数据
     *
     * @param recordGuestList 实体列表
     * @return 受影响行数
     */
    @Override
    public Integer batchInsert(List<RecordGuest> recordGuestList) {
        int num = 0;
        for (RecordGuest recordGuest : recordGuestList) {
            num += this.recordGuestDao.insert(recordGuest);
        }
        return num;
    }

    /**
     * 通过主键修改数据
     *
     * @param recordGuest 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer update(RecordGuest recordGuest) {
        return this.recordService.update(recordGuest.getRecord());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 受影响行数
     */
    @Override
    public Integer deleteById(Integer id) {
        Record record = new Record();
        record.setRecordId(id);
        record.setRecordDel(1);
        return this.recordService.update(record);
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
     * 入住登记
     *
     * @param recordGuests 入住记录-顾客实体
     * @return 受影响行数
     */
    public Integer checkIn(RecordGuest[] recordGuests){
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        //插入入住记录
        num1 = this.recordService.insert(recordGuests[0].getRecord());
        for(RecordGuest recordGuest : recordGuests){
            recordGuest.getRecord().setRecordId(recordGuests[0].getRecord().getRecordId());
        }
        //插入顾客
        for(RecordGuest recordGuest : recordGuests){
            num2 += this.guestService.insert(recordGuest.getGuest());
            //插入入住记录-顾客
            num3 += this.recordGuestDao.insert(recordGuest);
        }
        return num1 + num2 + num3;
    }

}
