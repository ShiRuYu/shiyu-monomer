package com.shiyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.shiyu"})
@MapperScan(basePackages = "com.shiyu.mapper")
public class ShiyuMonomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiyuMonomerApplication.class, args);
    }

}
