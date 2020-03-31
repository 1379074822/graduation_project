package com.application.audit.module.user.service.impl;

import com.application.audit.common.utils.MD5Utils;
import com.application.audit.module.user.dao.FileBatisDao;
import com.application.audit.module.user.dao.FileDao;
import com.application.audit.module.user.dao.UserBatisDao;
import com.application.audit.module.user.dao.UserDao;
import com.application.audit.module.user.entity.FileBO;
import com.application.audit.module.user.entity.UserBO;
import com.application.audit.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 11:39
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserBatisDao userBatisDao;
    @Autowired
    private FileBatisDao fileBatisDao;
    @Autowired
    private FileDao fileDao;

    @Override
    public UserBO findLoginAccountAndPasswordAndType(UserBO userBO) {
        return userDao.findByLoginAccountAndPasswordAndTypeAndStatus(userBO.getLoginAccount(),MD5Utils.encryptPassword(userBO.getPassword()),userBO.getType(),1);
    }

    @Override
    @Transactional
    public UserBO findById(Long userId) {
        UserBO userBO = userDao.findById(userId).get();
        List<FileBO> files = fileDao.findByUserId(userId);
        userBO.getPaperworks().clear();
        for (FileBO file : files) {
            userBO.getPaperworks().add(file.getFileUrl());
        }

        return userBO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserBO save(UserBO userBO) {
        userBO.setPassword(MD5Utils.encryptPassword(userBO.getPassword()));
        userBO.setStatus(1);
        userBO.setCreateTime(new Date());
         return  userDao.save(userBO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changePassword(UserBO userBO) {
        UserBO alive = userDao.findByIdAndPassword(userBO.getId(),MD5Utils.encryptPassword(userBO.getPassword()));
        if(null==alive){
           return false;
        }
        userDao.changePassword(MD5Utils.encryptPassword(userBO.getPassword()),userBO.getId());
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserBO changeInfo(UserBO userBO) {
        fileDao.deleteByUserId(userBO.getId());
        if(Objects.nonNull(userBO.getPaperworks())){
            for (String paperwork : userBO.getPaperworks()) {
                FileBO fileBO = new FileBO();
                fileBO.setUserId(userBO.getId());
                fileBO.setFileUrl(paperwork);
                fileBatisDao.saveFile(fileBO);
            }
        }

        return userDao.save(userBO);
    }

    @Override
    public List<UserBO> getAll(UserBO userBO) {
        return userDao.findByType(userBO.getType());
    }

    @Override
    public List<UserBO> getUserListSearch(UserBO userBO) {
        return userBatisDao.getUserListSearch(userBO);
    }

    @Override
    public Integer freezeAudit() {
        return userBatisDao.freezeAudit();
    }

    @Override
    public UserBO findByPhoneNum(String phone_num) {
        return userDao.findByPhoneNum(phone_num);
    }

    @Override
    public void init() {
        userBatisDao.init();
    }
}
