package com.example.controller;

import com.example.entity.DoctorWorkDept;
import com.example.entity.Work;
import com.example.service.WorkService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Result addWork(@RequestBody Work work) {
        boolean flag = workService.addWork(work);
        if (flag) {
            return new Result(Code.SAVE_OK);
        } else {
            return new Result(Code.SAVE_ERR, null, "请求失败！");
        }
    }

    @PutMapping
    public Result modifyWork(@RequestBody Work work) {
        boolean flag = workService.modifyWork(work);
        if (flag) {
            return new Result(Code.UPDATE_OK);
        } else {
            return new Result(Code.UPDATE_ERR, null, "请求失败！");
        }
    }

}
