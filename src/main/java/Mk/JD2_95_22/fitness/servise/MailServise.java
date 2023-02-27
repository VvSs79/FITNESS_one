package Mk.JD2_95_22.fitness.servise;

import Mk.JD2_95_22.fitness.orm.entity.MailEntity;
import Mk.JD2_95_22.fitness.orm.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MailServise {
    @Autowired
    IMailRepository repository;
    @Autowired
    private JavaMailSender mailSender;
    public MailEntity sendMail(MailEntity entity){
        entity.setSendDateEmail(LocalDateTime.now());

        try{

            SimpleMailMessage message=new SimpleMailMessage();
        }
        catch (MailException e){

        }
        return entity;
    }

}
