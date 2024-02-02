package com.example.dao;

import com.example.entity.DiagnosisLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/19
 * @Description: com.example.dao
 * @Version: 1.0
 */
@Mapper
public interface DiagnosisLogDao {
    List<DiagnosisLog> selectPageDiagnosisLog(@Param("current") Long current, @Param("pageSize") Long pageSize);
    int selectDiagnosisTotal();

    List<DiagnosisLog> selectDiagnosisLogByDoctorName(@Param("doctorName") String doctorName);
}
