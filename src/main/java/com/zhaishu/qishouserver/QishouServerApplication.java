package com.zhaishu.qishouserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhaishu.qishouserver.dao")
public class QishouServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QishouServerApplication.class, args);
    }

}
