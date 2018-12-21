package com.chen.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 邮件服务测试类
 * <p>
 * @Author LeifChen
 * @Date 2018-12-21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendMail() {
        String to = "highsunchina@aliyun.com";
        String subject = "Spring Boot Mail";
        String content = "This is designed by LeifChen";
        String filePath = "E:\\file.zip";
        String imagePath = "E:\\avatar.jpg";
        String imageId = "avatar";

        mailService.sendMail(to, subject, content, filePath, imagePath, imageId);
    }
}