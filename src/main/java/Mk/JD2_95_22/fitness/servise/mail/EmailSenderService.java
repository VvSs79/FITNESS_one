package Mk.JD2_95_22.fitness.servise.mail;

import Mk.JD2_95_22.fitness.core.dto.mail.MailDTO;
import Mk.JD2_95_22.fitness.core.util.MailStatus;
import Mk.JD2_95_22.fitness.servise.api.mail.IEmailSenderService;
import Mk.JD2_95_22.fitness.servise.my_exeption.mail.MailNotFoundExeption;
import Mk.JD2_95_22.fitness.servise.my_exeption.mail.SendMailExeption;
import Mk.JD2_95_22.fitness.servise.token.ConfirmationTokenService;
import jakarta.mail.MessagingException;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service("emailSenderService")
public class EmailSenderService implements IEmailSenderService {
    private  JavaMailSender javaMailSender;
    private  SimpleMailMessage template;
    private  MailStatus status;
    private SpringTemplateEngine thymeleafTemplateEngine;
    private ConfirmationTokenService tokenService;
    private  final static Logger logger = LoggerFactory.getLogger(EmailSenderService.class);

    public EmailSenderService(JavaMailSender javaMailSender, SimpleMailMessage template, MailStatus status,SpringTemplateEngine thymeleafTemplateEngine) {
        this.javaMailSender = javaMailSender;
        this.template = template;
        this.status = status;
        this.thymeleafTemplateEngine=thymeleafTemplateEngine;
    }

    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendActiveMail(@NotNull String mail, MailDTO mailDTO) {

        if (!mailDTO.getEmailTo().equals(mail)){
            throw new MailNotFoundExeption("User with this  a mail not found");

        try {
            SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom("vitaliysokolov1.@gmail.com");
            message.setTo(mailDTO.getEmailTo());
            message.setSubject("Confirm your email");
            message.setText(tokenService.getToken());
            javaMailSender.send(message);
            logger.info("Token authorisation was send to mail "+ mail +
                    " status sending is " + MailStatus.SEND);
        } catch (MessagingException e) {
            logger.error("Failed to send email for: " + mailDTO.getEmailTo() + "\n" + e + ", status sending is " + MailStatus.ERROR);
            throw new SendMailExeption("Failed to send email for: " );


        }
    }
    }
}
