package com.application.audit.module.user.dao;

import com.application.audit.module.user.entity.FileBO;
import com.application.audit.module.user.entity.UserBO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 11:39
 */
@Mapper
public interface FileBatisDao {

    void saveFile(FileBO fileBO);
}
