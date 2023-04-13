package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.nutrition.recipe.RecipeCreate;
import Mk.JD2_95_22.fitness.service.api.product.IRecipeService;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.time.Instant;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {
    private IRecipeService iRecipeService;

    public RecipeController(IRecipeService iRecipeService) {
        this.iRecipeService = iRecipeService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody @Validated RecipeCreate recipeForCU) {
        iRecipeService.create(recipeForCU);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PageDTO> get(@RequestParam(name = "page", defaultValue = "0") @Min(0) int page,
                                       @RequestParam(name = "size", defaultValue = "20") @Min(0) int size) {
        return ResponseEntity.status(HttpStatus.OK).body(iRecipeService.get(page, size));
    }

    @RequestMapping(path = "/{uuid}/dt_update/{dt_update}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("uuid") UUID userUUID,
                                    @PathVariable("dt_update") Instant dtUpdate,
                                    @RequestBody @Validated RecipeCreate recipe) {
         iRecipeService.update(userUUID,dtUpdate,recipe);
         return ResponseEntity.status(HttpStatus.OK).build();
}

}

