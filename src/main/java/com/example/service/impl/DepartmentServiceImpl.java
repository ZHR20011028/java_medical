package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.DepartmentDao;
import com.example.entity.Department;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/2
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 通过科室名查询科室信息
     * @param deptName 科室名
     * @return 成功返回可是信息，失败null
     */
    @Override
    public Department selectDepartmentOne(String deptName) {
        LambdaQueryWrapper<Department> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Department::getDeptName,deptName);
        return departmentDao.selectOne(lqw);
    }
}
