package com.ccu.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 入住记录表(Record)实体类
 *
 * @author zmj
 * @since 2022-07-11 12:44:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    /**
     * 入住记录ID
     */
    private Integer recordId;

    /**
     * 房间ID
     */
    private Integer roomId;

    /**
     * 入住时间
     */
    private Timestamp enterTime;

    /**
     * 离开时间
     */
    private Timestamp exitTime;

    /**
     * 预计居住时长
     */
    private String bookingDuration;

    /**
     * 消费金额
     */
    private Double cost;

    /**
     * 预定时间
     */
    private Timestamp bookingTime;

    /**
     * 逻辑删除
     */
    private Integer recordDel;

}
