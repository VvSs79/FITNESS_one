package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.RecipeDTO;
import Mk.JD2_95_22.fitness.servise.api.product.IRecepteService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;
@RestController
@RequestMapping("/api/v1/recipe")
public class RecepeController {
    private IRecepteService service;

    public RecepeController(IRecepteService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    protected ResponseEntity<?> create(@RequestBody RecipeDTO product) {
        service.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @RequestMapping(method = RequestMethod.GET)
    protected ResponseEntity<PageDTO<RecipeDTO>> getAll(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "20") Integer size) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getPageRecipe(Pageable.ofSize(page)));
    }
    @RequestMapping(path = "/{uuid}/dt_update/{dt_update}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("uuid") UUID uuid,
                                    @PathVariable("dt_update") Long dtUpdate,
                                    @PathVariable("dt_update") String title,
                                    @RequestBody RecipeDTO product) {
        Instant version = Instant.ofEpochMilli(dtUpdate);
        service.update(uuid, version, product,title);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
