package Mk.JD2_95_22.fitness.core.dto.BasicEssence;

import Mk.JD2_95_22.fitness.converter.InstantConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.UUID;

public class Essence {
    @NonNull
    private UUID uuid;
    @NonNull
    @JsonSerialize(converter = InstantConverter.Serializer.class)
    @JsonDeserialize(converter =InstantConverter.Deserializer.class )
    private Instant timeCreated;
    @NonNull
    @JsonSerialize(converter = InstantConverter.Serializer.class)
    @JsonDeserialize(converter =InstantConverter.Deserializer.class )
    private Instant timeLastUpdate;

    public Essence() {
    }

    public Essence(UUID uuid, Instant timeCreated,  Instant timeLastUpdate) {
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
