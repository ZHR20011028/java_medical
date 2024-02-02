package com.example.service;

import com.example.entity.Duty;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/13
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface DutyService {
    List<Duty> getAllDutyOK(Long deptId, String workTime );
    List<Duty> getAllDutyNo(Long deptId, String workTime);

}
