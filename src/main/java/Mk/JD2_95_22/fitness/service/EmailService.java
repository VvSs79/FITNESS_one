package Mk.JD2_95_22.fitness.service;

import Mk.JD2_95_22.fitness.core.exception.my_exeption.mail.SendMailExeption;
import Mk.JD2_95_22.fitness.service.api.mail.IEmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService implements IEmailService {
    public JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    @Override
    public void sendSimpleEmail(String toAddress, String subject, String code) {
        String mail=toAddress;
        if(mail==null){
            throw new SendMailExeption("This email not found");
        }
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("vitaliysokolov1@gmail.com");
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText("Click to address " +
                ":http://localhost:8080/api/v1/users/verification?code=  " + code +
                "&mail=" + toAddress);
        emailSender.send(simpleMailMessage);
    }
}
