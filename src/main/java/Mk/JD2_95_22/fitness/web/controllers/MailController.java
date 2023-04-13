package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.mail.MailDTO;
import Mk.JD2_95_22.fitness.service.api.mail.IMailService;
import Mk.JD2_95_22.fitness.service.validate.api.ValidMail;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/mail")
public class MailController {
    private final IMailService service;
    public MailController(IMailService service) {
        this.service = service;
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> send(@RequestParam @ValidMail String mailTo,
                                  @RequestParam String subject,
                                  @RequestParam String text) {
        service.sendVerificationMessage(mailTo, subject, text);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
