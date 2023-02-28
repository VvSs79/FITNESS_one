package Mk.JD2_95_22.fitness.converter;

import Mk.JD2_95_22.fitness.core.dto.mail.MailDTO;
import Mk.JD2_95_22.fitness.orm.entity.MailEntity;
import org.springframework.core.convert.converter.Converter;

public class ConverterMailEntityToMailDTO implements Converter<MailEntity, MailDTO> {
    @Override
    public MailDTO convert(MailEntity source) {
        return new MailDTO(source.getEmailFrom(),
                source.getEmailTo(),
                source.getSubject(),
                source.getText());
    }
}
