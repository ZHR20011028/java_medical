package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/10
 * @Description: com.example.entity
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDept implements Serializable {
    @TableId
    private Long doctorId;
    private Long deptId;
    private String deptName;
    private String doctorName;
    private String doctorGender;
    private String doctorBirthday;
    private String doctorTelephone;
    private String dateOfEntry;
    private String degree;
    private String jobTitle;
    private String email;
}
