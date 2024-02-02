package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.DoctorWorkDept;
import com.example.entity.Work;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/25
 * @Description: com.example.dao
 * @Version: 1.0
 */
@Mapper
public interface WorkDao extends BaseMapper<Work> {

}
