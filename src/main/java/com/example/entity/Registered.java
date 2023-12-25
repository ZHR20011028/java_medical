package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/25
 * @Description: com.example.entity
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registered {
    @TableId
    private Long registeredId;
    private Long doctorId;
    private Long patientId;
    private Integer state;
    private String noticeContent;
    @TableLogic(value = "1",delval = "0")
    private Integer deleted;
}
