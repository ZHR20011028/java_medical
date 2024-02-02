package com.example.dao;

import com.example.entity.Duty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/13
 * @Description: com.example.dao
 * @Version: 1.0
 */
@Mapper
public interface DutyDao {
    List<Duty> selectAllDutyOK(@Param("deptId") Long deptId, @Param("workTime") String workTime);
    List<Duty> selectAllDutyNo(@Param("deptId") Long deptId, @Param("workTime") String workTime);
}
