package com.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/3
 * @Description: com.example.dao
 * @Version: 1.0
 */
@Mapper
public interface DoctorWorkDeptDao {
    List<com.example.entity.DoctorWorkDept> selectAllDoctorWork(@Param("workTime") String workTime); //返回值班的医生
}
