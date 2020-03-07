package com.application.audit.module.user.service.impl;

import com.application.audit.module.user.dao.UserDao;
import com.application.audit.module.user.entity.UserBO;
import com.application.audit.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.Objects;
import java.util.Optional;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/7 11:39
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public boolean findLoginAccountAndPasswordAndType(UserBO userBO) {
        UserBO byLoginAccountAndPassword = userDao.findByLoginAccountAndPasswordAndTypeAndStatus(userBO.getLoginAccount(),userBO.getPassword(),1,1);
        return Objects.nonNull(byLoginAccountAndPassword);
    }

    @Override
    public UserBO findById(Long userId) {
        return userDao.findById(userId).get();
    }
}
