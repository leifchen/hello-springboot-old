package com.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 应用程序入口
 *
 * @Author LeifChen
 * @Date 2018-11-13
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.chen.web.servlet")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
