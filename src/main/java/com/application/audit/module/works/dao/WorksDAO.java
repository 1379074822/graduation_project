package com.application.audit.module.works.dao;

import com.application.audit.module.works.entity.WorksBO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author:
 * @time: 2020/3/8 9:42
 */
public interface WorksDAO extends JpaRepository<WorksBO,Long> {
}
