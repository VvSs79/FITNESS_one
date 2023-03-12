package Mk.JD2_95_22.fitness.servise.my_exeption.mail;

import org.springframework.mail.MailSendException;

public class SendMailExeption  extends MailSendException {
    public SendMailExeption(String message) {
        super(message);
    }
}
