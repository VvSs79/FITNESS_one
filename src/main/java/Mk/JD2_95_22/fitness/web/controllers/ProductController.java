package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.nutrition.product.ProductCreate;
import Mk.JD2_95_22.fitness.core.dto.nutrition.product.ProductUpdate;
import Mk.JD2_95_22.fitness.service.api.product.IProductService;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody @Validated ProductCreate productCreate) {
        iProductService.create(productCreate);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PageDTO> getPageProducts(@RequestParam(name = "page", defaultValue = "0") @Min(0) int page,
                                                   @RequestParam(name = "size", defaultValue = "20") @Min(0) int size) {
        return ResponseEntity.status(HttpStatus.OK).body(iProductService.getPageProducts(page, size));
    }

    @RequestMapping(path = "/{uuid}/dt_update/{dt_update}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("uuid") UUID userUUID,
                                    @PathVariable("dt_update") Instant dtUpdate,
                                    @RequestBody @Validated ProductCreate productCreate) {
        iProductService.update(new ProductUpdate(productCreate, dtUpdate, userUUID));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
