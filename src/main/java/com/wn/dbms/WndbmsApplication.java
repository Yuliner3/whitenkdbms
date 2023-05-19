package com.wn.dbms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.wn.dbms.mapper")
@ServletComponentScan
@SpringBootApplication
public class WndbmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WndbmsApplication.class, args);
    }

}
