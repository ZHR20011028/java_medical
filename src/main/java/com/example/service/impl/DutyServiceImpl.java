package com.example.service.impl;

import com.example.dao.DutyDao;
import com.example.entity.Duty;
import com.example.service.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/13
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class DutyServiceImpl implements DutyService {
    @Autowired
    private DutyDao dutyDao;
    @Override
    public List<Duty> getAllDutyOK(Long deptId,String workTime) {
        return dutyDao.selectAllDutyOK(deptId,workTime);
    }

    @Override
    public List<Duty> getAllDutyNo(Long deptId,String workTime) {
        return dutyDao.selectAllDutyNo(deptId,workTime);
    }
}
