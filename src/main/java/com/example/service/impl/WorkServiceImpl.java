package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.WorkDao;
import com.example.entity.DoctorWorkDept;
import com.example.entity.Work;
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

    @Override
    public boolean addWork(Work work) {
        return workDao.insert(work) != 0;
    }

    @Override
    public boolean modifyWork(Work work) {
        return workDao.updateById(work) != 0;
    }
}
