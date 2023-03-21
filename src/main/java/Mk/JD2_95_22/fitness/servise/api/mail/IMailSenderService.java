package Mk.JD2_95_22.fitness.servise.api.mail;


import Mk.JD2_95_22.fitness.core.dto.mail.MailDTO;

public interface IMailSenderService {
    void sendActiveMail(String to, String code,String subject);
}
