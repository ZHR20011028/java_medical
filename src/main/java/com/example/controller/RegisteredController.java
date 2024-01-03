package com.example.controller;

import com.example.entity.Registered;
import com.example.entity.RegisteredDoctorDept;
import com.example.service.RegisteredService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 查询是否挂号
     * @param patientId 患者id
     * @return 成功返回20041，失败20040
     */
    @GetMapping("/{patientId}")
    public Result getRegisterOne(@PathVariable String patientId) {
        Registered registered = registeredService.selectRegisteredByPatientId(Long.valueOf(patientId));
        if (registered != null) {
            return new Result(Code.GET_OK, registered);
        } else {
            return new Result(Code.GET_ERR, null, "返回失败！");
        }
    }

    /**
     * 返回每个部门的挂号信息和人数
     * @return 成功返回20041，失败20040
     */
    @GetMapping
    public Result getRegisters() {
        List<RegisteredDoctorDept> registeredCount = registeredService.getRegisteredCount();
        if (registeredCount != null) {
            return new Result(Code.GET_OK, registeredCount);
        }
        return new Result(Code.GET_ERR, null, "返回失败！");
    }

    /**
     * 查询某个部门的挂号情况
     * @param deptId 科室id
     * @return 成功返回挂号情况，失败20040
     */
    @GetMapping("/deptId")
    public Result getRegisterByDeptId(@RequestParam("deptId") String deptId){
        RegisteredDoctorDept registeredDoctorDept = registeredService.selectRegisteredCountByDeptId(Long.valueOf(deptId));
        if (registeredDoctorDept!=null){
            return new Result(Code.GET_OK,registeredDoctorDept);
        }else{
            return new Result(Code.GET_ERR,null,"查询失败！");
        }
    }

    /**
     * 挂号
     * @param registered 挂号实体
     * @return 成功20011，失败20010
     */
    @PostMapping
    public Result addRegister(@RequestBody Registered registered) {
        int i = registeredService.insertRegistered(registered);
        if (i != 0) {
            return new Result(Code.SAVE_OK, null);
        } else {
            return new Result(Code.SAVE_ERR, null, "挂号失败!");
        }
    }

    /**
     * 取消挂号
     * @param registered 挂号实体
     * @return 成功20021，失败20020
     */
    @DeleteMapping
    public Result removeRegister(@RequestBody Registered registered) {
        int i = registeredService.deleteRegistered(registered);
        if (i != 0) {
            return new Result(Code.DELETE_OK, null);
        } else {
            return new Result(Code.DELETE_ERR, null, "删除失败!");
        }
    }


}
