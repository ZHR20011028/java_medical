package com.example.exception;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/25
 * @Description: com.example.exception
 * @Version: 1.0
 * 系统异常
 */
public class SystemException extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SystemException(Integer code,String message)  {
        super(message);
        this.code = code;
    }
    public SystemException(Integer code,Throwable cause,String message){
        super(message,cause);
        this.code=code;
    }
}
