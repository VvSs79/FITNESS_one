package Mk.JD2_95_22.fitness.service.api.mail;


import Mk.JD2_95_22.fitness.core.dto.mail.MailDTO;

public interface IMailService {
    void sendVerificationMessage(String mailTo, String subject, String text);

}
