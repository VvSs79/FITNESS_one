package Mk.JD2_95_22.fitness.servise.api.mail;

import Mk.JD2_95_22.fitness.core.dto.mail.MailDTO;
import jakarta.validation.constraints.NotNull;

public interface IEmailSenderService {
    void sendActiveMail(@NotNull String mail, MailDTO mailDTO);
}
