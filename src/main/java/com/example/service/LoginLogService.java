package com.example.service;

import com.example.entity.LoginLog;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.StringTokenizer;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/19
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface LoginLogService {
    public List<LoginLog> getAllLoginLog(Long current, Long pageSize);
    int getLoginLogTotal();
    List<LoginLog> getLikeLoginLog(String username);
    List<LoginLog> getLoginLogByUsername(String username);
}
