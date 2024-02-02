package com.example.service;

import com.example.entity.DiagnosisLog;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/19
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface DiagnosisLogService {
    List<DiagnosisLog> getPageDiagnosisLog(Long current,Long pageSize);
    int getDiagnosisLogTotal();
    List<DiagnosisLog> getDiagnosisLogByDoctorName(String doctorName);
}
