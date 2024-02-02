package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dao.RegisteredDao;
import com.example.entity.Registered;
import com.example.entity.DeptRegister;
import com.example.service.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/29
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class RegisteredServiceImpl implements RegisteredService {
    @Autowired
    private RegisteredDao registeredDao;

    /**
     * 挂号
     *
     * @param registered 挂号实体类
     * @return 返回0，挂号失败，返回1 ，挂号成功
     */
    @Override
    public int insertRegistered(Registered registered) {
        //先查询是否挂号，没有，则插入
        LambdaQueryWrapper<Registered> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Registered::getPatientId, registered.getPatientId());
        lqw.ne(Registered::getState,3);
        if (registeredDao.selectOne(lqw) == null) {
            return registeredDao.insert(registered);
        } else {
            return 0;
        }
    }

    /**
     * 取消挂号
     *
     * @param registered 挂号实体类
     * @return 返回0，取消失败，返回1 ，取消成功
     */
    @Override
    public int deleteRegistered(Registered registered) {
        // 先查询是否挂号然后在删除
        LambdaQueryWrapper<Registered> lqw1 = new LambdaQueryWrapper<>();
        lqw1.eq(Registered::getPatientId, registered.getPatientId());
        lqw1.ne(Registered::getState,3);
        if (registeredDao.selectOne(lqw1) != null) {
            LambdaQueryWrapper<Registered> lqw2 = new LambdaQueryWrapper<>();
            lqw2.eq(Registered::getDeptId, registered.getDeptId());
            lqw2.eq(Registered::getPatientId, registered.getPatientId());
            return registeredDao.delete(lqw2);
        } else {
            return 0;
        }
    }

    /**
     * 更新挂号状态
     * @param registered 挂号实体
     * @return 返回修改行数
     */
    @Override
    public int updateRegisterState(Registered registered) {
        return registeredDao.updateById(registered);
    }

    /**
     * 通过patientId查询，是否挂号
     *
     * @param patientId 患者id
     * @return 成功返回registered
     */
    @Override
    public Registered selectRegisteredByPatientId(Long patientId) {
        LambdaQueryWrapper<Registered> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Registered::getPatientId, patientId);
        lqw.ne(Registered::getState,3);
        return registeredDao.selectOne(lqw);
    }

}
