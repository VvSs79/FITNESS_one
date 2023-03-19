package Mk.JD2_95_22.fitness.core.dto.user;

import jakarta.validation.constraints.NotBlank;

public class UserVerificationDTO {
    @NotBlank(message = "Must not be blank")
    private String mail;
    @NotBlank(message = "Must not be blank")
    private String code;

    public UserVerificationDTO() {
    }

    public UserVerificationDTO(String mail, String code) {
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
