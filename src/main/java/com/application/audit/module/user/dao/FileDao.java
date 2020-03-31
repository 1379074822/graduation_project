package com.application.audit.module.user.dao;

import com.application.audit.module.user.entity.FileBO;
import com.application.audit.module.user.entity.UserBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 11:39
 */

public interface FileDao extends JpaRepository<FileBO,Long> {

    List<FileBO> findByUserId(Long userId);

    void deleteByUserId(Long id);
}
