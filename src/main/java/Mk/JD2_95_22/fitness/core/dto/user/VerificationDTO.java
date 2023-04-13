package Mk.JD2_95_22.fitness.core.dto.user;

import Mk.JD2_95_22.fitness.service.validate.api.ValidMail;
import Mk.JD2_95_22.fitness.service.validate.api.ValidString;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class VerificationDTO {
    @ValidMail
    @ValidString
    private String mail;
    @NotNull
    private String code;

    public VerificationDTO() {
    }

    public VerificationDTO(String mail, String code) {
        this.mail = mail;
        this.code = code;
    }

    public String getMail() {
        return mail;
    }

    public String getCode() {
        return code;
    }
}
