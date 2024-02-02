package com.example.controller;

import com.example.entity.Log;
import com.example.service.LogService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/19
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/logs")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping
    public Result addLog(@RequestBody Log log) {
        boolean flag = logService.insertLog(log);
        if (flag) {
            return new Result(Code.SAVE_OK);
        } else {
            return new Result(Code.SAVE_ERR, null, "请求失败!");
        }
    }
}
