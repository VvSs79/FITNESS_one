package Mk.JD2_95_22.fitness.servise.mail;

import Mk.JD2_95_22.fitness.converter.mail.MailConverterDtoToEntity;
import Mk.JD2_95_22.fitness.converter.mail.MailConverterEntityTolDTO;
import Mk.JD2_95_22.fitness.orm.entity.MailEntity;
import Mk.JD2_95_22.fitness.orm.repository.IMailRepository;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MailService {
    private final IMailRepository repository;
    private final MailConverterDtoToEntity mailConverterDtoToEntity;
    private final MailConverterEntityTolDTO mailConverterEntityTolDTO;
    private final JavaMailSender mailSender;

    public MailService(IMailRepository repository, MailConverterDtoToEntity mailConverterDtoToEntity, MailConverterEntityTolDTO mailConverterEntityTolDTO, JavaMailSender mailSender) {
        this.repository = repository;
        this.mailConverterDtoToEntity = mailConverterDtoToEntity;
        this.mailConverterEntityTolDTO = mailConverterEntityTolDTO;
        this.mailSender = mailSender;
    }

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
