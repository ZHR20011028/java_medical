package com.example.controller;

import com.example.entity.DiagnosisPatientDoctor;
import com.example.service.DiagnosisPatientDoctorService;
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
 * @Date: 2024/1/7
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/diagnosisPatientDoctors")
public class DiagnosisPatientDoctorController {
    @Autowired
    private DiagnosisPatientDoctorService diagnosisPatientDoctorService;
    @GetMapping
    public Result getAllDiagnosis(@RequestParam("patientId") Long patientId){
        List<DiagnosisPatientDoctor> diagnosisPatientDoctorList = diagnosisPatientDoctorService.selectAllDiagnosis(patientId);
        if (!diagnosisPatientDoctorList.isEmpty()){
            return new Result(Code.GET_OK,diagnosisPatientDoctorList);
        }else {
            return new Result(Code.GET_ERR,null,"请求失败！");
        }
    }
}
