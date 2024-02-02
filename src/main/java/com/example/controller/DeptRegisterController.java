package com.example.controller;

import com.example.entity.DeptRegister;
import com.example.service.DeptRegisterService;
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
 * @Date: 2024/1/3
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/deptRegisters")
public class DeptRegisterController {
    @Autowired
    private DeptRegisterService deptRegisterService;

    /**
     * 返回每个部门的挂号信息和人数
     *
     * @return 成功返回20041，失败20040
     */
    @GetMapping
    public Result getRegisters() {
        List<DeptRegister> registeredCount = deptRegisterService.getRegisteredCount();
        if (registeredCount != null) {
            return new Result(Code.GET_OK, registeredCount);
        }
        return new Result(Code.GET_ERR, null, "返回失败！");
    }

    /**
     * 查询某个部门的挂号情况
     *
     * @param deptId 科室id
     * @return 成功返回挂号情况，失败20040
     */
    @GetMapping("/deptId")
    public Result getRegisterByDeptId(@RequestParam("deptId") String deptId) {
        DeptRegister deptRegister = deptRegisterService.selectDeptRegisteredCountByDeptId(Long.valueOf(deptId));
        if (deptRegister != null) {
            return new Result(Code.GET_OK, deptRegister);
        } else {
            return new Result(Code.GET_ERR, null, "查询失败！");
        }
    }
}
