package Mk.JD2_95_22.fitness.core.exception.mail;

import org.springframework.mail.MailSendException;

public class MailNotFoundExeption extends RuntimeException{
    public MailNotFoundExeption(){};
    public MailNotFoundExeption(String message) {
        super(message);
    }

    public MailNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public MailNotFoundExeption(Throwable cause) {
        super(cause);
    }
}
