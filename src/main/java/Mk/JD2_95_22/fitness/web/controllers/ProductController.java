package Mk.JD2_95_22.fitness.web.controllers;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.servise.api.product.IProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    protected ResponseEntity<?> create(@RequestBody @Valid ProductDTO product ) {
        service.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @RequestMapping(method = RequestMethod.GET)
    protected ResponseEntity<PageDTO<ProductDTO>> getAll(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "20") Integer size) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getPage(page, size));
    }
    @RequestMapping(path = "/{uuid}/dt_update/{dt_update}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("uuid") UUID uuid,
                                    @PathVariable("dt_update") Long dtUpdate,
                                    @RequestBody @Valid ProductDTO product) {
        Instant version = Instant.ofEpochMilli(dtUpdate);
        service.update(uuid, version, product);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
