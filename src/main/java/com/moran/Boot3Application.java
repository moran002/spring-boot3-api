package com.moran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动项
 * @author :moran
 * @date :2023/9/25 15:50
 **/
@SpringBootApplication
@MapperScan("com.moran.mapper")
public class Boot3Application {

    public static void main(String[] args) {
        SpringApplication.run(Boot3Application.class, args);
    }

}
