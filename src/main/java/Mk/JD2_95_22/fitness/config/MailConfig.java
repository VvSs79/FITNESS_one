package Mk.JD2_95_22.fitness.config;

import Mk.JD2_95_22.fitness.service.MailService;
import Mk.JD2_95_22.fitness.service.api.mail.IMailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


import java.util.Properties;


@Configuration
public class MailConfig {
//    @Value("${spring.mail.host}")
//    private String host;
//
//    @Value("${spring.mail.username}")
//    private String username;
//
//    @Value("${spring.mail.password}")
//    private String password;
//
//    @Value("${spring.mail.port}")
//    private int port;
//
//    @Value("${spring.mail.protocol}")
//    private String protocol;

    @Bean
    public IMailService mailService(
            JavaMailSender mailSender){
        return new MailService(mailSender);
    }
//    @Bean
//    public JavaMailSender getJavaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost(host);
//        mailSender.setPort(port);
//
//        mailSender.setUsername(username);
//        mailSender.setPassword(password);
//
//        Properties props = mailSender.getJavaMailProperties();
////        props.setProperty("spring.mail.protocol", protocol);
//        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.ssl.enable", "true");
//        props.put("mail.debug", "false");
//        return mailSender;
//    }
}