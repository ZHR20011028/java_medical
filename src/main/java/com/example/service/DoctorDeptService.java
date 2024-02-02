package com.example.service;

import com.example.entity.DoctorDept;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/10
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface DoctorDeptService {
    List<DoctorDept> selectPageDoctor(Long current,Long pageSize);
    List<DoctorDept> selectDoctorByDeptId(Long deptId);
    DoctorDept selectDoctorByDoctorId(Long doctorId);
}
