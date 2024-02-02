package com.example.service.impl;

import com.example.dao.LogDao;
import com.example.entity.Log;
import com.example.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/19
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public boolean insertLog(Log log) {
        return logDao.insert(log) != 0;
    }
}
