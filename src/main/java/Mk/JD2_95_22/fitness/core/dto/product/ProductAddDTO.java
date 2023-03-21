package Mk.JD2_95_22.fitness.core.dto.product;

import java.time.Instant;

public class ProductAddDTO {
    ProductCreate productCreate;
    private Instant dtUpdate;
    private Instant dtCreate;

    public ProductAddDTO(ProductCreate productCreate) {
        this.productCreate = productCreate;
        this.dtCreate = Instant.now();
        this.dtUpdate = this.dtCreate;
    }

    public ProductCreate getAddProductDTO() {
        return productCreate;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public Instant getDtCreate() {
        return dtCreate;
    }
}
