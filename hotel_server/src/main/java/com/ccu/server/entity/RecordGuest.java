package com.ccu.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 入住记录-顾客(RecordGuest)实体类
 *
 * @author zmj
 * @since 2022-07-11 12:27:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordGuest {

    /**
     * 主键
     */
    private Integer recordGuestId;

    /**
     * 入住记录
     */
    private Record record;

    /**
     * 顾客
     */
    private Guest guest;

}
