package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/6
 * @Description: com.example.entity
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice implements Serializable {
    private Long deptId;
    private Long patientId;
    private String deptName;
    private String patientName;
    private Integer DeptRank;
    private String DeptLocation;
}
