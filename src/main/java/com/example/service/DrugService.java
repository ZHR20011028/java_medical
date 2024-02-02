package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Drug;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/16
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface DrugService {
    Page<Drug> getPageDrug(Long current,Long pageSize);
    Page<Drug> getPageDrugReview(Long current,Long pageSize);
    boolean deleteDrugByDrugId(Long drugId);
    boolean modifyDrug(Drug drug);
    List<Drug> getLikeDrugByDrugsName(String drugsName);
    List<Drug> getDrugByDrugsName(String drugsName);
    boolean addDrug(Drug drug);
}
