package com.application.audit.module.user.service.impl;

import com.application.audit.module.user.dao.UserDao;
import com.application.audit.module.user.entity.UserBO;
import com.application.audit.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 11:39
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean findLoginAccountAndPasswordAndType(UserBO userBO) {
        UserBO byLoginAccountAndPassword = userDao.findByLoginAccountAndPasswordAndTypeAndStatus(userBO.getLoginAccount(),userBO.getPassword(),userBO.getType(),1);
        return Objects.nonNull(byLoginAccountAndPassword);
    }

    @Override
    public UserBO findById(Long userId) {
        return userDao.findById(userId).get();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserBO save(UserBO userBO) {
         return  userDao.save(userBO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changePassword(UserBO userBO) {
        userDao.changePassword(userBO.getPassword(),userBO.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changeInfo(UserBO userBO) {
        userDao.save(userBO);
    }

    @Override
    public List<UserBO> getAll(UserBO userBO) {
        return userDao.findByType(userBO.getType());
    }
}
