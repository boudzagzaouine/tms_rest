package com.bagile.tms.services.impl;

import com.bagile.tms.dto.ProductType;
import com.bagile.tms.entities.PdtProductType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.ProductTypeMapper;
import com.bagile.tms.repositories.ProductTypeRepository;
import com.bagile.tms.services.ProductTypeService;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProductTypeService.class);



    @Override
    public ProductType save(ProductType productType) {
        LOGGER.info("save ProductType");
        productType.setUpdateDate(EmsDate.getDateNow());
        if (0 >= productType.getId()) {
            productType.setCreationDate(EmsDate.getDateNow());
        }
        PdtProductType pdtProductType = productTypeRepository.saveAndFlush(ProductTypeMapper.toEntity(productType, false));
        productType = ProductTypeMapper.toDto(pdtProductType, false);

        return productType;

    }

   /*     public void readFileProductType(com.sinno.wms.crud.modelbasic.products.ProductType proT){
                try {
                    proT = ConvertManagerProductType.readFileProductType("IPT01.xls").get(0);
                    ProductType productType=new ProductType();
                    productType = MapperProductType.convertToEmsDto(proT);
                    productTypeRepository.saveAndFlush(ProductTypeMapper.toEntity(productType, false));

                }catch(Exception e){
                    e.printStackTrace();
                }

            }  */

    @Override
    public Long size() {
        return productTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return productTypeRepository.existsById (id);
    }

    @Override
    public ProductType findById(Long id) throws IdNotFound {
        ProductType productType = ProductTypeMapper.toDto(productTypeRepository.findById (id).orElse (null), false);
        if (null != productType) {
            return productType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public ProductType findOne(String search) throws AttributesNotFound, ErrorType {
        return ProductTypeMapper.toDto(productTypeRepository.findOne(Search.expression(search, PdtProductType.class)).orElse (null), false);
    }

    @Override
    public List<ProductType> find(String search) throws AttributesNotFound, ErrorType {
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(Search.expression(search, PdtProductType.class)), false);
    }

    @Override
    public List<ProductType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by (Sort.Direction.DESC, "pdtProductTypeUpdateDate");
        Pageable pageable = PageRequest.of (page, size, sort);
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(Search.expression(search, PdtProductType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return productTypeRepository.count(Search.expression(search, PdtProductType.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ProductType");
        productTypeRepository.deleteById (id);
    }

    @Override
    public void delete(ProductType productType) {
        LOGGER.info("delete ProductType");
        PdtProductType pdtProductType = productTypeRepository.findById (productType.getId()).orElse (null);
        productTypeRepository.delete(ProductTypeMapper.toEntity(productType, false));

    }

    @Override
    public List<ProductType> findAll() {
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(), false);
    }

    @Override
    public List<ProductType> findAll(Pageable pageable) {
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(pageable), false);
    }



    @Override
    public ProductType findByCode(String code) {
        return ProductTypeMapper.toDto(productTypeRepository.findByPdtProductTypeCode(code),false);
    }
    @Override
    public List<ProductType> getProductTypeChildrens(Long productType, List<ProductType> productTypes) throws AttributesNotFound, ErrorType {
        String search = "productType.id:" + productType;
        List<ProductType> childrens = find(search);
        productTypes.addAll(childrens);
        if (null != childrens && !childrens.isEmpty())
            for (ProductType type : childrens) {
                getProductTypeChildrens(type.getId(), productTypes);
            }
        return productTypes;
    }

}
