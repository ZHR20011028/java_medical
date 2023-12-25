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
public class Log {
    @TableId
    private Long logId;
    private Long userId;
    private Long doctorId;
    private Long patientId;
    private String createTime;
    private String logContent;
    @TableLogic(value = "1", delval = "0")
    private Integer deleted;
}
