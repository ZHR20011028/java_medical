package com.example.controller;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/25
 * @Description: com.example.controller
 * @Version: 1.0
 */
public class Result {
    private Integer code;
    private Object data;
    private String message;

    public Result() {
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
