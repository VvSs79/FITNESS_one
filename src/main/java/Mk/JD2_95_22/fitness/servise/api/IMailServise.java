package Mk.JD2_95_22.fitness.servise.api;

import Mk.JD2_95_22.fitness.orm.repository.IMailRepository;
import org.springframework.mail.SimpleMailMessage;

public interface IMailServise  {
    void sendMail(SimpleMailMessage mailMessage);
}
