package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.DrugDao;
import com.example.entity.Drug;
import com.example.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/16
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugDao drugDao;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat();

    @Override
    public Page<Drug> getPageDrug(Long current, Long pageSize) {
        Page<Drug> drugPage = new Page<>(current, pageSize);
        return drugDao.selectPage(drugPage, null);
    }

    @Override
    public Page<Drug> getPageDrugReview(Long current, Long pageSize) {
        Page<Drug> drugPage = new Page<>(current, pageSize);
        LambdaQueryWrapper<Drug> lqw = new LambdaQueryWrapper<>();
        lqw.isNotNull(Drug::getCheckStatus);
        return drugDao.selectPage(drugPage, lqw);
    }

    @Override
    public boolean deleteDrugByDrugId(Long drugId) {
        return drugDao.deleteById(drugId) != 0;
    }

    @Override
    public boolean modifyDrug(Drug drug) {
        LambdaQueryWrapper<Drug> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Drug::getDrugId, drug.getDrugId());
        drug.setDrugId(null);
        return drugDao.update(drug, lqw) != 0;
    }

    @Override
    public List<Drug> getLikeDrugByDrugsName(String drugsName) {
        LambdaQueryWrapper<Drug> lqw = new LambdaQueryWrapper<>();
        lqw.like(Drug::getDrugsName, drugsName);
        return drugDao.selectList(lqw);
    }

    @Override
    public List<Drug> getDrugByDrugsName(String drugsName) {
        LambdaQueryWrapper<Drug> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Drug::getDrugsName, drugsName);
        return drugDao.selectList(lqw);
    }

    @Override
    public boolean addDrug(Drug drug) {
        drug.setCreateTime(this.dateFormat.format(this.date));
        return drugDao.insert(drug) != 0;
    }
}
