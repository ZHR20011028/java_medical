package com.example.service.impl;

import com.example.dao.DiagnosisPatientDoctorDao;
import com.example.entity.DiagnosisPatientDoctor;
import com.example.service.DiagnosisPatientDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/7
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class DiagnosisPatientDoctorServiceImpl implements DiagnosisPatientDoctorService {
    @Autowired
    private DiagnosisPatientDoctorDao diagnosisPatientDoctorDao;
    @Override
    public List<DiagnosisPatientDoctor> selectAllDiagnosis(Long patientId) {
        return diagnosisPatientDoctorDao.selectAllDiagnosisByPatientId(patientId);
    }
}
