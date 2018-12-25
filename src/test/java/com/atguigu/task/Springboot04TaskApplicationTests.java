package com.atguigu.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚8：30开会");

        message.setTo("15972076676@163.com");
        message.setFrom("471019576@qq.com");
        mailSender.send(message);
    }

    @Test
    public void test02() throws Exception{
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("通知-今晚开会");
        helper.setText("<b style='color:red'>今天7：30开会</b>",true);

        helper.setTo("15972076676@163.com");
        helper.setFrom("471019576@qq.com");

        //上传文件
        helper.addAttachment("1.jpg",new File("C:\\Users\\hwt.DESKTOP-01GHTJE\\Pictures\\Camera Roll\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\hwt.DESKTOP-01GHTJE\\Pictures\\Camera Roll\\2.jpg"));
        mailSender.send(mimeMessage);
    }

}

