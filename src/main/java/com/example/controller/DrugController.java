package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Drug;
import com.example.service.DrugService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/16
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/drugs")
public class DrugController {
    @Autowired
    private DrugService drugService;

    @GetMapping("/page")
    public Result getPageDrug(@RequestParam("current") Long current, @RequestParam("pageSize") Long pageSize) {
        Page<Drug> drugPage = drugService.getPageDrug(current, pageSize);
        if (drugPage != null) {
            Map<String, Object> drugMap = new HashMap<>();
            drugMap.put("total", drugPage.getTotal());
            drugMap.put("drugData", drugPage.getRecords());
            return new Result(Code.GET_OK, drugMap);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }
    @GetMapping("/reviewPage")
    public Result getPageDrugReview(@RequestParam("current") Long current, @RequestParam("pageSize") Long pageSize) {
        Page<Drug> drugPage = drugService.getPageDrugReview(current, pageSize);
        if (drugPage != null) {
            Map<String, Object> drugMap = new HashMap<>();
            drugMap.put("total", drugPage.getTotal());
            drugMap.put("drugData", drugPage.getRecords());
            return new Result(Code.GET_OK, drugMap);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }
    @DeleteMapping
    public Result deleteDrug(@RequestParam("drugId") Long drugId) {
        boolean flag = drugService.deleteDrugByDrugId(drugId);
        if (flag) {
            return new Result(Code.DELETE_OK);
        } else {
            return new Result(Code.DELETE_ERR, null, "请求失败！");
        }
    }

    @PutMapping
    public Result modifyDrug(@RequestBody Drug drug) {
        boolean flag = drugService.modifyDrug(drug);
        if (flag) {
            return new Result(Code.UPDATE_OK);
        } else {
            return new Result(Code.UPDATE_ERR, null, "请求失败！");
        }
    }

    @GetMapping("/like")
    public Result getLikeDrug(@RequestParam("drugsName") String drugsName) {
        List<Drug> drugList = drugService.getLikeDrugByDrugsName(drugsName);
        if (!drugList.isEmpty()) {
            return new Result(Code.GET_OK, drugList);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }

    @GetMapping("/name")
    public Result getDrug(@RequestParam("drugsName") String drugsName) {
        List<Drug> drugList = drugService.getDrugByDrugsName(drugsName);
        if (!drugList.isEmpty()) {
            return new Result(Code.GET_OK, drugList);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }

    @PostMapping
    public Result addDrug(@RequestBody Drug drug){
        boolean flag = drugService.addDrug(drug);
        if (flag){
            return new Result(Code.SAVE_OK);
        }else {
            return new Result(Code.SAVE_ERR,null,"请求失败！");
        }
    }
}
