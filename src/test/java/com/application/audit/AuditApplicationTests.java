package com.application.audit;

import com.application.audit.module.user.dao.UserDao;
import com.application.audit.module.user.entity.UserBO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class AuditApplicationTests {

    @Resource
    private UserDao userDao;
    @Test
    void test() {
        UserBO userBO = new UserBO();
        userBO.setUserName("admin");
        userBO.setPassword("admin");
        UserBO byUserNameAndPassword = userDao.findByLoginAccountAndPassword(userBO.getLoginAccount(),userBO.getPassword());
        System.out.println(byUserNameAndPassword);
    }

}
