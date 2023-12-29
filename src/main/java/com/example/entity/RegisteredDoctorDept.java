package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/29
 * @Description: com.example.entity
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredDoctorDept {
    Long deptId;
    Long doctorId;
    String deptName;
    String deptLocation;
    String deptTelephone;
    Integer patientCount;
}
