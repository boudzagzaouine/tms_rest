package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.PdtProduct;
import com.bagile.gmo.entities.PdtProductView;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ProductMapper;
import com.bagile.gmo.repositories.ProductRepository;
import com.bagile.gmo.repositories.ProductViewRepository;
import com.bagile.gmo.services.ProductPackService;
import com.bagile.gmo.services.ProductService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPackService productPackService;
    @Autowired
    private ProductViewRepository productViewRepository;

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
        return productRepository.count();

    }

    @Override
    public Boolean isExist(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public Product findById(Long id) throws IdNotFound {
     /*   Product product = ProductMapper.toDto(productRepository.findById (id).orElse (null),
                false);
        if (null != product) {
            return product;
        } else {
            throw new IdNotFound(id);
        }*/

        Product product = ProductMapper.toViewDto(productViewRepository.findById(id).orElse(null),
                false);
        if (null != product) {
            return product;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public Product findOne(String search) throws AttributesNotFound, ErrorType {
     /*   try {
            //search = addActiveConditionToSearch(search);
            return ProductMapper.toDto(productRepository.findOne(Search.expression(search, PdtProduct.class)).orElse (null), false);
        } catch (Exception e) {
            LOGGER.error("could not findOne Product");
            return null;
        }*/
        try {
            search = addActiveConditionToSearch(search);
            return ProductMapper.toViewDto(productViewRepository.findOne(Search
                    .expression(search, PdtProductView.class)).orElse(null), false);
        } catch (Exception e) {
            LOGGER.error("could not findOne Product");
            return null;
        }

    }

    @Override
    public List<Product> find(String search) throws AttributesNotFound,
            ErrorType {
        /*search = addActiveConditionToSearch(search);
        return ProductMapper.toDtos(productRepository.findAll(Search
                .expression(search, PdtProduct.class)), false);*/

       /* if (search.equals("")){
            return findAll ();
        }
        return ProductMapper.toDtos(productRepository.findAll
                (Search.expression(search, PdtProduct.class)), false);*/
        search = addActiveConditionToSearch(search);
        return ProductMapper.toViewDtos(productViewRepository.findAll(Search
                .expression(search, PdtProductView.class)), false);
    }

    private String addActiveConditionToSearch(String search) {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",") && !search.isEmpty()) {
                search += ",";
            }
            search += "active:true";
        }
        return search;
    }

    @Override
    public List<Product> find(String search, Pageable pageable)
            throws AttributesNotFound, ErrorType {
        //search = addActiveConditionToSearch(search);
        // Sort sort = Sort.by (Sort.Direction.DESC, "pdtProductUpdateDate", "pdtProductId");
        //  Pageable pageable = PageRequest.of (page, size, sort);
       /* if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ProductMapper.toDtos(productRepository.findAll(Search.expression(search, PdtProduct.class), pageable), false);
*/

       /* if (search.equals("")){
            return findAll (pageable);
        }
        return ProductMapper.toDtos(productRepository.findAll(Search.expression(search, PdtProduct.class), pageable), false);
*/
//return findAll();

        search = addActiveConditionToSearch(search);
        Sort sort = Sort.by(Sort.Direction.ASC, "pdtProductCode");
        return ProductMapper.toViewDtos(
                productViewRepository.findAll(
                        Search.expression(search, PdtProductView.class), pageable),
                false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        //  search = addActiveConditionToSearch(search);
        if (search.equals("")) {
            return size();
        }
        return productRepository.count(Search.expression(search, PdtProduct.class));
    }

    @Override
    public List<Product> findAll() throws AttributesNotFound, ErrorType {
        return ProductMapper.toViewDtos(
                productViewRepository.findAll( ),
                false);


        //return ProductMapper.toDtos(productRepository.findAll(), false);

    }

   /* public List<Product> findAll(List<Long> ids) {
        return ProductMapper.toViewDtos (productViewRepository.findAll(ids), false);
    }*/

    @Override
    public List<Long> getIds() {
        return productRepository.getIds();
    }

    @Override
    public BigDecimal stockQuantity(Long id) {
        return productRepository.stockQuantity(id);
    }


    @Override
    public List<Product> findAll(Pageable pageable) throws AttributesNotFound,
            ErrorType {
     /*   Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ProductMapper.toDtos(productRepository.findAll(pageable), false);*/

        return ProductMapper.toDtos(productRepository.findAll(pageable), false);

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
    public void deleteAll(List<Long> ids) {
        for (Long id : ids) {
            productRepository.deleteById(id);
        }
    }

    @Override
    public BigDecimal convertQuantityByUom(BigDecimal qte, Uom uom, Uom uomServed, Product product) {
        try {
            product = findById(product.getId());
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }

        List<ProductPack> productPacks = Lists.newArrayList(product.getProductPacks());
        ProductPack served = new ProductPack();
        ProductPack expected = new ProductPack();


        for (ProductPack productPack : productPacks) {
            if (productPack.getUom().equals(uomServed)) {
                served = productPack;
            }
            if (productPack.getUom().equals(uom)) {
                expected = productPack;
            }
        }
        BigDecimal newQte = qte.multiply(served.getQuantity().divide(expected.getQuantity(), 2, RoundingMode.HALF_DOWN));

        return newQte;
    }

    @Override
    public BigDecimal convertQuantityByUom(BigDecimal qte, ProductPack packExpected, ProductPack packServed) {
        BigDecimal newQte = qte.multiply(packServed.getQuantity().divide(packExpected.getQuantity(), 2, RoundingMode.HALF_DOWN));

        return newQte;
    }

    @Override
    public void updatePurchasePrice(Long id, BigDecimal purchasePrice, ProductPack productPack, Supplier supplier, Currency currency) {
        try {

           /* PdtProduct product = productRepository.findOne(id);
            Optional<PdtProductPack> optionalPdtProductPack = product.getPdtProductPacks ( ).stream ( ).filter (pdtProductPack -> pdtProductPack.getPdtProductPackId ( ) == productPack.getId ( )).findAny ( );

            if (optionalPdtProductPack.isPresent ( ) && product.getPrmCurrencyPurshase ( ) != null && product.getPrmCurrencyPurshase ( ).getPrmCurrencyId ( ) == currency.getId ( )) {
                PdtProductPack pdtProductPack = optionalPdtProductPack.get ( );

                if (pdtProductPack.getPdtProductSuppliers ( ) != null && !pdtProductPack.getPdtProductSuppliers ( ).isEmpty ( )) {
                    Optional<PdtProductSupplier> optionalPdtProductSupplier = pdtProductPack.getPdtProductSuppliers ( ).stream ( ).filter (pdtProductSupplier -> pdtProductSupplier.getPdtProductSupplierId ( ) == supplier.getId ( ) && product.getPrmCurrencyPurshase ( ).getPrmCurrencyId ( ) == currency.getId ( )).findAny ( );
                    if (optionalPdtProductSupplier.isPresent ( )) {
                        PdtProductSupplier pdtProductSupplier = optionalPdtProductSupplier.get ( );
                        pdtProductSupplier.setPdtProductSupplierPrice (purchasePrice);
                        productSupplierService.save (ProductSupplierMapper.toDto (pdtProductSupplier, false));
                    }
                } else {
                    pdtProductPack.setPdtProductPurshasePrice (purchasePrice);
                    product.getPdtProductPacks ( ).add (pdtProductPack);
                    if (product.getPdtProductPack ( ).getPdtProductPackId ( ) == pdtProductPack.getPdtProductPackId ( )) {
                        product.setPdtProductPurshasePriceUB (purchasePrice);
                        product.setPdtProductTTCPurshasePriceUB (product.getPdtProductPurshasePriceUB ( ).multiply ((BigDecimal.ONE.add ((product.getPrmVatPurchase ( ).getPrmVatValue ( )).divide (BigDecimal.valueOf (100), 2, BigDecimal.ROUND_HALF_UP)))));
                        if (product.getPdtProductMarginOfPurchase ( ) != null) {
                            product.setPdtProductSalePriceUB (product.getPdtProductPurshasePriceUB ( ).multiply ((BigDecimal.ONE.add ((product.getPdtProductMarginOfPurchase ( ).divide (BigDecimal.valueOf (100), 2, BigDecimal.ROUND_HALF_UP))))));
                            product.setPdtProductTTCSalePriceUB (product.getPdtProductSalePriceUB ( ).multiply ((BigDecimal.ONE.add ((product.getPrmVat ( ).getPrmVatValue ( )).divide (BigDecimal.valueOf (100), 2, BigDecimal.ROUND_HALF_UP)))));
                        }
                    }
                    productRepository.saveAndFlush (product);
                }
            }*/
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}