package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Log;
import com.example.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/19
 * @Description: com.example.dao
 * @Version: 1.0
 */
@Mapper
public interface LoginLogDao extends BaseMapper<Log> {
    List<LoginLog> selectAllLoginLog(@Param("current") Long current, @Param("pageSize") Long pageSize);
    List<LoginLog> selectLikeLoginLog(@Param("username") String username);
    List<LoginLog> selectLoginLogByUsername(@Param("username") String username);
}
