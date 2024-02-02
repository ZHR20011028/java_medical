package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/3
 * @Description: com.example.entity
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptTriage implements Serializable {
    private Long patientId;
    private Long registeredId;
    private Integer deptRank;
    private String patientName;
    private String patientGender;
    private String patientBirthday;
    private Integer state;
}
