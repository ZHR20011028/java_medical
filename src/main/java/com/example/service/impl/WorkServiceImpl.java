package com.example.service.impl;

import com.example.dao.WorkDao;
import com.example.entity.DoctorWorkDept;
import com.example.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 返回所有的值班信息
     *
     * @return 成功，返回，失败返回null
     */
    @Override
    public List<DoctorWorkDept> getAll() {
        return workDao.selectAllDoctorWork();
    }
}
