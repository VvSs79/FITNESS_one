package Mk.JD2_95_22.fitness.service;

import Mk.JD2_95_22.fitness.service.api.mail.IMailService;
import jakarta.mail.*;
import javax.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;

import java.util.Properties;

@Validated
public class MailService implements IMailService {
    private final JavaMailSender mailSender;
    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private int port;

    @Override
    public void sendVerificationMessage(String mailTo, String subject, String text) {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties);
        session.setDebug(true);

        try {
            Transport transport = session.getTransport();
            InternetAddress addressFrom = new InternetAddress(username);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(addressFrom);
            message.setSubject(subject);
            message.setContent(text, "text/plain");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));

            transport.connect();
            transport.send(message);
            transport.close();
            System.out.println("email sent successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
    }}}
//
//        try {
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom(username);
//            message.setTo(mailTo);
//            message.setSubject(subject);
//            message.setSentDate(Date.from(Instant.now()));
//            message.setText(text);
//            mailSender.send(message);
//
//        } catch (SendMailExeption exception) {
//            exception.printStackTrace();
//
//        }



//"Press to link and pass verification: http://localhost:8080/api/v1/users/verification?code=" +
//        "\n" + mailDTO.getText() + " &mail =" + mailDTO.getTo() + "\n If you have not registered an account - ignore this is message"