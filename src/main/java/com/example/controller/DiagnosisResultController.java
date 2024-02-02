package com.example.controller;

import com.example.entity.DiagnosisResult;
import com.example.service.DiagnosisResultService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/5
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/diagnosisResults")
public class DiagnosisResultController {
    @Autowired
    private DiagnosisResultService diagnosisResultService;

    @GetMapping("/one")
    public Result getOneDiagnosisResult(@RequestParam("doctorId") Long doctorId, @RequestParam("patientId") Long patientId) {
        DiagnosisResult diagnosisResult = diagnosisResultService.selectOneDiagnosisResultByDoctorIdAndPatientId(doctorId, patientId);
        if (diagnosisResult != null) {
            return new Result(Code.GET_OK, diagnosisResult);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }
    @PostMapping
    public Result addDiagnosisResult(@RequestBody DiagnosisResult diagnosisResult){
        int i = diagnosisResultService.insertDiagnosisResult(diagnosisResult);
        if (i != 0){
            return new Result(Code.SAVE_OK);
        }else {
            return new Result(Code.SAVE_ERR,null,"请求失败！");
        }
    }
    @PutMapping
    public Result modifyDiagnosisResult(@RequestBody DiagnosisResult diagnosisResult){
        int i = diagnosisResultService.updateDiagnosisResult(diagnosisResult);
        if (i!=0){
            return new Result(Code.UPDATE_OK);
        }else {
            return new Result(Code.UPDATE_ERR,null,"请求失败！");
        }
    }
}
