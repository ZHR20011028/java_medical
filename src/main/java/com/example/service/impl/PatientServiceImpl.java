package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.PatientDao;
import com.example.entity.Patient;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/7
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao patientDao;

    /**
     * 分页查询
     *
     * @param size    每页数据条数
     * @param current 当前页
     * @return 返回page
     */
    @Override
    public Page<Patient> selectPagePatient(Long size, Long current) {
        Page<Patient> page = new Page<>(current, size);
        return patientDao.selectPage(page, null);
    }

    /**
     * 按patientName查询patient
     *
     * @param patientId 患者id
     * @return List<Patient>
     */
    @Override
    public Patient selectPatientByPatientId(Long patientId) {
        return patientDao.selectById(patientId);
    }

    /**
     * 模糊匹配查询患者
     *
     * @param patientData 患者信息
     * @return List<Patient>
     */
    @Override
    public List<Patient> selectPatientByLike(String patientData) {
        LambdaQueryWrapper<Patient> lqw = new LambdaQueryWrapper<>();
        lqw.like(Patient::getPatientName, patientData);
        lqw.or();
        lqw.like(Patient::getIdCard, patientData);
        return patientDao.selectList(lqw);
    }

    @Override
    public boolean insertPatient(Patient patient) {
        return patientDao.insert(patient) != 0;
    }

    @Override
    public Patient selectPatientByIdCard(String idCard) {
        LambdaQueryWrapper<Patient> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Patient::getIdCard, idCard);
        return patientDao.selectOne(lqw);
    }

    @Override
    public boolean updatePatient(Patient patient) {
        LambdaQueryWrapper<Patient> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Patient::getPatientId, patient.getPatientId());
        patient.setPatientId(null);
        return patientDao.update(patient, lqw) != 0;
    }
}
