package Mk.JD2_95_22.fitness.servise.product;

import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.ProductCreated;
import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.core.exeption.SingleErrorResponse;
import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;
import Mk.JD2_95_22.fitness.orm.repository.IProductRepositpry;
import Mk.JD2_95_22.fitness.servise.api.product.IProductService;
import Mk.JD2_95_22.fitness.servise.my_exeption.product.ProductNotFoundExeption;
import Mk.JD2_95_22.fitness.servise.my_exeption.version.InvalidVersionExeption;
import Mk.JD2_95_22.fitness.servise.validation.api.IValidator;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.Instant;
import java.util.*;

public class ProductService implements IProductService {
    private final IProductRepositpry repository;
    private final ConversionService conversionService;
    private final IValidator<ProductCreated> validator;

    public ProductService(IProductRepositpry repository, ConversionService conversionService, IValidator<ProductCreated> validator) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.validator = validator;
    }

    @Override
    public void createdProduct(ProductCreated product) {
        if (product==null){
            throw new SingleErrorResponse("Not found this a product");
        }
        if (repository.existsByTitle(product.getTitle())){
            throw new SingleErrorResponse("This product is exist");
        }
        validator.validate(product);
        Instant dtCreated=Instant.now();
        ProductEntity entity=conversionService.convert(product, ProductEntity.class);
        entity.setDtCreate(dtCreated);
        entity.setDtUpdate(dtCreated);
        repository.save(entity);
    }
    @Override
    public void update(ProductDTO productDTO) {
        ProductEntity productEntity = repository.findById(productDTO.getUuid())
                .orElseThrow(() -> new ProductNotFoundExeption("Такого продукта не существует"));

        if (productEntity.getDtUpdate().toEpochMilli() == productDTO.getDtUpdate().toEpochMilli()) {
            productEntity.setTitle(productDTO.getTitle());
            productEntity.setWeight(productDTO.getWeight());
            productEntity.setCalories(productDTO.getCalories());
            productEntity.setProteins(productDTO.getProteins());
            productEntity.setFats(productDTO.getFats());
            productEntity.setCarbohydrates(productDTO.getCarbohydrates());
            repository.save(productEntity);
        } else throw new InvalidVersionExeption("Такой версии не существует");
    }

    @Override
    public PageDTO<ProductDTO> getPageProducts(int page, int size){
        PageRequest paging=PageRequest.of(page, size);
        Page<ProductEntity> all=repository.findAll(paging);
        List<ProductDTO> pageOfUsers=all.getContent().stream()
                .map(s->conversionService.convert(s,ProductDTO.class))
                .toList();
        return new PageDTO<>(page,
                size,
                all.getTotalPages(),
                all.getTotalElements(),
                all.isFirst(),
                all.getNumberOfElements(),
                all.isLast(),
                pageOfUsers);
    }
    @Override
    public Optional<ProductEntity> getProduct(UUID uuid){
        Optional<ProductEntity> productEntity=repository.findById(uuid);
        if (productEntity.isEmpty()){
            throw  new SingleErrorResponse("There is no product with that name");
        }

        return productEntity;
    }
    public ProductEntity getProducts(UUID uuid){
        Optional<ProductEntity> productEntity=repository.findById(uuid);
        if (productEntity.isEmpty()){
            throw  new SingleErrorResponse("There is no product with that name");
        }
        return conversionService.convert(productEntity, ProductEntity.class);
    }
}



