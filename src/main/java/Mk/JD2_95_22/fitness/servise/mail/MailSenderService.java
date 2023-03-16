package Mk.JD2_95_22.fitness.servise.mail;

import Mk.JD2_95_22.fitness.core.exeption.SingleErrorResponse;
import Mk.JD2_95_22.fitness.core.util.MailStatus;
import Mk.JD2_95_22.fitness.servise.user.UserService;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
public class MailSenderService {
    private JavaMailSender mailSender;
    private SimpleMailMessage template;
    private   MailStatus status;
    private SpringTemplateEngine thymeleafTemplateEngine;



    public MailSenderService(JavaMailSender mailSender, SimpleMailMessage template, MailStatus status, SpringTemplateEngine thymeleafTemplateEngine) {
        this.mailSender = mailSender;
        this.template = template;
        this.status = status;
        this.thymeleafTemplateEngine = thymeleafTemplateEngine;
    }
    public void sendMessageActiveMail(String to, String code,String subject)  {
        boolean sendMessage=true;
            try{
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("vitaliysokolov1@gmail.com");
                message.setTo(to);
                message.setSubject("Confirm your email");
                message.setText(code);
                mailSender.send(message);

            if(sendMessage){
               status= MailStatus.SEND;
            }
            if(!sendMessage){
               throw  new SingleErrorResponse("Confirm mail, click to address :http://localhost:8080/api/v1/users/verification?code=  " + code + "&mail=" + to + ", status sending is " + MailStatus.ERROR);
            }
            }
            catch (MailException e){e.printStackTrace();
            }
        }
    }
