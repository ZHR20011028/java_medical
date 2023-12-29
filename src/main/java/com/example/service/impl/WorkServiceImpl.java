package com.example.service.impl;

import com.example.dao.WorkDao;
import com.example.entity.DoctorWorkDept;
import com.example.entity.Work;
import com.example.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.WatchService;
import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/26
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    private WorkDao workDao;
    @Override
    public List<DoctorWorkDept> getAll() {
        return workDao.selectAllDoctorWork();
    }
}
