package com.example.controller;

import com.example.entity.DoctorWorkDept;
import com.example.entity.Work;
import com.example.service.WorkService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/26
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/works")
public class WorkController {
    @Autowired
    private WorkService workService;

    //返回所有通知
    @GetMapping
    public Result getAll() {
        List<DoctorWorkDept> workAll = workService.getAll();
        if (workAll != null) {
            return new Result(Code.GET_OK, workAll);
        }
        return new Result(Code.GET_ERR, null, "请求失败！");
    }
}
