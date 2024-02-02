package com.example.service;

import com.example.entity.DiagnosisPatientDoctor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/7
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface DiagnosisPatientDoctorService {
    List<DiagnosisPatientDoctor> selectAllDiagnosis(Long patientId);
}
