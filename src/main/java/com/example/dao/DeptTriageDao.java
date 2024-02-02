package com.example.dao;

import com.example.entity.DeptTriage;
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
public interface DeptTriageDao {
    int selectDeptTriageCountByDeptId(@Param("deptId") Long deptId);
    List<DeptTriage> selectPageDeptTriageByDeptId(@Param("deptId") Long deptId, @Param("start") int start, @Param("pageSize") int pageSize);
}
