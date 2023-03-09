package Mk.JD2_95_22.fitness.converter.mail;

import Mk.JD2_95_22.fitness.core.dto.mail.MailDTO;
import Mk.JD2_95_22.fitness.orm.entity.mail.MailEntity;
import org.springframework.core.convert.converter.Converter;
public class MailConverterEntityTolDTO implements Converter<MailEntity, MailDTO> {
    @Override
    public MailDTO convert(MailEntity source) {

        String emailFrom=source.getEmailFrom();
        String emailTo=source.getEmailTo().getMail();
        String subject=source.getSubject();
        String mailContent=source.getText();
new MailEntity();
        return  new MailDTO(emailFrom,emailTo,subject,mailContent);
    }
}
