package com.example.dao;

import com.example.entity.DoctorDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/10
 * @Description: com.example.dao
 * @Version: 1.0
 */
@Mapper
public interface DoctorDeptDao {
    List<DoctorDept> selectPageDoctor(@Param("current") Long current, @Param("pageSize") Long pageSize);
    List<DoctorDept> selectDoctorByDeptId(@Param("deptId") Long deptId);
    DoctorDept selectDoctorByDoctorId(@Param("doctorId") Long doctorId);
}
