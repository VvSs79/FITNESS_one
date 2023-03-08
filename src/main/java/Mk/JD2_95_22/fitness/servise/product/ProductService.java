package Mk.JD2_95_22.fitness.servise.product;

import Mk.JD2_95_22.fitness.converter.product.*;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.products.ProductCreated;
import Mk.JD2_95_22.fitness.core.dto.products.ProductDTO;
import Mk.JD2_95_22.fitness.orm.entity.product.ProductEntity;
import Mk.JD2_95_22.fitness.orm.repository.IProductRepositpry;
import Mk.JD2_95_22.fitness.servise.api.product.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductService implements IProductService {
    private final IProductRepositpry repository;
    private final ProductConverterDtoToEntity productConverterDtoToEntity;
    private final ProductConvertertEntityToDTO productConvertertEntityToDTO;
    private final ProductConverterEntityToModel productConverterPEntityToModel;
    private final ProductConverterModelToEntity productConverterModelToEntity;

    private final ProductConverterEntityToPage productConverterEntityToPage;

    public ProductService(IProductRepositpry repository, ProductConverterDtoToEntity productConverterDtoToEntity, ProductConvertertEntityToDTO productConvertertEntityToDTO, ProductConverterEntityToModel productConverterPEntityToModel, ProductConverterModelToEntity productConverterModelToEntity, ProductConverterEntityToPage productConverterEntityToPage) {
        this.repository = repository;
        this.productConverterDtoToEntity = productConverterDtoToEntity;
        this.productConvertertEntityToDTO = productConvertertEntityToDTO;
        this.productConverterPEntityToModel = productConverterPEntityToModel;
        this.productConverterModelToEntity = productConverterModelToEntity;
        this.productConverterEntityToPage = productConverterEntityToPage;
    }


    @Override
    public void addProduct(ProductDTO productCreateDTO) {

        ProductEntity entity = productConverterDtoToEntity.convert(productCreateDTO);
       repository.save(entity);
    }

    @Override
    public void update(UUID uuid, long dtUpdate, ProductCreated productCreateDTO) {
        Optional<ProductEntity> findEntity = repository.findById(uuid);
        ProductEntity entity = findEntity.get();
        if (entity != null) {
            long epochMilli = ZonedDateTime.of(LocalDateTime.from(entity.getDt_update()), ZoneId.systemDefault()).toInstant().toEpochMilli();

            if ( epochMilli == dtUpdate && entity.getUuid().equals(uuid) ) {
                entity.setDt_update(Instant.now());
                entity.setTitle(productCreateDTO.getTitle());
                entity.setWeight(productCreateDTO.getWeight());
                entity.setCalories(productCreateDTO.getCalories());
                entity.setProteins(productCreateDTO.getProteins());
                entity.setFats(productCreateDTO.getFats());
                entity.setCarbohydrates(productCreateDTO.getCarbohydrates());

                repository.save(entity);
            }else{
                throw new IllegalArgumentException("Версии продукта с id " + uuid +" не совпадают!");
            }
        } else {
            throw new IllegalArgumentException("Продукта с id " + uuid + " для обновления не найдено!");
        }

    }

    @Override
    public PageDTO<ProductDTO> getPage(int numberOfPage, int size) {
        Pageable pageable = PageRequest.of(numberOfPage, size);

        Page<ProductEntity> allEntity =repository.findAll(pageable);
        List<ProductDTO> content = new ArrayList<>();
        for (ProductEntity entity: allEntity) {
            ProductDTO productDTO = productConvertertEntityToDTO.convert(entity);
            content.add(productDTO);
        }

        return new PageDTO<ProductDTO>(allEntity.getNumber(),
                allEntity.getSize(),
                allEntity.getTotalPages(),
                allEntity.getTotalElements(),
                allEntity.isFirst(),
                allEntity.getNumberOfElements(),
                allEntity.isLast(),
                content );
    }
}
