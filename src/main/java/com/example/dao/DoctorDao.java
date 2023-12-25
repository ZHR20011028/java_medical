package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/22
 * @Description: com.example.dao
 * @Version: 1.0
 */
@Mapper
public interface DoctorDao  extends BaseMapper<Doctor> {
}
