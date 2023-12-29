package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/27
 * @Description: com.example.entity
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorWorkDept {
    private Long workId;
    private String workTime;
    private String deptName;
    private String doctorName;
    private String doctorTelephone;
}
