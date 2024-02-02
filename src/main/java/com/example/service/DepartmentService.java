package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Department;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/2
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface DepartmentService {
    List<Department> selectLikeDepartmentList(String deptLikeName);
    List<Department> selectAllDepartment();
    Department selectOneDepartmentByDeptId(Long deptId);
    Department selectDepartmentByDeptName(String deptName);

    Page<Department> selectPageDept(Long current, Long size);

    int insertDept(Department department);

    int deleteDept(Long deptId);

    int updateDept(Department department);

}
