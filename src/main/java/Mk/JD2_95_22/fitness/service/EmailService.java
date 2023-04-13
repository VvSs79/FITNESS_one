package Mk.JD2_95_22.fitness.service;

import Mk.JD2_95_22.fitness.core.dto.mail.MailDTO;
import Mk.JD2_95_22.fitness.core.exception.mail.SendMailExeption;
import Mk.JD2_95_22.fitness.service.api.mail.IEmailService;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


public class EmailService implements IEmailService {
    private String NOREPLY_ADDRESS = "vit-s-v79@mail.ru";
    public JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
//
//
//    @Override
//    public void sendSimpleEmail(MailDTO mail) {
//        try {
//            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//            simpleMailMessage.setFrom("vit-s-v79@mail.ru");
//            simpleMailMessage.setTo(mail.getTo());
//            simpleMailMessage.setSubject(mail.getSubject());
//            simpleMailMessage.setText("Для подтверждения перейдите по ссылке :http://localhost/api/v1/users/verification?code=" + mail.getText() + "&mail=" + mail.getTo());
//            emailSender.send(simpleMailMessage);
//        } catch (SendMailExeption e) {
//            throw new RuntimeException(e);
//        }
//    }
public void sendVerificationMessage(MailDTO mailDTO) {
    String mail = mailDTO.getTo();
    String subject = "Активируйте свою учетную запись ";
    String code = mailDTO.getText();
    try {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(NOREPLY_ADDRESS);
        message.setTo(NOREPLY_ADDRESS);
        message.setSubject(subject);
        message.setText("Для завершения процесса регистрации, пожалуйста, пройдите по ссылке:  http://localhost:8080/api/v1/users/verification?code=" + code + "&mail=" + mail);
        emailSender.send(message);

    } catch (SendMailExeption exception) {
        exception.printStackTrace();
    }
}
}
