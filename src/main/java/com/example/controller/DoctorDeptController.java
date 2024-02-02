package com.example.controller;

import com.example.entity.DoctorDept;
import com.example.service.DoctorDeptService;
import com.example.service.DoctorService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/10
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/doctorDepts")
public class DoctorDeptController {
    @Autowired
    private DoctorDeptService doctorDeptService;
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public Result getPageDoctor(@RequestParam("current") Long current,@RequestParam("pageSize") Long pageSize) {
        List<DoctorDept> doctorDeptList = doctorDeptService.selectPageDoctor(current, pageSize);
        int total = doctorService.selectDoctorCount();
        if (!doctorDeptList.isEmpty()) {
            Map<String,Object> doctorMap = new HashMap<>();
            doctorMap.put("total",total);
            doctorMap.put("doctorData",doctorDeptList);
            return new Result(Code.GET_OK, doctorMap);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }
    @GetMapping("/deptId")
    public Result getDoctorByDeptId(@RequestParam("deptId") Long deptId){
        List<DoctorDept> doctorDeptList = doctorDeptService.selectDoctorByDeptId(deptId);
        if (!doctorDeptList.isEmpty()){
            return new Result(Code.GET_OK,doctorDeptList);
        }else {
            return new Result(Code.GET_ERR,null,"请求失败！");
        }
    }
    @GetMapping("/doctorId")
    public Result getDoctorByDoctorId(@RequestParam("doctorId") Long doctorId){
        DoctorDept doctorDept = doctorDeptService.selectDoctorByDoctorId(doctorId);
        if (doctorDept != null){
            return new Result(Code.GET_OK,doctorDept);
        }else {
            return new Result(Code.GET_ERR,null,"请求失败！");
        }
    }
}
