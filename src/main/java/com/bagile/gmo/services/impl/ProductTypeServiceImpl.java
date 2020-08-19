package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ProductType;
import com.bagile.gmo.entities.PdtProductType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ProductTypeMapper;
import com.bagile.gmo.repositories.ProductTypeRepository;
import com.bagile.gmo.services.ProductTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeRepository productTypeRepository;

    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public ProductType save(ProductType productType) {
        return ProductTypeMapper.toDto(productTypeRepository.saveAndFlush(ProductTypeMapper.toEntity(productType, false)), false);
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
        return ProductTypeMapper.toDto(productTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ProductType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(Search.expression(search, PdtProductType.class)), false);
    }

    @Override
    public List<ProductType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(Search.expression(search, PdtProductType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return productTypeRepository.count(Search.expression(search, PdtProductType.class));
    }

    @Override
    public void delete(Long id) {
        productTypeRepository.deleteById(id);
    }

    @Override
    public void delete(ProductType productType) {
        productTypeRepository.delete(ProductTypeMapper.toEntity(productType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            productTypeRepository.deleteById(id);        }
    }


    @Override
    public List<ProductType> findAll() {
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(), false);
    }

    @Override
    public List<ProductType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(pageable), false);
    }

}

