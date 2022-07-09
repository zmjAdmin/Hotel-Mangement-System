package com.ccu.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Record)实体类
 *
 * @author zmj
 * @since 2022-07-09 13:46:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    /**
     * 记录ID
     */
    private Integer recordId;

    /**
     * 顾客ID
     */
    private Integer guestId;

    /**
     * 房间ID
     */
    private Integer roomId;

    /**
     * 进入房间时间
     */
    private String enterTime;

    /**
     * 退房时间，默认“待定”
     */
    private String exitTime;

    /**
     * 预定时长
     */
    private String bookingDuration;

    /**
     * 消费金额
     */
    private Double cost;

    /**
     * 是否删除，默认0，0为未删除
     */
    private Integer recordDel;

}
