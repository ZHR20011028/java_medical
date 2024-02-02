package com.example.dao;

import com.example.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/6
 * @Description: com.example.dao
 * @Version: 1.0
 */
@Mapper
public interface NoticeDao {
    List<Notice> selectAllNotice();
}
