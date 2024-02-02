package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Patient;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/7
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface PatientService {
    Page<Patient> selectPagePatient(Long size, Long current);
    Patient selectPatientByPatientId(Long patientId);
    List<Patient> selectPatientByLike(String patientData);
    boolean insertPatient(Patient patient);
    Patient selectPatientByIdCard(String idCard);
    boolean updatePatient(Patient patient);
}
