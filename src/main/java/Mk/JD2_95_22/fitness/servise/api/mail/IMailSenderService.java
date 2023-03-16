package Mk.JD2_95_22.fitness.servise.api.mail;

import jakarta.validation.constraints.NotNull;

public interface IMailSenderService {
    void sendActiveMail(String to, String code,String subject);
}
