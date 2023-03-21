package Mk.JD2_95_22.fitness.service;

import Mk.JD2_95_22.fitness.core.dto.j_model.ProductJsonModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.product.ProductCreate;
import Mk.JD2_95_22.fitness.core.dto.product.ProductUpdate;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.product.ProductNotFoundExeption;
import Mk.JD2_95_22.fitness.core.exception.validation.ProductValidator;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import Mk.JD2_95_22.fitness.orm.repository.product.IProductRepository;
import Mk.JD2_95_22.fitness.service.api.product.IProductService;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.check_exeptions.VersionException;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.check_exeptions.DoubleException;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProductService implements IProductService {
    private final IProductRepository repository;
    private final ConversionService conversionService;
    private final ProductValidator validator;

    public ProductService(IProductRepository repository, ConversionService conversionService, ProductValidator validator) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.validator = validator;
    }

    @Override
    public void create(ProductCreate productDTO) {
        ProductEntity productEntity = repository.findByTitle(productDTO.getTitle());
        if (productEntity != null) {
            throw new DoubleException("Продукт с таким названием уже существует");
        } else {
            validator.validate(productDTO);
            repository.save(conversionService.convert(productDTO, ProductEntity.class));
        }
    }

    @Override
    public PageDTO<ProductJsonModel> get(int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        Page<ProductEntity> all = repository.findAll(paging);
        List<ProductJsonModel> productsPages = all.getContent().stream()
                .map(s -> conversionService.convert(s, ProductJsonModel.class))
                .collect(Collectors.toList());
        return new PageDTO<>(page,
                size,
                all.getTotalPages(),
                all.getTotalElements(),
                all.isFirst(),
                all.getNumberOfElements(),
                all.isLast(),
                productsPages);
    }

    @Override
    public void update(ProductUpdate productDTO) {
        ProductEntity productEntity = repository.findById(productDTO.getUuid()).orElseThrow(() ->
                new ProductNotFoundExeption("This is a product not found"));
        if (productEntity.getDtUpdate().toEpochMilli() == productDTO.getDtUpdate().toEpochMilli()) {
            productEntity.setTitle(productDTO.getAddProductDTO().getTitle());
            productEntity.setWeight(productDTO.getAddProductDTO().getWeight());
            productEntity.setCalories(productDTO.getAddProductDTO().getCalories());
            productEntity.setProteins(productDTO.getAddProductDTO().getProteins());
            productEntity.setFats(productDTO.getAddProductDTO().getFats());
            productEntity.setCarbohydrates(productDTO.getAddProductDTO().getCarbohydrates());
            repository.save(productEntity);
        } else throw new VersionException("This version does not exist");
    }

    @Override
    public ProductJsonModel get(UUID id) {
        ProductEntity productEntity = this.repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundExeption("This product does not exist"));
        return conversionService.convert(productEntity, ProductJsonModel.class);
    }
}