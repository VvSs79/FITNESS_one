package Mk.JD2_95_22.fitness.orm.repository.product;

import Mk.JD2_95_22.fitness.orm.entity.RecipeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRecipeRepository extends JpaRepository<RecipeEntity, UUID> {

    RecipeEntity findByTitle(String title);
}
