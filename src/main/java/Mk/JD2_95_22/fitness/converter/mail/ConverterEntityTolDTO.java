package Mk.JD2_95_22.fitness.converter.mail;

import Mk.JD2_95_22.fitness.core.dto.mail.MailDTO;
import Mk.JD2_95_22.fitness.orm.entity.MailEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

public class ConverterEntityTolDTO implements Converter<MailEntity, MailDTO> {
    @Override
    public MailDTO convert(MailEntity source) {
        String emailFrom=source.getEmailFrom();
        String emailTo=source.getEmailTo().getMail();
        String subject=source.getSubject();
        UUID message=source.getText();

        return  new MailDTO(emailFrom,emailFrom,subject,message);
    }
}
