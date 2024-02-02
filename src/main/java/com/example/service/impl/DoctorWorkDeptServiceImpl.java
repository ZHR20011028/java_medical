package com.example.service.impl;

import com.example.dao.DoctorWorkDeptDao;
import com.example.entity.DoctorWorkDept;
import com.example.service.DoctorWorkDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/3
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class DoctorWorkDeptServiceImpl implements DoctorWorkDeptService {
    @Autowired
    private DoctorWorkDeptDao doctorWorkDeptDao;

    /**
     * 返回所有的值班信息
     *
     * @return 成功，返回，失败返回null
     */
    @Override
    public List<DoctorWorkDept> getAll() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return doctorWorkDeptDao.selectAllDoctorWork(dateFormat.format(date));
    }
}
