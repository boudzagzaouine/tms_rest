package com.bagile.tms.services.impl;

import com.bagile.tms.dto.ProductType;
import com.bagile.tms.entities.PdtProductType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.ProductTypeMapper;
import com.bagile.tms.repositories.OwnerRepository;
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
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {


    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProductTypeService.class);


    @Override
    public ProductType save(ProductType productType) {
        LOGGER.info("save ProductType");
        productType.setUpdateDate(EmsDate.getDateNow());
        if (0 >= productType.getId()) {
            productType.setCreationDate(EmsDate.getDateNow());
        }
        productType = ProductTypeMapper.toDto(productTypeRepository.saveAndFlush(ProductTypeMapper.toEntity(productType, false)), false);

        return productType;

    }


    @Override
    public Long size() {
        return productTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return productTypeRepository.existsById(id);
    }

    @Override
    public ProductType findById(Long id) throws IdNotFound {
        ProductType productType = ProductTypeMapper.toDto(productTypeRepository.findById(id).get(), false);
        if (null != productType) {
            return productType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ProductType> find(String search) throws AttributesNotFound, ErrorType {
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(Search.expression(search, PdtProductType.class)), false);
    }

    @Override
    public List<ProductType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "pdtProductTypeUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(Search.expression(search, PdtProductType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return productTypeRepository.count(Search.expression(search, PdtProductType.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ProductType");
        productTypeRepository.deleteById(id);
    }

    @Override
    public void delete(ProductType productType) {
        LOGGER.info("delete ProductType");
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


}
