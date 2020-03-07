package com.application.audit;

import com.application.audit.common.service.SimpleJpaRepositoryImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = "com.application.audit", repositoryBaseClass = SimpleJpaRepositoryImpl.class)
//@MapperScan(value = "com.application.audit.mapping")
public class AuditApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuditApplication.class, args);
    }

}
