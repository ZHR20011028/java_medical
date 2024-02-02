package com.example.exception;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/11
 * @Description: com.example.exception
 * @Version: 1.0
 */
public class UploadException extends RuntimeException {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public UploadException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public UploadException(Integer code, Throwable cause, String message) {
        super(message, cause);
        this.code = code;
    }
}
