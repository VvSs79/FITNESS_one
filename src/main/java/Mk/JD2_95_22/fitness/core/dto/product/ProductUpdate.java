package Mk.JD2_95_22.fitness.core.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.UUID;

public class ProductUpdate {
    @NotEmpty
    private ProductCreate productCreate;
    @NonNull
    private Instant dtUpdate;
    @NotBlank
    private UUID uuid;

    public ProductUpdate(ProductCreate productCreate, Instant dtUpdate, UUID uuid) {
        this.productCreate = productCreate;
        this.dtUpdate = dtUpdate;
        this.uuid = uuid;
    }

    public ProductCreate getAddProductDTO() {
        return productCreate;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public UUID getUuid() {
        return uuid;
    }
}
