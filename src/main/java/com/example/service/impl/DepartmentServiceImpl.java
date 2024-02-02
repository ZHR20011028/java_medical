package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.DepartmentDao;
import com.example.entity.Department;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Department> selectLikeDepartmentList(String deptLikeName) {
        LambdaQueryWrapper<Department> lqw = new LambdaQueryWrapper<>();
        lqw.like(Department::getDeptName, deptLikeName);
        return departmentDao.selectList(lqw);
    }

    @Override
    public List<Department> selectAllDepartment() {
        return departmentDao.selectList(null);
    }

    /**
     * 通过科室id查询科室信息
     *
     * @param deptId 科室id
     * @return 成功返回可是信息，失败null
     */
    @Override
    public Department selectOneDepartmentByDeptId(Long deptId) {
        return departmentDao.selectById(deptId);
    }

    /**
     * 通过科室名查询科室信息
     *
     * @param deptName 科室名
     * @return Department
     */
    @Override
    public Department selectDepartmentByDeptName(String deptName) {
        LambdaQueryWrapper<Department> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Department::getDeptName, deptName);
        return departmentDao.selectOne(lqw);
    }

    @Override
    public Page<Department> selectPageDept(Long current, Long size) {
        Page<Department> page = new Page<>(current, size);
        return departmentDao.selectPage(page, null);
    }

    @Override
    public int insertDept(Department department) {
        return departmentDao.insert(department);
    }

    @Override
    public int deleteDept(Long deptId) {
        return departmentDao.deleteById(deptId);
    }

    @Override
    public int updateDept(Department department) {
        LambdaQueryWrapper<Department> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Department::getDeptId, department.getDeptId());
        Department department1 = new Department(null, department.getDeptName(), department.getDeptTelephone(), department.getDeptLocation(), null);
        return departmentDao.update(department1, lqw);
    }
}
