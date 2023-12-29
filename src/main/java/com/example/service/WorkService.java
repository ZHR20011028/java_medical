package com.example.service;

import com.example.entity.DoctorWorkDept;
import com.example.entity.Work;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/26
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface WorkService {
    public List<DoctorWorkDept> getAll();
}
