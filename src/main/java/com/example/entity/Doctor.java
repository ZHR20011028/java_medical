package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/22
 * @Description: com.example.entity
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @TableId
    private Long doctorId;
    private  Long deptId;
    private String doctorName;
    private String gender;
    private String birthday;
    private String doctorTelephone;
    private String email;
    @TableLogic(value = "1",delval = "0")
    private Integer deleted;

}
