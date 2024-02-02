package com.example.service;

import com.example.entity.DiagnosisResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/5
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface DiagnosisResultService {
    DiagnosisResult selectOneDiagnosisResultByDoctorIdAndPatientId(Long doctorId,Long patientId);
    int insertDiagnosisResult(DiagnosisResult diagnosisResult);
    int updateDiagnosisResult(DiagnosisResult diagnosisResult);
}
