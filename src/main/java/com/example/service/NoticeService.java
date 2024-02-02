package com.example.service;

import com.example.entity.Notice;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/6
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface NoticeService {
    public List<Notice> selectAllNotice();
}
