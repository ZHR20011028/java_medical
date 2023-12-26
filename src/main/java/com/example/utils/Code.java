package com.example.utils;


/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/25
 * @Description: com.example.controller
 * @Version: 1.0
 */
public class Code {
    //状态码

    public static final Integer SAVE_OK = 20011;//保存成功
    public static final Integer DELETE_OK = 20021;//删除成功
    public static final Integer UPDATE_OK = 20031;//更新成功
    public static final Integer GET_OK = 20041;//返回成功


    public static final Integer SAVE_ERR = 20010;//保存失败
    public static final Integer DELETE_ERR = 20020;//删除失败
    public static final Integer UPDATE_ERR = 20030;//更新成功
    public static final Integer GET_ERR = 20040;//返回失败

    public static final Integer SYSTEM_ERR = 50001;//系统错误
    public static final Integer SYSTEM_TIMEOUT_ERR = 50002;//系统超时
    public static final Integer SYSTEM_UNKNOWN_ERR = 59999;//系统未知错误
    public static final Integer BUSINESS_ERR = 60002;//业务错误

}
