package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.DiagnosisResultDao;
import com.example.entity.DiagnosisResult;
import com.example.service.DiagnosisResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/5
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class DiagnosisResultServiceImpl implements DiagnosisResultService {
    @Autowired
    private DiagnosisResultDao diagnosisResultDao;

    /**
     * 查询是否已诊断
     * @param doctorId 医生id
     * @param patientId 患者id
     * @return 成功返回DiagnosisResult,失败返回null
     */
    @Override
    public DiagnosisResult selectOneDiagnosisResultByDoctorIdAndPatientId(Long doctorId, Long patientId) {
        LambdaQueryWrapper<DiagnosisResult> lqw = new LambdaQueryWrapper<>();
        lqw.eq(DiagnosisResult::getDoctorId,doctorId);
        lqw.eq(DiagnosisResult::getPatientId,patientId);
        return diagnosisResultDao.selectOne(lqw);
    }

    @Override
    public int insertDiagnosisResult(DiagnosisResult diagnosisResult) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        diagnosisResult.setCreateTime(dateFormat.format(date));
        diagnosisResult.setUpdateTime(dateFormat.format(date));
        return diagnosisResultDao.insert(diagnosisResult);
    }

    @Override
    public int updateDiagnosisResult(DiagnosisResult diagnosisResult) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LambdaQueryWrapper<DiagnosisResult> lqw = new LambdaQueryWrapper<>();
        lqw.eq(DiagnosisResult::getDoctorId,diagnosisResult.getDoctorId());
        lqw.eq(DiagnosisResult::getPatientId,diagnosisResult.getPatientId());
        DiagnosisResult diagnosisResult1 = new DiagnosisResult(null,null,null,diagnosisResult.getSymptomDesc(),diagnosisResult.getSymptomIdea(),null,dateFormat.format(date),null);
        return diagnosisResultDao.update(diagnosisResult1,lqw);
    }
}
