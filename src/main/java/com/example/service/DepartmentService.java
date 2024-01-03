package com.example.service;

import com.example.entity.Department;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/2
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface DepartmentService {
    Department selectDepartmentOne(String deptName);
}
