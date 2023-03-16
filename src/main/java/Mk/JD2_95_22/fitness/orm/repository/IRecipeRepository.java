package Mk.JD2_95_22.fitness.orm.repository;

import Mk.JD2_95_22.fitness.orm.entity.product.RecipeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public interface IRecipeRepository extends JpaRepository<RecipeEntity, UUID>, PagingAndSortingRepository<RecipeEntity, UUID> {
    boolean existsByTitle(String title);
    Optional <RecipeEntity> getAllByTitleIgnoreCase(String title);
    RecipeEntity getAllByTitle(String title);
    RecipeEntity getAllByUuid(UUID uuid);
    RecipeEntity getAllByTitleAndDtUpdate(String title, Instant dtUpdate);
    RecipeEntity deleteAllByTitle(String title);

}
