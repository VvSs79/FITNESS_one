package Mk.JD2_95_22.fitness.servise.product;

import Mk.JD2_95_22.fitness.converter.product.*;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.ProductCreated;
import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.core.exeption.SingleError;
import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;
import Mk.JD2_95_22.fitness.orm.repository.IProductRepositpry;
import Mk.JD2_95_22.fitness.servise.api.product.IProductService;
import Mk.JD2_95_22.fitness.servise.validation.api.IValidator;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.Instant;
import java.util.*;

public class ProductService implements IProductService {
    private final IProductRepositpry repository;
    private final ConversionService conversionService;
    private final ProductConverterDtoToEntity productConverterDtoToEntity;
    private final ProductConvertertEntityToDTO productConvertertEntityToDTO;
    private final ProductConverterEntityToModel productConverterPEntityToModel;
    private final ProductConverterModelToEntity productConverterModelToEntity;
    private final IValidator validator;

    public ProductService(IProductRepositpry repository, ConversionService conversionService, ProductConverterDtoToEntity productConverterDtoToEntity, ProductConvertertEntityToDTO productConvertertEntityToDTO, ProductConverterEntityToModel productConverterPEntityToModel, ProductConverterModelToEntity productConverterModelToEntity, IValidator validator) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.productConverterDtoToEntity = productConverterDtoToEntity;
        this.productConvertertEntityToDTO = productConvertertEntityToDTO;
        this.productConverterPEntityToModel = productConverterPEntityToModel;
        this.productConverterModelToEntity = productConverterModelToEntity;
        this.validator = validator;
    }

    @Override
    public void addProduct(ProductDTO product) {
        if (product==null){
            throw new SingleError("Not found this a product");
        }
        if (repository.existsByTitle(product.getTitle())){
            throw new SingleError("This product is exist");
        }
        validator.validate(product);
        Instant dt_created=Instant.now();
        ProductEntity entity=productConverterDtoToEntity.convert(product);

       entity.setUuid(product.getUuid());
       entity.setDtCreate(product.getDtCreate());
       entity.setDtUpdate(product.getDtUpdate());
       repository.save(entity);
    }


    public void update(UUID uuid, Instant dtUpdate, ProductCreated productCreate) {
        if(uuid == null || dtUpdate == null){
            throw new SingleError("Parameters for updating are not entered");
        }
        validator.validate(productCreate);
        Optional<ProductEntity> findEntity = repository.findById(uuid);

        if (!findEntity.isPresent()) {
            throw new SingleError("Product with this is id " + uuid + " not found");
        } else {
            ProductEntity entity = findEntity.get();
            if (entity.getDtUpdate().equals(dtUpdate) && entity.getUuid().equals(uuid)) {
                entity.setDtUpdate(Instant.now().plusNanos(3));
                entity.setTitle(productCreate.getTitle());
                entity.setWeight(productCreate.getWeight());
                entity.setCalories(productCreate.getCalories());
                entity.setProteins(productCreate.getProteins());
                entity.setFats(productCreate.getFats());
                entity.setCarbohydrates(productCreate.getCarbohydrates());
                repository.save(entity);
            } else {
                throw new SingleError("Версии продукта с id " + uuid + " не совпадают!");
            }
        }
    }

    @Override
    public PageDTO<ProductDTO> getPage(int numberOfPage, int size) {
        Page<ProductEntity> productEntityPage=repository.findAll(PageRequest.of(numberOfPage,size));
        List<ProductEntity> productEntityList=productEntityPage.toList();
        List<ProductDTO> productDTOList=new ArrayList<>();

        for(ProductEntity productEntity: productEntityList){
            productDTOList.add(conversionService.convert(productEntity, ProductDTO.class));
        }
       PageDTO<ProductDTO> pageDTO=new PageDTO<>(productEntityPage.getNumber(),
               productEntityPage.getSize(),
               productEntityPage.getTotalPages(),
               productEntityPage.getTotalElements(),
               productEntityPage.isFirst(),
               productEntityPage.getNumberOfElements(),
               productEntityPage.isLast(),
                productDTOList );
        return pageDTO;
    }

    public ProductEntity getProduct(UUID uuid, ProductEntity productEntity){
        if (productEntity.getUuid()==null&&repository.getAllByUuid(uuid)!=null){
            throw  new SingleError("There is no product with that name");
        }
        if(!Objects.equals(productEntity.getUuid(),repository.getAllByUuid(uuid)!=null)){
            throw  new SingleError("There is no product with that name");
        }
        return productEntity;
    }


    public Optional<ProductEntity> getProductUuid(UUID uuid){
        Optional<ProductEntity> optionalproductEntity=repository.findById(uuid);
        if (optionalproductEntity.isEmpty()){
            throw  new SingleError("There is no product with that name");
        }

        return optionalproductEntity;
    }
}



