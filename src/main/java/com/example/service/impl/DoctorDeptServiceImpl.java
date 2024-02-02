package com.example.service.impl;

import com.example.dao.DoctorDeptDao;
import com.example.entity.DoctorDept;
import com.example.service.DoctorDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/10
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class DoctorDeptServiceImpl implements DoctorDeptService {
    @Autowired
    private DoctorDeptDao doctorDeptDao;

    @Override
    public List<DoctorDept> selectPageDoctor(Long current, Long pageSize) {
        return doctorDeptDao.selectPageDoctor(current - 1, pageSize);
    }

    @Override
    public List<DoctorDept> selectDoctorByDeptId(Long deptId) {
        return doctorDeptDao.selectDoctorByDeptId(deptId);
    }

    @Override
    public DoctorDept selectDoctorByDoctorId(Long doctorId) {
        return doctorDeptDao.selectDoctorByDoctorId(doctorId);
    }
}
