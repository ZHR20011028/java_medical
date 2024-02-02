package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.DoctorDao;
import com.example.entity.Department;
import com.example.entity.Doctor;
import com.example.service.DoctorService;
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
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDao doctorDao;

    @Override
    public int selectDoctorCount() {
        return doctorDao.selectCount(null);
    }

    @Override
    public List<Doctor> selectLikeDoctor(String doctorName) {
        LambdaQueryWrapper<Doctor> lqw = new LambdaQueryWrapper<>();
        lqw.like(Doctor::getDoctorName, doctorName);
        return doctorDao.selectList(lqw);
    }

    @Override
    public int deleteDoctorByDoctorId(Long doctorId) {
        return doctorDao.deleteById(doctorId);
    }

    @Override
    public int updateDoctor(Doctor doctor) {
        LambdaQueryWrapper<Doctor> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Doctor::getDoctorId, doctor.getDoctorId());
        Doctor doctor1 = new Doctor(null, doctor.getDeptId(), doctor.getDoctorName(),
                doctor.getDoctorGender(), doctor.getDoctorBirthday(),
                doctor.getDoctorTelephone(), doctor.getDateOfEntry(),
                doctor.getDegree(), doctor.getJobTitle(), doctor.getEmail(),
                null);
        return doctorDao.update(doctor1, lqw);
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
        return doctorDao.insert(doctor)!=0;
    }
}
