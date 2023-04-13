package Mk.JD2_95_22.fitness.service;

import Mk.JD2_95_22.fitness.core.dto.j_model.ProductJsonModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.nutrition.product.ProductCreate;
import Mk.JD2_95_22.fitness.core.dto.nutrition.product.ProductUpdate;
import Mk.JD2_95_22.fitness.core.exception.product.ProductNotFoundExeption;
import Mk.JD2_95_22.fitness.orm.entity.ProductEntity;
import Mk.JD2_95_22.fitness.orm.repository.product.IProductRepository;
import Mk.JD2_95_22.fitness.service.api.product.IProductService;
import Mk.JD2_95_22.fitness.core.exception.check_exeptions.VersionException;
import jakarta.validation.Valid;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
@Transactional(readOnly = true)
public class ProductService implements IProductService {
    private final IProductRepository repository;
    private final ConversionService conversionService;

    public ProductService(IProductRepository repository, ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    @Override
@Transactional
public UUID create(@Validated ProductCreate productDTO) {

    if (!conversionService.canConvert(ProductJsonModel.class, ProductEntity.class)) {
        throw new IllegalStateException("Can not convert ProductDTO.class");
    }

    ProductEntity product=conversionService.convert(productDTO, ProductEntity.class);
    UUID uuid=UUID.randomUUID();
    Instant dtCreate=Instant.now();
    Instant dtUpdate=dtCreate;

    product.setUuid(uuid);
    product.setDtCreate(dtCreate);
    product.setDtUpdate(dtUpdate);

    repository.save(product);
    return uuid;
}

    @Override
    public PageDTO<ProductJsonModel> getPageProducts(int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        Page<ProductEntity> all = repository.findAll(paging);

        if (!conversionService.canConvert(ProductEntity.class, ProductJsonModel.class)) {
            throw new IllegalStateException("Can not convert ProductEntity.class to ProductModel.class");
        }
        List<ProductJsonModel> productsPages = all.getContent().stream()
                .map(entity -> conversionService.convert(entity, ProductJsonModel.class))
                .collect(Collectors.toList());
        return new PageDTO<>(page,
                size, all.getTotalPages(),
                all.getTotalElements(),
                all.isFirst(),
                all.getNumberOfElements(),
                all.isLast(),
                productsPages);
    }

    @Override
    @Transactional
    public UUID update(@Valid ProductUpdate productDTO) {
        ProductEntity productEntity = repository.findById(productDTO.getUuid())
                .orElseThrow(() -> new ProductNotFoundExeption("There is no product with such id"));
        if (productEntity.getDtUpdate().toEpochMilli() == productDTO.getDtUpdate().toEpochMilli()) {
            productEntity.setTitle(productDTO.getAddProductDTO().getTitle());
            productEntity.setWeight(productDTO.getAddProductDTO().getWeight());
            productEntity.setCalories(productDTO.getAddProductDTO().getCalories());
            productEntity.setProteins(productDTO.getAddProductDTO().getProteins());
            productEntity.setFats(productDTO.getAddProductDTO().getFats());
            productEntity.setCarbohydrates(productDTO.getAddProductDTO().getCarbohydrates());
            repository.save(productEntity);
        } else throw new VersionException("Version is not correct");
        return getUUID(productDTO.getAddProductDTO().getTitle());
    }

    @Override
    public ProductJsonModel getProduct(UUID id) {
        ProductEntity productEntity = this.repository.findById(id).orElseThrow(() -> new ProductNotFoundExeption("There is no product with id "+id));
        if (!conversionService.canConvert(ProductEntity.class, ProductJsonModel.class)) {
            throw new IllegalStateException("Can not convert ProductDTO.class to ProductModel.class");
        }
        return conversionService.convert(productEntity, ProductJsonModel.class);
    }

    private UUID getUUID(String title) {
        ProductEntity productAudit = repository.findByTitle(title);
        ProductJsonModel productDTOAudit = conversionService.convert(productAudit, ProductJsonModel.class);
        return Objects.requireNonNull(productDTOAudit).getUuid();
    }
}