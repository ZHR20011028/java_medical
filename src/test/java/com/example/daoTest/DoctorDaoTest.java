package com.example.daoTest;

import com.example.dao.DoctorDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2023/12/22
 * @Description: com.example.daoTest
 * @Version: 1.0
 */
@SpringBootTest
public class DoctorDaoTest {
    @Autowired
    private DoctorDao doctorDao;
    @Test
    public void selectTest(){
        System.out.println(doctorDao.selectById(1L));
    }
}
