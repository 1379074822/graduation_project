package com.application.audit;

import com.application.audit.common.service.SimpleJpaRepositoryImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaRepositories(value = "com.application.audit", repositoryBaseClass = SimpleJpaRepositoryImpl.class)
@MapperScan("com.application.audit.module.*.dao")//使用MapperScan批量扫描所有的Mapper接口；
public class AuditApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuditApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8099");
            }
        };
    }
}
