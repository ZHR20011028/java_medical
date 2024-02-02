package com.example.controller;

import com.example.entity.Doctor;
import com.example.service.DoctorService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/10
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/like")
    public Result getLikeDoctor(@RequestParam("doctorName") String doctorName) {
        List<Doctor> doctorList = doctorService.selectLikeDoctor(doctorName);
        if (!doctorList.isEmpty()) {
            return new Result(Code.GET_OK, doctorList);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }

    @DeleteMapping
    public Result removeDoctorByDoctorId(@RequestParam("doctorId") Long doctorId) {
        int i = doctorService.deleteDoctorByDoctorId(doctorId);
        if (i != 0) {
            return new Result(Code.DELETE_OK);
        } else {
            return new Result(Code.DELETE_ERR, null, "请求失败！");
        }
    }

    @PutMapping
    public Result modifyDoctor(@RequestBody Doctor doctor) {
        int i = doctorService.updateDoctor(doctor);
        if (i != 0) {
            return new Result(Code.UPDATE_OK);
        } else {
            return new Result(Code.UPDATE_ERR, null, "请求失败！");
        }
    }
    @PostMapping
    public Result addDoctor(@RequestBody Doctor doctor){
        boolean flag = doctorService.addDoctor(doctor);
        if (flag){
            return new Result(Code.SAVE_OK);
        }else {
            return new Result(Code.SAVE_ERR,null,"请求失败！");
        }
    }
}
