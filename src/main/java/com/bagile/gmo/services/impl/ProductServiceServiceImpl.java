package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.PdtProduct;
import com.bagile.gmo.entities.PdtProduct;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ProductMapper;
import com.bagile.gmo.repositories.ProductRepository;
import com.bagile.gmo.repositories.ProductViewRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.GmaoSearch;
import com.bagile.gmo.util.Search;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceServiceImpl implements ProductServiceService, GmaoSearch {

    @Autowired
    private ProductRepository productRepository;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProductService.class);


    @Override
    @Transactional
    public Product save(Product product) throws IdNotFound, AttributesNotFound, ErrorType {
      
 product.setGmao(true);
 product.setService(true);
        return ProductMapper.toDto (productRepository.saveAndFlush (ProductMapper.toEntity (product, false)), false);

    }

   
    @Override
    public Long size() throws AttributesNotFound, ErrorType {
        return productRepository.count(Search.expression(addServiceToSearch(""), PdtProduct.class));

    }

    @Override
    public Boolean isExist(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public Product findById(Long id) throws IdNotFound {
        
        Product product = ProductMapper.toDto(productRepository.findById(id).orElse(null),
                false);
        if (null != product) {
            return product;
        } else {
            throw new IdNotFound(id);
        }
    }
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Product> find(String search) throws AttributesNotFound,
            ErrorType {
        
        return ProductMapper.toDtos(productRepository.findAll(Search
                .expression(addServiceToSearch(search), PdtProduct.class)), false);
    }
    

    @Override
    public List<Product> find(String search, Pageable pageable)
            throws AttributesNotFound, ErrorType {
        
        Sort sort = Sort.by(Sort.Direction.ASC, "pdtProductCode");
        return ProductMapper.toDtos(
                productRepository.findAll(
                        Search.expression(addServiceToSearch(search), PdtProduct.class), pageable),
                false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        //  search = addActiveConditionToSearch(search);
        if (search.equals("")) {
            return size();
        }
        return productRepository.count(Search.expression(addServiceToSearch(search), PdtProduct.class));
    }

    @Override
    public List<Product> findAll() throws AttributesNotFound, ErrorType {
        return ProductMapper.toDtos(
                productRepository.findAll(Search.expression(addServiceToSearch(""), PdtProduct.class)),
                false);
    }

    @Override
    public List<Product> findAll(Pageable pageable) throws AttributesNotFound,
            ErrorType {

        return ProductMapper.toDtos(productRepository.findAll(Search.expression(addServiceToSearch(""), PdtProduct.class), pageable), false);

    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(ProductMapper.toEntity(product, false));

    }

    @Override
    public void deleteAll(List<Long> ids) throws AttributesNotFound, ErrorType {
        for (Long id : ids) {
            productRepository.deleteById(id);

        }
    }



}