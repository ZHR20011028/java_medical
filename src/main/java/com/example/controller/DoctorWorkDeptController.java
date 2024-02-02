package com.example.controller;

import com.example.entity.DoctorWorkDept;
import com.example.service.DoctorWorkDeptService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/3
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/doctorWorkDepts")
public class DoctorWorkDeptController {
    @Autowired
    private DoctorWorkDeptService doctorWorkDeptService;

    /**
     * 返回所有的值班信息
     *
     * @return 成功20041，失败20040
     */
    @GetMapping
    public Result getAll() {
        List<DoctorWorkDept> workAll = doctorWorkDeptService.getAll();
        if (!workAll.isEmpty()) {
            return new Result(Code.GET_OK, workAll);
        }
        return new Result(Code.GET_ERR, null, "请求失败！");
    }
}
