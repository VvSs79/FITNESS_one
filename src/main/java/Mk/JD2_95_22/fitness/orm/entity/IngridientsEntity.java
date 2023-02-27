package Mk.JD2_95_22.fitness.orm.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Embeddable
@Table(name = "ingridients", schema = "fitness")
public class IngridientsEntity {
    @ManyToOne
    @JoinColumn( name = "id",
                 nullable = false, updatable = false
    )
    private ProductEntity product;
}
