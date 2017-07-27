package ru.mrchebik.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.MessagingException;
import java.util.Properties;

/**
 * Created by mrchebik on 12.03.17.
 */
@Configuration
@ComponentScan("ru.mrchebik")
public class Config {
    @Bean
    public JavaMailSenderImpl mailSender() throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.yandex.ru"); // smtp.gmail.com
        mailSender.setPort(465); // 25
        mailSender.setProtocol("smtp");
        mailSender.setUsername("username");
        mailSender.setPassword("password");
        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }
}
