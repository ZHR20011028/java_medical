package com.example.exception;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/9/10
 * @Description: com.example.exception
 * @Version: 1.0
 */
public class TokenAuthExpiredException extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public TokenAuthExpiredException() {
    }

    public TokenAuthExpiredException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public TokenAuthExpiredException(Integer code, Throwable cause, String message) {
        super(message, cause);
        this.code = code;
    }
}
