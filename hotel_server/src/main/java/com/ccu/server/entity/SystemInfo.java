package com.ccu.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (SystemInfo)实体类
 *
 * @author zmj
 * @since 2022-07-09 13:47:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemInfo {

    private Integer id;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 系统名称
     */
    private String systemName;

    /**
     * 系统欢迎词
     */
    private String welcomeWords;

}
