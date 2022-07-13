package com.ccu.server.service.impl;

import com.ccu.server.entity.Record;
import com.ccu.server.dao.RecordDao;
import com.ccu.server.service.RecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ccu.server.common.utils.web.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 入住记录表(Record)表服务实现类
 *
 * @author zmj
 * @since 2022-07-11 12:44:29
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao recordDao;

    /**
     * 分页查询
     *
     * @param record   筛选条件
     * @param page     当前页
     * @param pageSize 每页的条数
     * @return 查询结果
     */
    @Override
    public PageEntity<Record> queryByPage(Record record, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        PageInfo<Record> pageInfo = new PageInfo<>(this.recordDao.queryAll(record));
        return new PageEntity<Record>(pageInfo.getList(), (long) pageInfo.getPageNum(), pageInfo.getTotal());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Override
    public Record queryById(Integer id) {
        return this.recordDao.queryById(id);
    }

    /**
     * 插入一条数据
     *
     * @param record 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer insert(Record record) {
        record = this.initDel(record);
        return this.recordDao.insert(record);
    }

//    /**
//     * 批量插入数据
//     *
//     * @param recordList 实体列表
//     * @return 受影响行数
//     */
//    @Override
//    public Integer batchInsert(List<Record> recordList) {
//        int num = 0;
//        for (Record record : recordList) {
//            num += this.recordDao.insert(record);
//        }
//        return num;
//    }

    /**
     * 通过主键修改数据
     *
     * @param record 实例对象
     * @return 受影响行数
     */
    @Override
    public Integer update(Record record) {
        return this.recordDao.update(record);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 受影响行数
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.recordDao.deleteById(id);
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
            num += this.recordDao.deleteById(id);
        }
        return num;
    }

    /**
     * 初始化删除字段
     *
     * @param record 房间类型
     * @return 房间类型实体
     */
    public Record initDel(Record record){
        return this.setDel(record, 0);
    }

    /**
     * 设置删除字段
     *
     * @param record 房间实体
     * @param del 是否删除
     * @return 房间实体
     */
    public Record setDel(Record record, Integer del){
        if (record == null) {
            record = new Record();
        }
        record.setRecordDel(del);
        return record;
    }

}
