package com.example.service.impl;

import com.example.dao.RegisteredDao;
import com.example.entity.RegisteredDoctorDept;
import com.example.service.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/29
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class RegisteredServiceImpl implements RegisteredService {
    @Autowired
    private RegisteredDao registeredDao;

    @Override
    public List<RegisteredDoctorDept> getRegisteredCount() {
        return registeredDao.selectRegisteredCount();
    }
}
