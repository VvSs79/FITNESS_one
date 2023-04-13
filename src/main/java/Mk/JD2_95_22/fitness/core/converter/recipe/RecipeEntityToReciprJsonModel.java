package Mk.JD2_95_22.fitness.core.converter.recipe;

import Mk.JD2_95_22.fitness.core.converter.ingredient.IngredientEntityToIngredientJsonModel;
import Mk.JD2_95_22.fitness.core.dto.j_model.IngredientJsonModel;
import Mk.JD2_95_22.fitness.core.dto.j_model.RecipeJsonModel;
import Mk.JD2_95_22.fitness.orm.entity.IngredientEntity;
import Mk.JD2_95_22.fitness.orm.entity.RecipeEntity;
import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RecipeEntityToReciprJsonModel implements Converter<RecipeEntity, RecipeJsonModel> {
    private  IngredientEntityToIngredientJsonModel conversionService;

    public RecipeEntityToReciprJsonModel(IngredientEntityToIngredientJsonModel conversionService) {
        this.conversionService = conversionService;
    }

    public RecipeJsonModel convert (RecipeEntity souce){
        List<IngredientJsonModel> collect = new ArrayList<>();
        for (IngredientEntity ingredient : souce.getComposition()) {
            IngredientJsonModel convert = conversionService.convert(ingredient);
            collect.add(convert);
        }
        Integer weight=collect.stream().mapToInt(IngredientJsonModel::getWeight).sum();
        Integer calories=collect.stream().mapToInt(IngredientJsonModel::getCalories).sum();
        Double proteins = collect.stream().mapToDouble(IngredientJsonModel::getProteins).sum();
        Double fats = collect.stream().mapToDouble(IngredientJsonModel::getFats).sum();
        Double carbohydrates = collect.stream().mapToDouble(IngredientJsonModel::getCarbohydrates).sum();
//        BigDecimal proteins= BigDecimal.valueOf(collect.stream()
//                        .mapToDouble(IngredientJsonModel::getProteins).sum())
//                .setScale(2, RoundingMode.HALF_UP);
//
//        BigDecimal fats= BigDecimal.valueOf(collect.stream()
//                        .mapToDouble(IngredientJsonModel::getFats).sum())
//                .setScale(2, RoundingMode.HALF_UP);
//
//        BigDecimal carbohydrates= BigDecimal.valueOf(collect.stream()
//                        .mapToDouble(IngredientJsonModel::getCarbohydrates).sum())
//                .setScale(2, RoundingMode.HALF_UP);



        return new RecipeJsonModel(souce.getUuid(),
                souce.getDtCreate(),
                souce.getDtUpdate(),
                souce.getTitle(),
                collect,
                weight,
                calories,
                proteins,
                fats,
                carbohydrates);

}
}
