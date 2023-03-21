package Mk.JD2_95_22.fitness.core.dto.user;

import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.UUID;

public class UserUpdate {
    @NotEmpty
    private UserCreate userDTO;
    @NotEmpty
    private Instant dtUpdate;
    @NotEmpty
    private UUID uuid;

    public UserUpdate(UserCreate userDTO, Instant dtUpdate, UUID uuid) {
        this.userDTO = userDTO;
        this.dtUpdate = dtUpdate;
        this.uuid = uuid;
    }

    public UserCreate getUserDTO() {
        return userDTO;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUserDTO(UserCreate userDTO) {
        this.userDTO = userDTO;
    }

    public void setDtUpdate(Instant dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
