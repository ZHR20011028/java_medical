package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class Drug {
    @TableId
    private Long drugId;
    private String drugsName;
    private String drugsSpecifications;
    @TableField(value = "drugs_manufactor")
    private String drugsManuFactor;
    private String manufactureTime;
    private String expireTime;
    private Double purchasePrice;
    private Double salePrice;
    private String isImport;
    private String saleStatus;
    private String drugsDesc;
    private String checkStatus;
    private String createTime;
    private String updateTime;
    private String checkStartTime;
    private String checkEndTime;
    private String checkContent;
    @TableLogic(value = "1", delval = "0")
    private Integer deleted;
}
