package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.LoginLogDao;
import com.example.entity.Log;
import com.example.entity.LoginLog;
import com.example.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/19
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    private LoginLogDao loginLogDao;

    @Override
    public List<LoginLog> getAllLoginLog(Long current, Long pageSize) {
        return loginLogDao.selectAllLoginLog(current - 1, pageSize);
    }

    @Override
    public int getLoginLogTotal() {
        LambdaQueryWrapper<Log> lqw = new LambdaQueryWrapper<>();
        lqw.isNotNull(Log::getUserId);
        return loginLogDao.selectCount(lqw);
    }

    @Override
    public List<LoginLog> getLikeLoginLog(String username) {
        return loginLogDao.selectLikeLoginLog("%" + username + "%");
    }

    @Override
    public List<LoginLog> getLoginLogByUsername(String username) {
        return loginLogDao.selectLoginLogByUsername(username);
    }

}
