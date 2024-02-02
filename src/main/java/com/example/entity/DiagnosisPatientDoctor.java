package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/7
 * @Description: com.example.entity
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisPatientDoctor implements Serializable {
    private String patientName;
    private String patientGender;
    private String patientBirthday;
    private String deptName;
    private String doctorName;
    private String symptomDesc;
    private String symptomIdea;
    private String createTime;

}
