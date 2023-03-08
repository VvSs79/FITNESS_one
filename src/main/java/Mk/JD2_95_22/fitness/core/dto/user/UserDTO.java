package Mk.JD2_95_22.fitness.core.dto.user;

import Mk.JD2_95_22.fitness.converter.number_format.InstantConverter;
import Mk.JD2_95_22.fitness.core.util.UserRole;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;
import java.time.Instant;
import java.util.UUID;


public class UserDTO  {
    @NonNull private UUID uuid;
    @JsonProperty("dt_create")
    @JsonSerialize(converter = InstantConverter.Serializer.class)
    @JsonDeserialize(converter = InstantConverter.Deserializer.class)
    private Instant dtCreate;
    @JsonProperty("dt_update")
    @JsonSerialize(converter = InstantConverter.Serializer.class)
    @JsonDeserialize(converter = InstantConverter.Deserializer.class)
    private Instant dtUpdate;
    @NotBlank(message = "email cannot be empty")
    private String mail;
    @NotBlank(message = "fio cannot be empty")
    private String fio;
    @Enumerated(EnumType.STRING)
    @NonNull
    private UserRole role;
    @Enumerated(EnumType.STRING)
    @NonNull
    private UserStatus status;

    public UserDTO() {
    }

    public UserDTO(UUID uuid, Instant dtCreate, Instant dtUpdate, String mail, String fio, UserRole role, UserStatus status) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
    }


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Instant getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Instant dtCreate) {
        this.dtCreate = dtCreate;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(Instant dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }


    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}

