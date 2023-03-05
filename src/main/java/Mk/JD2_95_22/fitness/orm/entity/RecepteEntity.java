package Mk.JD2_95_22.fitness.orm.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "recepte")
public class RecepteEntity extends BaseEssenceEntety{
    @Column(name="title")
    private String title;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinTable(schema = "fitness", name="composition",
            joinColumns = @JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="name"))
    private List<IngridientsEntity> composition;

    public RecepteEntity() {
    }

    public RecepteEntity(String title, List<IngridientsEntity> composition) {
        this.title = title;
        this.composition = composition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<IngridientsEntity> getComposition() {
        return composition;
    }

    public void setComposition(List<IngridientsEntity> composition) {
        this.composition = composition;
    }
}
