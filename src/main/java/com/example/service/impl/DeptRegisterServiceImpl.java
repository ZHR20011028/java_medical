package com.example.service.impl;

import com.example.dao.DeptRegisterDao;
import com.example.dao.DeptTriageDao;
import com.example.entity.DeptRegister;
import com.example.service.DeptRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/3
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class DeptRegisterServiceImpl implements DeptRegisterService {
    @Autowired
    private DeptRegisterDao deptRegisterDao;
    @Override
    public List<DeptRegister> getRegisteredCount() {
        return deptRegisterDao.selectRegisteredCount();
    }

    /**
     * 查询某个科室的挂号人数基本信息
     *
     * @param deptId 科室id
     * @return 成功返回信息，失败null
     */
    @Override
    public DeptRegister selectDeptRegisteredCountByDeptId(Long deptId) {
        return deptRegisterDao.selectByDeptId(deptId);
    }
}
