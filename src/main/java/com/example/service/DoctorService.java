package com.example.service;

import com.example.entity.Doctor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/10
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface DoctorService {
    int selectDoctorCount();
    List<Doctor> selectLikeDoctor(String doctorName);

    int deleteDoctorByDoctorId(Long doctorId);
    int updateDoctor(Doctor doctor);
    boolean addDoctor(Doctor doctor);

}
