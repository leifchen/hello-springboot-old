package com.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 应用程序入口
 *
 * @Author LeifChen
 * @Date 2018-11-13
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.chen.web.servlet")
@MapperScan(basePackages = "com.chen.mapper")
@EnableScheduling
@EnableAsync
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
