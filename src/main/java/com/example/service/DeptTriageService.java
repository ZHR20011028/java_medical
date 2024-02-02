package com.example.service;

import com.example.entity.DeptTriage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/3
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface DeptTriageService {
    int selectTriageCountByDeptId(Long deptId);
    List<DeptTriage> selectPageTriageByDeptId(Long deptId,int pageNumber,int pageSize);
}
