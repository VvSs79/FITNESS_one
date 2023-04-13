package Mk.JD2_95_22.fitness.service.api.mail;

import Mk.JD2_95_22.fitness.core.dto.mail.MailDTO;
import org.springframework.stereotype.Repository;

public interface IEmailService {
//    void sendSimpleEmail(MailDTO mail);
void sendVerificationMessage(MailDTO mailDTO);
}
