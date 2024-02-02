package com.example.service.impl;

import com.example.dao.NoticeDao;
import com.example.entity.Notice;
import com.example.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/6
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class NoticeServiceImpl  implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;
    @Override
    public List<Notice> selectAllNotice() {
        return noticeDao.selectAllNotice();
    }
}
