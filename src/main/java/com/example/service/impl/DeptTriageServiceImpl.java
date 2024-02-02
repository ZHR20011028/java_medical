package com.example.service.impl;

import com.example.dao.DeptTriageDao;
import com.example.entity.DeptTriage;
import com.example.service.DeptTriageService;
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
public class DeptTriageServiceImpl implements DeptTriageService {
    @Autowired
    private DeptTriageDao deptTriageDao;

    @Override
    public int selectTriageCountByDeptId(Long deptId) {
        return deptTriageDao.selectDeptTriageCountByDeptId(deptId);
    }

    @Override
    public List<DeptTriage> selectPageTriageByDeptId(Long deptId, int pageNumber, int pageSize) {
        int start = 0;
        if (pageNumber>= 0 && pageSize>=0){
            start += (--pageNumber) * pageSize;
            return deptTriageDao.selectPageDeptTriageByDeptId(deptId, start, pageSize);
        }else {
            return null;
        }
    }
}
