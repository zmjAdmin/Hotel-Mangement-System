package com.ccu.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (RoomType)实体类
 *
 * @author zmj
 * @since 2022-07-09 13:47:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomType {

    /**
     * 房间类型ID
     */
    private Integer roomTypeId;

    /**
     * 房间类型名字
     */
    private String roomTypeName;

    /**
     * 房间类型描述
     */
    private String roomTypeDescription;

    /**
     * 一天的价格
     */
    private Double dayPrice;

    /**
     * 钟点房的价格
     */
    private Double hourPrice;

    /**
     * 是否删除，默认为0，0为没有删除
     */
    private Integer roomTypeDel;

}
