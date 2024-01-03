package com.example.controller;

import com.example.entity.Department;
import com.example.service.DepartmentService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/2
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 根据科室名查询，科室信息
     * @param deptName 科室名
     * @return 成功20041，失败20040
     */
    @GetMapping("/name")
    public Result getDeptByName(@RequestParam("deptName") String deptName){
        Department department = departmentService.selectDepartmentOne(deptName);
        if (department != null){
            return new Result(Code.GET_OK,department);
        }else {
            return new Result(Code.GET_ERR,null,"请求失败！");
        }
    }
}
