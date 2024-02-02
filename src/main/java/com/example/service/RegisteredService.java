package com.example.service;

import com.example.entity.Registered;
import com.example.entity.DeptRegister;
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

    int insertRegistered(Registered registered);
    int deleteRegistered(Registered registered);
    int updateRegisterState(Registered registered);
    Registered selectRegisteredByPatientId(Long patientId);

}
