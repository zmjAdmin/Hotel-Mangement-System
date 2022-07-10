package com.ccu.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Vip)实体类
 *
 * @author zmj
 * @since 2022-07-09 13:48:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vip {

    /**
     * vipID
     */
    private Integer vipId;

    /**
     * 顾客
     */
    private Guest guest;

    /**
     * vip卡号
     */
    private String vipCard;

    /**
     * 积分
     */
    private Integer vipIntegral;

    /**
     * 逻辑删除
     */
    private Integer vipDel;

}
