package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Department;
import com.example.service.DepartmentService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/like")
    public Result getLikeDeptByName(@RequestParam("deptLikeName") String deptLikeName){
        List<Department> departmentList = departmentService.selectLikeDepartmentList(deptLikeName);
        if (!departmentList.isEmpty()){
            return new Result(Code.GET_OK,departmentList);
        }else {
            return new Result(Code.GET_ERR,null,"请求失败！");
        }
    }

    /**
     * 根据科室名查询，科室信息
     * @param deptId 科室id
     * @return 成功20041，失败20040
     */
    @GetMapping("/one")
    public Result getDeptByDeptId(@RequestParam("deptId") Long deptId){
        Department department = departmentService.selectOneDepartmentByDeptId(deptId);
        if (department != null){
            return new Result(Code.GET_OK,department);
        }else {
            return new Result(Code.GET_ERR,null,"请求失败！");
        }
    }
    @GetMapping("/name")
    public Result getDeptByDeptName(@RequestParam("deptName") String deptName){
        Department department = departmentService.selectDepartmentByDeptName(deptName);
        if (department != null){
            return new Result(Code.GET_OK,department);
        }else {
            return new Result(Code.GET_ERR,null,"请求失败！");
        }
    }

    @PostMapping
    public Result addDept(@RequestBody Department department){
        int i = departmentService.insertDept(department);
        if (i != 0){
            return new Result(Code.SAVE_OK);
        }else {
            return new Result(Code.SAVE_ERR,null,"请求失败！");
        }
    }
    @DeleteMapping
    public Result removeDept(@RequestParam("deptId") Long deptId){
        int i = departmentService.deleteDept(deptId);
        if (i != 0){
            return new Result(Code.DELETE_OK);
        }else {
            return new Result(Code.DELETE_ERR,null,"请求失败！");
        }
    }
    @PutMapping
    public Result modifyDept(@RequestBody Department department){
        int i = departmentService.updateDept(department);
        if (i != 0){
            return new Result(Code.UPDATE_OK);
        }else {
            return new Result(Code.UPDATE_ERR,null,"请求失败！");
        }
    }
    @GetMapping("/page")
    public Result getPageDept(@RequestParam("current") Long current,@RequestParam("size") Long size){
        Page<Department> departmentPage = departmentService.selectPageDept(current, size);
        if (departmentPage!=null){
            Map<String,Object> departmentList = new HashMap<>();
            departmentList.put("total",departmentPage.getTotal());
            departmentList.put("deptData",departmentPage.getRecords());
            return new Result(Code.GET_OK,departmentList);
        }else {
            return new Result(Code.GET_ERR,null,"请求失败！");
        }
    }

    @GetMapping
    public Result getAllDept(){
        List<Department> departmentList = departmentService.selectAllDepartment();
        if (!departmentList.isEmpty()){
            return new Result(Code.GET_OK,departmentList);
        }else {
            return new Result(Code.GET_ERR,null,"请求失败");
        }
    }
}
