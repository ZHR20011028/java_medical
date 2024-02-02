package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Patient;
import com.example.service.PatientService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/7
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    /**
     * 分页查询接口
     *
     * @param current 当前页
     * @param size    每页数据条数
     * @return 返回总条数total，和每页patient数据
     */
    @GetMapping("/page")
    public Result getPagePatient(@RequestParam("current") Long current, @RequestParam("size") Long size) {
        Page<Patient> patientPage = patientService.selectPagePatient(size, current);
        if (patientPage != null) {
            Map<String, Object> patientMap = new HashMap<>();
            patientMap.put("total", patientPage.getTotal());
            patientMap.put("patientData", patientPage.getRecords());
            return new Result(Code.GET_OK, patientMap);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }

    /**
     * 按patientName查询patient
     *
     * @param patientId 患者Id
     * @return List<Patient>
     */
    @GetMapping("/patientId")
    public Result getPatientByPatientId(@RequestParam("patientId") Long patientId) {
        Patient patient = patientService.selectPatientByPatientId(patientId);
        if (patient !=null) {
            return new Result(Code.GET_OK, patient);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }
    @GetMapping("/like")
    public Result getPatientByLike(@RequestParam("patient") String patient){
        List<Patient> patientList = patientService.selectPatientByLike(patient);
        if (!patientList.isEmpty()){
            return new Result(Code.GET_OK,patientList);
        }else {
            return new Result(Code.GET_ERR,null,"请求失败！");
        }
    }
    @PostMapping("/register")
    public Result addPatient(@RequestBody Patient patient){
        boolean flag = patientService.insertPatient(patient);
        if (flag){
            return new Result(Code.SAVE_OK);
        }else {
            return new Result(Code.SAVE_ERR,null,"请求失败");
        }
    }
    @PutMapping
    public Result modifyPatient(@RequestBody Patient patient ){
        boolean flag = patientService.updatePatient(patient);
        if (flag){
            return new Result(Code.UPDATE_OK);
        }else {
            return new Result(Code.UPDATE_ERR,null,"请求错误！");
        }
    }
}
