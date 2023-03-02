package Mk.JD2_95_22.fitness.core.dto.base_essense;

import Mk.JD2_95_22.fitness.converter.number_format.InstantConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Version;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class BaseEssence implements Serializable {
    @NonNull
    private UUID uuid;
    @NonNull
    @JsonSerialize(converter = InstantConverter.Serializer.class)
    @JsonDeserialize(converter =InstantConverter.Deserializer.class )
    private Instant timeCreated;
    @NonNull
    @JsonSerialize(converter = InstantConverter.Serializer.class)
    @JsonDeserialize(converter =InstantConverter.Deserializer.class )
    @Version
    private Instant timeLastUpdate;

    public BaseEssence() {
    }

    public BaseEssence(UUID uuid, Instant timeCreated, Instant timeLastUpdate) {
        this.uuid =UUID.randomUUID();
        this.timeCreated =Instant.now();
        this.timeLastUpdate = Instant.now();
    }


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("dt_created")
    public Instant getTimeCreated() {
        return timeCreated;
    }
    @JsonProperty("dt_created")
    public void setTimeCreated(Instant timeCreated) {
        this.timeCreated = timeCreated;
    }

    @JsonProperty("dt_update")
    public Instant getTimeLastUpdate() {
        return timeLastUpdate;
    }
    @JsonProperty("dt_update")
    public void setTimeLastUpdate(Instant timeLastUpdate) {
        this.timeLastUpdate = timeLastUpdate;
    }
}
