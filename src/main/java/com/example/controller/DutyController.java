package com.example.controller;

import com.example.entity.Duty;
import com.example.service.DutyService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/13
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/duties")
public class DutyController {
    @Autowired
    private DutyService dutyService;

    @GetMapping("/ok")
    public Result getAllDutyOK(@RequestParam("deptId") Long deptId, @RequestParam("workTime") String workTime) {
        List<Duty> dutyList = dutyService.getAllDutyOK(deptId, workTime);
        if (!dutyList.isEmpty()) {
            return new Result(Code.GET_OK, dutyList);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }

    @GetMapping("/no")
    public Result getAllDutyNo(@RequestParam("deptId") Long deptId,@RequestParam("workTime") String workTime) {
        List<Duty> dutyList = dutyService.getAllDutyNo(deptId,workTime);
        if (!dutyList.isEmpty()) {
            return new Result(Code.GET_OK, dutyList);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }
}
