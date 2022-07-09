package com.ccu.server.common.utils.web;

import java.util.HashMap;

public class AjaxResult extends HashMap <String, Object> {

    /** 成功标识 */
    public static final String SUCCESS_TAG = "flag";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /** 查询成功 */
    public static final String QUERY_SUCCESS = "查询成功";

    /** 更新成功 */
    public static final String UPDATE_SUCCESS = "更新成功";

    /** 删除成功 */
    public static final String DELETE_SUCCESS = "删除成功";

    /** 插入成功 */
    public static final String INSERT_SUCCESS = "插入成功";

    //空对象
    public AjaxResult(){}

    //方便链式编程
    public AjaxResult put(String key, Object value){
        super.put(key, value);
        return this;
    }

    public AjaxResult(boolean flag, String msg, Object data){
        super.put(SUCCESS_TAG, flag);
        super.put(MSG_TAG, msg);
        if(data != null){
            super.put(DATA_TAG, data);
        }
    }

    //成功
    public static AjaxResult success(String msg, Object data){
        return new AjaxResult(true, msg, data);
    }

    //成功
    public static AjaxResult success(Object data){
        return new AjaxResult(true, "操作成功", data);
    }

    //查询成功
    public static AjaxResult querySuccess(Object data){
        return new AjaxResult(true, AjaxResult.QUERY_SUCCESS, data);
    }

    //插入成功
    public static AjaxResult insertSuccess(Object data){
        return new AjaxResult(true, AjaxResult.INSERT_SUCCESS, data);
    }

    //更新成功
    public static AjaxResult updateSuccess(Object data){
        return new AjaxResult(true, AjaxResult.UPDATE_SUCCESS, data);
    }

    //删除成功
    public static AjaxResult deleteSuccess(Object data){
        return new AjaxResult(true, AjaxResult.DELETE_SUCCESS, data);
    }

    //失败
    public static AjaxResult error(String msg, Object data){
        return new AjaxResult(false, msg, data);
    }

}
