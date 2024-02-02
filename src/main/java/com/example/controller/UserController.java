package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.utils.Code;
import com.example.utils.JWTUtil;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.DocumentEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/20
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Result login(@RequestBody User user) {
        Map<String, Object> loginMap = userService.login(user);
        if (loginMap != null) {
            User userData = (User) loginMap.get("userData");
            Map<String, String> payload = new HashMap<>();
            payload.put("userId", userData.getUserId() + "");
            payload.put("username", userData.getUsername());
            loginMap.put("token", JWTUtil.getToken(payload));
            return new Result(Code.GET_OK, loginMap);
        } else {
            return new Result(Code.GET_ERR, null, "登陆失败！");
        }

    }

    @GetMapping
    public Result getRegisterData(@RequestParam("patientId") Long patientId) {
        Map<String, Object> registerData = userService.selectRegisterData(patientId);
        if (registerData != null) {
            return new Result(Code.GET_OK, registerData);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }

    @PostMapping("/{idCard}")
    public Result addPatientUser(@RequestBody User user, @PathVariable String idCard) {
        boolean flag = userService.insertPatientUser(user, idCard);
        if (flag) {
            return new Result(Code.SAVE_OK);
        } else {
            return new Result(Code.SAVE_ERR, null, "请求失败");
        }
    }
    @PostMapping("/doctor")
    public Result addDoctorUser(@RequestBody User user){
        boolean flag = userService.insertDoctorUser(user);
        if (flag){
            return new Result(Code.SAVE_OK);
        }else {
            return new Result(Code.SAVE_ERR,null,"请求失败");
        }
    }
}
