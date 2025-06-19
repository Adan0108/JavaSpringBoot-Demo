package com.adan108.demo;

import com.adan108.util.EmailSenderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootTest
public class SendEmailTest {

    @Autowired
    private EmailSenderUtil emailSenderUtil;

    @Test
    void sendTextEmail(){
        String to = "xxxx@gmail.com";
        String subject = "Test OTP Simple";
        String content = " This is OTP test 1234";

        emailSenderUtil.sendTextEmail(to ,subject ,content);
    }

    @Test
    void sendHTMLEmail() throws IOException {
        String to = "xxxx@gmail.com";
        String subject = "Test OTP HTML";
        String content = " OTP is 123";

        Resource resource = new ClassPathResource("/templates/email/otp-auth.html");
        String htmlContent = new String(resource.getInputStream().readAllBytes());
        emailSenderUtil.sendHtmlEmail(to ,subject ,htmlContent);
    }
}
