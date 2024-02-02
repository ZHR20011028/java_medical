package com.example.service.impl;

import com.example.dao.DiagnosisLogDao;
import com.example.entity.DiagnosisLog;
import com.example.service.DiagnosisLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/19
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class DiagnosisLogServiceImpl implements DiagnosisLogService {
    @Autowired
    private DiagnosisLogDao diagnosisLogDao;

    @Override
    public List<DiagnosisLog> getPageDiagnosisLog(Long current, Long pageSize) {
        return diagnosisLogDao.selectPageDiagnosisLog(current - 1, pageSize);
    }

    @Override
    public int getDiagnosisLogTotal() {
        return diagnosisLogDao.selectDiagnosisTotal();
    }

    @Override
    public List<DiagnosisLog> getDiagnosisLogByDoctorName(String doctorName) {
        return diagnosisLogDao.selectDiagnosisLogByDoctorName(doctorName);
    }
}
