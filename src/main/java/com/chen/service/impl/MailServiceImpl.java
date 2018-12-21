package com.chen.service.impl;

import com.chen.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 邮件服务实现类
 * <p>
 * @Author LeifChen
 * @Date 2018-12-21
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendMail(String to, String subject, String content, String filePath, String imagePath, String imageId) {
        log.info("发送邮件开始，收件人：{}，主题：{}，内容：{}", to, subject, content);

        Context context = new Context();
        context.setVariable("content",content);
        String emailContent = templateEngine.process("mail/emailTemplate", context);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(emailContent, true);

            if (Strings.isNotBlank(filePath)) {
                FileSystemResource file = new FileSystemResource(new File(filePath));
                String fileName = file.getFilename();
                helper.addAttachment(fileName, file);
            }

            if (Strings.isNotBlank(imagePath)) {
                FileSystemResource image = new FileSystemResource(new File(imagePath));
                helper.addInline(imageId, image);
            }

            mailSender.send(message);
            log.info("发送邮件成功。");
        } catch (MessagingException e) {
            log.error("发送邮件失败", e);
        }
    }
}
