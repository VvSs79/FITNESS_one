package Mk.JD2_95_22.fitness.servise.api.mail;


public interface IMailSenderService {
    void sendActiveMail(String to, String code,String subject);
}
