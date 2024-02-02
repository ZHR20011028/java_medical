package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.*;
import com.example.entity.*;
import com.example.service.PatientService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/20
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private RegisteredDao registeredDao;
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Map<String, Object> login(User user) {
        Doctor doctor = null;
        Patient patient = null;
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername, user.getUsername());
        lqw.eq(User::getPassword, user.getPassword());
        User userOne = userDao.selectOne(lqw);
        if (userOne != null) {
            if (userOne.getDoctorId() != null) {
                doctor = doctorDao.selectById(userOne.getDoctorId());
            } else if (userOne.getPatientId() != null) {
                patient = patientDao.selectById(userOne.getPatientId());
            }
            Map<String, Object> loginMap = new HashMap<>();
            loginMap.put("userData", userOne);
            loginMap.put("doctorData", doctor);
            loginMap.put("patientData", patient);
            return loginMap;
        } else {
            return null;
        }

    }

    @Override
    public Map<String, Object> selectRegisterData(Long patientId) {
        LambdaQueryWrapper<Registered> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Registered::getPatientId, patientId);
        Registered registered = registeredDao.selectOne(lqw);
        if (registered != null) {
            Department department = departmentDao.selectById(registered.getDeptId());
            Map<String, Object> registerMap = new HashMap<>();
            registerMap.put("deptRank", registered.getDeptRank());
            registerMap.put("deptName", department.getDeptName());
            registerMap.put("deptLocation", department.getDeptLocation());
            return registerMap;
        } else {
            return null;
        }
    }

    @Override
    public boolean insertPatientUser(User user, String idCard) {
        Patient patient = patientService.selectPatientByIdCard(idCard);
        user.setPatientId(patient.getPatientId());
        return userDao.insert(user) != 0;
    }

    @Override
    public boolean insertDoctorUser(User user) {
        return userDao.insert(user)!=0;
    }
}
