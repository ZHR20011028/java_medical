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
public class Patient {
    @TableId
    private Long patientId;
    private Long deptId;
    private String patientName;
    private String gender;
    private String birthday;
    private String idCard;
    private String telephone;
    private String address;
    @TableLogic(value = "1", delval = "0")
    private Integer deleted;
}
