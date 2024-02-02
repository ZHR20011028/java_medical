package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.websocket.server.ServerApplicationConfig;
import java.io.Serializable;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/19
 * @Description: com.example.entity
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisLog implements Serializable {
    private Long doctorId;
    private String doctorName;
    private String logContent;
    private String createTime;
}
