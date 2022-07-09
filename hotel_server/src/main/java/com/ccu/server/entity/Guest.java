package com.ccu.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Guest)实体类
 *
 * @author zmj
 * @since 2022-07-09 13:46:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {

    /**
     * 顾客ID
     */
    private Integer guestId;

    /**
     * 顾客姓名
     */
    private String guestName;

    /**
     * 顾客性别
     */
    private String guestGander;

    /**
     * 顾客身份证号码
     */
    private String guestIdcard;

    /**
     * 顾客手机号码
     */
    private String guestPhoneNumber;

    /**
     * 逻辑删除
     */
    private Integer guestDel;

}
