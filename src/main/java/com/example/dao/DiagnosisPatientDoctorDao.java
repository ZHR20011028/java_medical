package com.example.dao;

import com.example.entity.DiagnosisPatientDoctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/7
 * @Description: com.example.dao
 * @Version: 1.0
 */
@Mapper
public interface DiagnosisPatientDoctorDao {
    public List<DiagnosisPatientDoctor> selectAllDiagnosisByPatientId(@Param("patientId") Long patientId);
}
