package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Product;
import com.sinno.ems.dto.ProductPack;
import com.sinno.ems.entities.PdtProductPack;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ProductMapper;
import com.sinno.ems.mapper.ProductPackMapper;
import com.sinno.ems.mapper.UomMapper;
import com.sinno.ems.repositories.ProductPackRepository;
import com.sinno.ems.repositories.ProductRepository;
import com.sinno.ems.service.ProductPackService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductPackServiceImpl implements ProductPackService {

    @Autowired
    private ProductPackRepository productPackRepository;
    @Autowired
    private ProductRepository productRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProductPackService.class);

    @Override
    @Transactional
    public ProductPack save(ProductPack productPack) {
        LOGGER.info("save ProductPack");
        productPack.setUpdateDate(EmsDate.getDateNow());
        if (0 >= productPack.getId()) {
            productPack.setCreationDate(EmsDate.getDateNow());
        }
    	// UPDATE ALL PRODUCT PACK WITH SAME UOM
    	List<ProductPack> packs = ProductPackMapper.toDtos(productPackRepository.
    			findByPdtUomAndPdtProduct(UomMapper.toEntity(productPack.getUom(), false), 
    					ProductMapper.toEntity(productPack.getProduct(), false)), false);
    	for (ProductPack pdtPack : packs) {
    		if (null != pdtPack && pdtPack.getId() != productPack.getId()) {
    			pdtPack = ProductPackMapper.toDto(productPackRepository.findOne(pdtPack.getId()), false);
    			
        		pdtPack.setDepth(productPack.getDepth());
        		pdtPack.setHeight(productPack.getHeight());
        		pdtPack.setLenght(productPack.getLenght());
        		pdtPack.setSalePrice(productPack.getSalePrice());
        		pdtPack.setQuantity(productPack.getQuantity());
        		pdtPack.setSize(productPack.getSize());
        		pdtPack.setTypePck(productPack.getTypePck());
        		pdtPack.setWeight(productPack.getWeight());
        		pdtPack.setWeightControl(productPack.getWeightControl());
        		pdtPack.setWidth(productPack.getWidth());
        		pdtPack.setUpdateDate(EmsDate.getDateNow());
                LOGGER.info("save ProductPack");
        		PdtProductPack pdtTmp = productPackRepository.saveAndFlush(ProductPackMapper.toEntity(pdtPack, false));
    		}
    	}
    	// UPDATE PRODUCT UOM
    	Product pdt = productPack.getProduct();
    	if (null != pdt && null != pdt.getUomByProductUomBase() && null != productPack.getUom()
    			&& pdt.getUomByProductUomBase().getId() == productPack.getUom().getId()) {
        	pdt.setSalePriceUB(productPack.getSalePrice());
        	productRepository.saveAndFlush(ProductMapper.toEntity(pdt, false));
    	}

        return ProductPackMapper.toDto(productPackRepository.saveAndFlush(ProductPackMapper.toEntity(productPack, false)), false);
    }

    @Override
    public Long size() {
        return productPackRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return productPackRepository.exists(id);
    }

    @Override
    public ProductPack findById(Long id) throws IdNotFound {
        ProductPack productPack = ProductPackMapper.toDto(productPackRepository.findOne(id), false);
        if (null != productPack) {
            return productPack;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ProductPack> find(String search) throws AttributesNotFound, ErrorType {
        return ProductPackMapper.toDtos(productPackRepository.findAll(Search.expression(search, PdtProductPack.class)), false);
    }

    @Override
    public List<ProductPack> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return ProductPackMapper.toDtos(productPackRepository.findAll(Search.expression(search, PdtProductPack.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return productPackRepository.count(Search.expression(search, PdtProductPack.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ProductPack");
        productPackRepository.delete(id);
    }

    @Override
    public void delete(ProductPack productPack) {
        LOGGER.info("save ProductPack");
        productPackRepository.delete(ProductPackMapper.toEntity(productPack, false));
    }

    @Override
    public List<ProductPack> findAll() {
        return ProductPackMapper.toDtos(productPackRepository.findAll(), false);
    }

    @Override
    public List<ProductPack> findAll(Pageable pageable) {
        return ProductPackMapper.toDtos(productPackRepository.findAll(pageable), false);
    }
}