package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/22
 * @Description: com.example.entity
 * @Version: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisResult implements Serializable {
    @TableId
    private Long diagnosisId;
    private Long DoctorId;
    private Long PatientId;
    private String symptomDesc;
    private String symptomIdea;
    private String createTime;
    private String updateTime;
    @TableLogic(value = "1", delval = "0")
    private Integer deleted;
}
