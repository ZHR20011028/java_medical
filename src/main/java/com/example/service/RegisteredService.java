package com.example.service;

import com.example.entity.Registered;
import com.example.entity.RegisteredDoctorDept;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/29
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface RegisteredService {
    List<RegisteredDoctorDept> getRegisteredCount();
    int insertRegistered(Registered registered);
    int deleteRegistered(Registered registered);
    Registered selectRegisteredByPatientId(Long patientId);
    RegisteredDoctorDept selectRegisteredCountByDeptId(Long deptId);
}
