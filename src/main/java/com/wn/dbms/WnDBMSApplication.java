package com.wn.dbms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.wn.dbms.mapper")
@SpringBootApplication
public class WnDBMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(WnDBMSApplication.class, args);
    }

}
