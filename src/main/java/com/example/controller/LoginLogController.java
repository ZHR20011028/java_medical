package com.example.controller;

import com.example.entity.LoginLog;
import com.example.service.LoginLogService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/19
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/loginLogs")
public class LoginLogController {
    @Autowired
    private LoginLogService loginLogService;

    @GetMapping
    public Result getAllLoginLog(@RequestParam("current") Long current, @RequestParam("pageSize") Long pageSize) {
        List<LoginLog> loginLogList = loginLogService.getAllLoginLog(current, pageSize);
        int loginLogTotal = loginLogService.getLoginLogTotal();
        if (!loginLogList.isEmpty()) {
            Map<String, Object> loginLogMap = new HashMap<>();
            loginLogMap.put("loginLogData", loginLogList);
            loginLogMap.put("total", loginLogTotal);
            return new Result(Code.GET_OK, loginLogMap);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败");
        }
    }

    @GetMapping("/like")
    public Result getLikeLoginLog(@RequestParam("username") String username) {
        List<LoginLog> loginLogList = loginLogService.getLikeLoginLog(username);
        if (!loginLogList.isEmpty()) {
            return new Result(Code.GET_OK, loginLogList);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }

    @GetMapping("/search")
    public Result getLoginLogByUsername(@RequestParam("username") String username) {
        List<LoginLog> loginLogList = loginLogService.getLoginLogByUsername(username);
        if (!loginLogList.isEmpty()) {
            return new Result(Code.GET_OK, loginLogList);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }
}
