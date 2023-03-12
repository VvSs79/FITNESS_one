package Mk.JD2_95_22.fitness.servise.product;

import Mk.JD2_95_22.fitness.converter.product.*;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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


    public void update(UUID uuid, long dtUpdate,String title, ProductDTO productDTO) {
        if(uuid==null||productDTO==null){
            throw new SingleError("Send parametrs for update");
            validator.validate(productDTO);
        }
        Optional<ProductEntity> optionalProductUUID=repository.findById(uuid);
        Optional<ProductEntity> optionalProductTitle=repository.getAllByTitle(productDTO.getTitle());

        if (optionalProductUUID.isEmpty()) {
            throw new SingleError("Not found product for update");

            ProductEntity productEntity=optionalProductTitle.get();
            if(productEntity.getDtUpdate().equals(dtUpdate)){
                throw new SingleError("Outdated version");
            }

            if(optionalProductTitle.isPresent() && optionalProductTitle.get().getUuid().equals(uuid)){
                throw new SingleError("This product name is already in use");
            }

            productEntity.setTitle(productDTO.getTitle());
            productEntity.setWeight(productDTO.getWeight());
            productEntity.setCalories(productDTO.getCalories());
            productEntity.setProteins(productDTO.getProteins());
            productEntity.setFats(productDTO.getFats());
            productEntity.setCarbohydrates(productDTO.getCarbohydrates());

            repository.save(productEntity);
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

    public void getProduct(UUID uuid){
        Optional<ProductEntity> optionalProductEntity=repository.findById(uuid);
        if (optionalProductEntity.isEmpty()){
            throw  new SingleError("Еhere is no product with that name");
        }
    }

}



