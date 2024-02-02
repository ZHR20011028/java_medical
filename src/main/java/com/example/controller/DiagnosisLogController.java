package com.example.controller;

import com.example.entity.DiagnosisLog;
import com.example.service.DiagnosisLogService;
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
 * @Date: 2024/1/19
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/diagnosisLogs")
public class DiagnosisLogController {
    @Autowired
    private DiagnosisLogService diagnosisLogService;

    @GetMapping
    public Result getPageDiagnosisLog(@RequestParam("current") Long current, @RequestParam("pageSize") Long pageSize) {
        List<DiagnosisLog> diagnosisLogList = diagnosisLogService.getPageDiagnosisLog(current, pageSize);
        int diagnosisLogTotal = diagnosisLogService.getDiagnosisLogTotal();
        if (!diagnosisLogList.isEmpty()) {
            Map<String, Object> diagnosisLogMap = new HashMap<>();
            diagnosisLogMap.put("total", diagnosisLogTotal);
            diagnosisLogMap.put("diagnosisLogData", diagnosisLogList);
            return new Result(Code.GET_OK, diagnosisLogMap);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }

    @GetMapping("/search")
    public Result getDiagnosisLogByDoctorName(@RequestParam("doctorName") String doctorName) {
        List<DiagnosisLog> diagnosisLogList = diagnosisLogService.getDiagnosisLogByDoctorName(doctorName);
        if (!diagnosisLogList.isEmpty()) {
            return new Result(Code.GET_OK, diagnosisLogList);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }
}
