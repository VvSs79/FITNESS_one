package Mk.JD2_95_22.fitness.converter;

import Mk.JD2_95_22.fitness.core.dto.mail.MailDTO;
import Mk.JD2_95_22.fitness.orm.entity.MailEntity;
import org.springframework.core.convert.converter.Converter;

public class ConverterMailtoMailEntity implements Converter<MailDTO, MailEntity> {
    @Override
    public MailEntity convert(MailDTO source) {
        return new MailEntity();
    }
}
