package com.example.controller;

import com.example.entity.RegisteredDoctorDept;
import com.example.service.RegisteredService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/29
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/registers")
public class RegisteredController {
    @Autowired
    private RegisteredService registeredService;

    @GetMapping
    public Result getRegisters() {
        List<RegisteredDoctorDept> registeredCount = registeredService.getRegisteredCount();
        if (registeredCount != null) {
            return new Result(Code.GET_OK, registeredCount);
        }
        return new Result(Code.GET_ERR, null, "返回失败！");
    }
}
