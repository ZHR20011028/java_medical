package com.example.service;

import com.example.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/20
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface UserService {
    Map<String,Object> login(User user);

    Map<String,Object> selectRegisterData(Long patientId);
    boolean insertPatientUser(User user,String idCard);
    boolean insertDoctorUser(User user);
}
