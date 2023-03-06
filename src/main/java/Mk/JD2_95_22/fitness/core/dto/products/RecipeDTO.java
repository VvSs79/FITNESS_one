package Mk.JD2_95_22.fitness.core.dto.products;

import Mk.JD2_95_22.fitness.core.dto.base_essense.BaseEssence;
import java.util.List;
import java.util.Objects;

public class RecipeDTO extends BaseEssence {
    private String title;
    private List<Ingridients> composition;

    public RecipeDTO(String title, List<Ingridients> composition) {
        this.title = title;
        this.composition = composition;
    }

    public String getTitle() {
        return title;
    }

    public List<Ingridients> getComposition() {
        return composition;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComposition(List<Ingridients> composition) {
        this.composition = composition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeDTO recipe = (RecipeDTO) o;
        return Objects.equals(title, recipe.title) && Objects.equals(composition, recipe.composition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, composition);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", composition=" + composition +
                '}';
    }
}