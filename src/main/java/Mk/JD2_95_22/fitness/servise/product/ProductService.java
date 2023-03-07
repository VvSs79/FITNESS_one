package Mk.JD2_95_22.fitness.servise.product;

import Mk.JD2_95_22.fitness.converter.product.*;
import Mk.JD2_95_22.fitness.orm.repository.IProductRepositpry;
import Mk.JD2_95_22.fitness.servise.api.IProductService;

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
}
