package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.DeptRegister;
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
public interface DeptRegisterDao {
    List<DeptRegister> selectRegisteredCount(); //返回每个科室挂号人数
    DeptRegister selectByDeptId(@Param("deptId") Long deptId);
}
