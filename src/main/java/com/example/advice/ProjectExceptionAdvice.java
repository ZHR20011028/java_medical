package com.example.advice;

import com.example.exception.BusinessException;
import com.example.exception.SystemException;
import com.example.exception.TokenAuthExpiredException;
import com.example.exception.UploadException;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/25
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(TokenAuthExpiredException.class)
    public Result doTokenAuthExpiredException(TokenAuthExpiredException ex){
        return new Result(ex.getCode(),null, ex.getMessage());
    }
    @ExceptionHandler(UploadException.class)
    public Result doUploadException(UploadException ex) {
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex) {
        //记录日志
        //发邮件给开发人员
        //发短信给运维
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex) {
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex) {
        //记录日志
        //发邮件给开发人员
        //发短信给运维
        return new Result(Code.SYSTEM_UNKNOWN_ERR, null, "系统繁忙，请稍后再试");
    }
}
