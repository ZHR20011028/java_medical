package com.example.controller;

import com.example.entity.DeptTriage;
import com.example.service.DeptTriageService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.mapping.ResultFlag;
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
@RequestMapping("/triages")
public class DeptTriageController {
    @Autowired
    private DeptTriageService deptTriageService;

    /**
     * 查询某个科室有多少人挂号
     *
     * @param deptId 科室id
     * @return 返回挂号人数
     */
    @GetMapping("/count")
    public Result getDeptTriageCountByDeptId(@RequestParam("deptId") Long deptId) {
        int count = deptTriageService.selectTriageCountByDeptId(deptId);
        if (count != 0) {
            return new Result(Code.GET_OK, count);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }

    @GetMapping("/page")
    public Result getPageTriageByDeptId(@RequestParam("deptId") Long deptId, @RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) {
        List<DeptTriage> deptTriageList = deptTriageService.selectPageTriageByDeptId(deptId, pageNumber, pageSize);
        if (!deptTriageList.isEmpty()) {
            return new Result(Code.GET_OK, deptTriageList);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }
}
