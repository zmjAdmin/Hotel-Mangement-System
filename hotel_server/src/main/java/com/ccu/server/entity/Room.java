package com.ccu.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Room)实体类
 *
 * @author zmj
 * @since 2022-07-09 13:47:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    /**
     * 房间ID
     */
    private Integer roomId;

    /**
     * 房间号
     */
    private String roomNo;

    /**
     * 房间类型ID
     */
    private Integer roomTypeId;

    /**
     * 房间图片URL
     */
    private String roomPicture;

    /**
     * 房间状态，默认为“空房”
     */
    private String roomStatus;

    /**
     * 是否已删除，默认为0，0为没删除
     */
    private Integer roomDel;

}
