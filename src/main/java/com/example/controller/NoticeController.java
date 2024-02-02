package com.example.controller;

import com.example.entity.Notice;
import com.example.service.NoticeService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/6
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/notices")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping
    public Result getAllNotice() {
        List<Notice> noticeList = noticeService.selectAllNotice();
        if (!noticeList.isEmpty()) {
            return new Result(Code.GET_OK, noticeList);
        } else {
            return new Result(Code.GET_ERR, null, null);
        }
    }
}
