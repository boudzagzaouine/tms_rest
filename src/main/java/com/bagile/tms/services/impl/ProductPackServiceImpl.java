package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Product;
import com.bagile.tms.dto.ProductPack;
import com.bagile.tms.entities.PdtProductPack;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.ProductMapper;
import com.bagile.tms.mapper.ProductPackMapper;
import com.bagile.tms.mapper.UomMapper;
import com.bagile.tms.repositories.ProductPackRepository;
import com.bagile.tms.repositories.ProductRepository;
import com.bagile.tms.services.ProductPackService;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;

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
        return productPackRepository.existsById(id);
    }

    @Override
    public ProductPack findById(Long id) throws IdNotFound {
        ProductPack productPack = ProductPackMapper.toDto(productPackRepository.findById(id).get(), false);
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
        productPackRepository.deleteById(id);
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