package com.ccu.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (User)实体类
 *
 * @author zmj
 * @since 2022-07-09 13:45:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 用户ID，可以自增长
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态，默认为0，0为正常
     */
    private Integer userStatus;

    /**
     * 是否删除，默认为0，0为没有删除
     */
    private Integer userDel;

}
