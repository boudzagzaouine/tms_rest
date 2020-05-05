package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Product;
import com.bagile.gmo.dto.ProductPack;
import com.bagile.gmo.entities.PdtProduct;
import com.bagile.gmo.mapper.ProductMapper;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.repositories.ProductRepository;
import com.bagile.gmo.services.ProductPackService;
import com.bagile.gmo.services.ProductService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
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
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPackService productPackService;


    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProductService.class);


    @Override
    @Transactional
    public Product save(Product product) throws IdNotFound {
        LOGGER.info("save Product");
        Set<ProductPack> listProdctPacks = product.getProductPacks();
        product.setProductPacks(null);
        String mode = "U";//the mode is U for update and I for insert
        product.setUpdateDate(EmsDate.getDateNow());
        String codeProduct = product.getCode();
        String operation = "F"; //this property is used to set the mode of operation in txt file that will be exported to easywms
        if (0 >= product.getId()) {
            mode = "I";
            product.setCreationDate(EmsDate.getDateNow());
            operation = "A";
        }
        // SAVE PRODUCT

        PdtProduct pdtProduct = ProductMapper.toEntity(product, false);
        pdtProduct = productRepository.saveAndFlush(pdtProduct);
        product = ProductMapper.toDto(pdtProduct, false);

        return ProductMapper.toDto(productRepository.saveAndFlush(ProductMapper.toEntity(product, false)), false);
    }


    @Override
    public Long size() {
        try {
            return size("");
        } catch (AttributesNotFound attributesNotFound) {
            // attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            // e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public Boolean isExist(Long id) {
        return productRepository.existsById (id);
    }

    @Override
    public Product findById(Long id) throws IdNotFound {
        Product product = ProductMapper.toDto(productRepository.findById (id).orElse (null),
                false);
        if (null != product) {
            return product;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public Product findOne(String search) throws AttributesNotFound, ErrorType {
        try {
            search = addActiveConditionToSearch(search);
            return ProductMapper.toDto(productRepository.findOne(Search.expression(search, PdtProduct.class)).orElse (null), false);
        } catch (Exception e) {
            LOGGER.error("could not findOne Product");
            return null;
        }
    }

    @Override
    public List<Product> find(String search) throws AttributesNotFound,
            ErrorType {
        search = addActiveConditionToSearch(search);
        return ProductMapper.toDtos(productRepository.findAll(Search
                .expression(search, PdtProduct.class)), false);
    }

    private String addActiveConditionToSearch(String search) {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return search;
    }

    @Override
    public List<Product> find(String search, int page, int size)
            throws AttributesNotFound, ErrorType {
        search = addActiveConditionToSearch(search);
        Sort sort = Sort.by (Sort.Direction.DESC, "pdtProductUpdateDate", "pdtProductId");
        Pageable pageable = PageRequest.of (page, size, sort);
        return ProductMapper.toDtos(
                productRepository.findAll(
                        Search.expression(search, PdtProduct.class), pageable),
                false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        search = addActiveConditionToSearch(search);
        return productRepository.count(Search.expression(search,
                PdtProduct.class));
    }

    @Override
    public List<Product> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<Product> findAll(int page, int size) throws AttributesNotFound,
            ErrorType {
        return find("", page, size);
    }

}