package com.zhaishu.qishouserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.zhaishu.qishouserver.dao")@EnableTransactionManagement
public class QishouServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QishouServerApplication.class, args);
    }

}
