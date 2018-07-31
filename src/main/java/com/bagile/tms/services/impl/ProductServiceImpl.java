package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Alias;
import com.bagile.tms.dto.Product;
import com.bagile.tms.dto.ProductPack;
import com.bagile.tms.entities.PdtProduct;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.ProductMapper;
import com.bagile.tms.repositories.*;
import com.bagile.tms.services.ProductService;
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

import javax.servlet.ServletContext;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service @Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPackRepository productPackRepository;

    @Autowired
    private AliasRepository aliasRepository;

    @Autowired
    private ServletContext servletContext;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private UomRepository uomRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private SaleOrderLineRepository saleOrderLineRepository;
    @Autowired
    private DeliveryLineRepository deliveryLineRepository;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProductService.class);
    @Autowired
    private SettingRepository settingRepository;

    @Override
    @Transactional
    public Product save(Product product) {

        return product;
    }

    @Override
    public Boolean isExist(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public Product findById(Long id) throws IdNotFound {
        Product product =setQuantities( ProductMapper.toDto(productRepository.findById(id).get(),
                false));
        if (null != product) {
            return product;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Product> find(String search) throws AttributesNotFound,
            ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return setProductsQuantities( ProductMapper.toDtos(productRepository.findAll(Search
                .expression(search, PdtProduct.class)), false));
    }

    @Override
    public List<Product> find(String search, int page, int size)
            throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "pdtProductUpdateDate", "pdtProductId");
        Pageable pageable = new PageRequest(page, size, sort);
        return setProductsQuantities( ProductMapper.toDtos(
                productRepository.findAll(
                        Search.expression(search, PdtProduct.class), pageable),
                false));
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return productRepository.count(Search.expression(search,
                PdtProduct.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Product");
        PdtProduct pdtProduct = productRepository.findById(id).get();


    }

    @Override
    public void delete(Product product) {
        LOGGER.info("delete Product");
        PdtProduct pdtProduct = productRepository.findById(product.getId()).get();
        pdtProduct.setPdtProductIsActive(false);
        productRepository.saveAndFlush(pdtProduct);
        // productRepository.delete(ProductMapper.toEntity(product, false));
        String codeProduct = "";

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

    @Override
    public String getNextVal() {
        List<BigInteger> objects = productRepository.getNextVal();
        return objects.get(0).toString();

    }

    private Alias aliasFromProduct(Product product, String mode) {
        Alias alias = new Alias();
        alias.setEanCode(product.getCode());
        alias.setProduct(product);
        alias.setOwner(product.getOwner());
        alias.setUom(product.getUomByProductUomBase());
        alias.setUpdateDate(EmsDate.getDateNow());
        if ("I".equals(mode)) {
            alias.setCreationDate(EmsDate.getDateNow());
        }
        return alias;
    }

    private ProductPack packFromProduct(Product product, Alias alias,
                                        String mode) {
        ProductPack pack = new ProductPack();
        pack.setQuantity(BigDecimal.ONE);
        pack.setSalePrice(product.getSalePriceUB());
        pack.setPurshasePrice(product.getPurshasePriceUB());
        pack.setOwner(product.getOwner());
        pack.setUom(product.getUomByProductUomBase());
        pack.setProduct(product);
        pack.setAlias(alias);
        pack.setUpdateDate(EmsDate.getDateNow());
        if ("I".equals(mode)) {
            alias.setCreationDate(EmsDate.getDateNow());
        }

        return pack;
    }


    @Override
    public BigDecimal stockQuantity(Long id) {
        return productRepository.stockQuantity(id);
    }

    @Override
    public BigDecimal reservedQuantity(Long id) {
        return productRepository.reservedQuantity(id);
    }

    @Override
    public BigDecimal blockedQuantity(Long id) {
        return productRepository.blockedQuantity(id);
    }

    @Override
    public BigDecimal orderedQuantity(Long id) {
        return productRepository.orderedQuantity(id);
    }

    @Override
    public BigDecimal quantityToReceive(Long id) {
        return productRepository.quantityToReceive(id);
    }

    private Product setQuantities(Product product) {
        if (null != product & 0 < product.getId()) {
            product.setOrderedQuantity(productRepository.orderedQuantity(product.getId()));
            product.setStockQuantity(productRepository.stockQuantity(product.getId()));
            product.setReservedQuantity(productRepository.reservedQuantity(product.getId()));
            product.setBlockedQuantity(productRepository.blockedQuantity(product.getId()));
            product.setQuantityToReceive(productRepository.quantityToReceive(product.getId()));
        }
        return product;
    }

    private List<Product> setProductsQuantities(List<Product> products) {
        return products.stream().map(product -> {
            return setQuantities(product);
        }).collect(Collectors.toList());
    }
}