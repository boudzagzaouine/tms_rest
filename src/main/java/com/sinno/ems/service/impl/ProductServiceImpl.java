package com.sinno.ems.service.impl;

import com.google.common.collect.Lists;
import com.sinno.ems.dto.*;
import com.sinno.ems.entities.*;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.WarehouseException;
import com.sinno.ems.export.ProductExport;
import com.sinno.ems.mapper.*;
import com.sinno.ems.mapperWms.MapperProduct;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.ProductPackService;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import com.sinno.wms.crud.convertbasic.ConvertManagerProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.io.File;
import java.lang.Exception;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPackRepository productPackRepository;
    @Autowired
    private ProductPackService productPackService;
    @Autowired
    private AliasRepository aliasRepository;
    @Autowired
    private MsgSendRepository msgSendRepository;
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
    private PurshaseOrderLineRepository purshaseOrderLineRepository;
    @Autowired
    private ReceptionLineRepository receptionLineRepository;
    @Autowired
    private SaleOrderLineRepository saleOrderLineRepository;
    @Autowired
    private DeliveryLineRepository deliveryLineRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProductService.class);
    @Autowired
    private SettingRepository settingRepository;

    @Override
    @Transactional
    public Product save(Product product) {
        LOGGER.info("save Product");
        String mode = "U";
        product.setUpdateDate(EmsDate.getDateNow());
        String codeProduct = product.getCode();
        if (0 >= product.getId()) {
            mode = "I";
            product.setCreationDate(EmsDate.getDateNow());
        }

        Alias aliasTmp = product.getAlias();
        product.setAlias(null);
        // SAVE PRODUCT
        PdtProduct pdtProduct = ProductMapper.toEntity(product, false);
        pdtProduct = productRepository.saveAndFlush(pdtProduct);
        product = ProductMapper.toDto(pdtProduct, false);
        if ("I".equals(mode)) {
            // SAVE DEFAULT ALIAS
            Alias defaultAlias = aliasFromProduct(product, mode);
            LOGGER.info("save Alias");
            defaultAlias = AliasMapper.toDto(aliasRepository
                            .saveAndFlush(AliasMapper.toEntity(defaultAlias, false)),
                    false);

            // SAVE DEFAULT PACK
            ProductPack defaultProductPack = packFromProduct(product,
                    defaultAlias, mode);
            defaultProductPack.setSalePrice(product.getSalePriceUB());
            LOGGER.info("save ProductPack");
            defaultProductPack = ProductPackMapper.toDto(productPackRepository
                    .saveAndFlush(ProductPackMapper.toEntity(
                            defaultProductPack, false)), false);

            // SAVE ALIAS IF EXIST
            if (null != aliasTmp && !aliasTmp.getEanCode().isEmpty()) {
                String eanCode = aliasTmp.getEanCode();
                aliasTmp = aliasFromProduct(product, mode);
                aliasTmp.setEanCode(eanCode);
                LOGGER.info("save Alias");
                aliasTmp = AliasMapper.toDto(aliasRepository
                                .saveAndFlush(AliasMapper.toEntity(aliasTmp, false)),
                        false);
                product.setAlias(aliasTmp);
                LOGGER.info("save Product");
                pdtProduct = productRepository.saveAndFlush(ProductMapper
                        .toEntity(product, false));
                product = ProductMapper.toDto(pdtProduct, false);

                // SAVE PRODUCT PACK ALIAS
                ProductPack aliasProductPack = packFromProduct(product,
                        aliasTmp, mode);
                LOGGER.info("save ProductPack");
                aliasProductPack = ProductPackMapper.toDto(
                        productPackRepository.saveAndFlush(ProductPackMapper
                                .toEntity(aliasProductPack, false)), false);
            }
        } else {
            // UPDATE ALIAS
            if (null != aliasTmp && !aliasTmp.getEanCode().isEmpty()) {
                long id = aliasTmp.getId();
                String eanCode = aliasTmp.getEanCode();
                aliasTmp = aliasFromProduct(product, mode);
                aliasTmp.setId(id);
                aliasTmp.setEanCode(eanCode);
                List<ProductPack> productPacks = null;
                try {
                    productPacks = productPackService.find("alias.id:" + aliasTmp.getId() + ",product.id:" + product.getId());
                } catch (AttributesNotFound attributesNotFound) {
                    attributesNotFound.printStackTrace();
                } catch (ErrorType errorType) {
                    errorType.printStackTrace();
                }
                if (productPacks.isEmpty()) {
                    ProductPack productPack = packFromProduct(product, aliasTmp, mode);
                    productPackService.save(productPack);

                }
                LOGGER.info("save Alias");
                aliasTmp = AliasMapper.toDto(aliasRepository
                                .saveAndFlush(AliasMapper.toEntity(aliasTmp, false)),
                        false);
                product.setAlias(aliasTmp);
                LOGGER.info("save Product");
                pdtProduct = productRepository.saveAndFlush(ProductMapper
                        .toEntity(product, false));
                product = ProductMapper.toDto(pdtProduct, false);
            }

            // UPDATE PACK
            Set<ProductPack> listProdctPacks = new HashSet<>();
            for (ProductPack pdtPack : product.getProductPacks()) {
                if (null != pdtPack
                        && null != pdtPack.getUom()
                        && null != product.getUomByProductUomBase()
                        && pdtPack.getUom().getId() == product
                        .getUomByProductUomBase().getId()) {
                    long id = pdtPack.getId();
                    pdtPack = ProductPackMapper.toDto(productPackRepository.findOne(id), false);
                    pdtPack = packFromProduct(product, pdtPack.getAlias(), mode);
                    pdtPack.setId(id);
                    LOGGER.info("save ProductPack");
                    pdtPack = ProductPackMapper.toDto(productPackRepository
                            .saveAndFlush(ProductPackMapper.toEntity(pdtPack,
                                    false)), false);
                    listProdctPacks.add(pdtPack);
                }
            }
            if (listProdctPacks.size() > 0) {
                product.setProductPacks(listProdctPacks);
            } else {
                product.setProductPacks(null);
            }
        }
        PrmSetting wmsSync = settingRepository.findOne(2L);
        boolean syncWms = wmsSync != null && wmsSync.getPrmSettingValue().equals("1") ? true : false;

        if (syncWms) {
            PrmMsgSend msgSend = getPrmMsgSend();
            if (null != msgSend && msgSend.isPrmMsgSendActive()) {
                ProductExport.export(msgSend.getPrmMsgSendPath(), pdtProduct,
                        codeProduct, "F", servletContext);
            }


        /*   com.sinno.wms.crud.modelbasic.products.Product pro = new com.sinno.wms.crud.modelbasic.products.Product();
            if (null != ConvertManagerProduct.readFileProduct("Products.xls") && ConvertManagerProduct.readFileProduct("Products.xls").size() > 0) {
                pro = ConvertManagerProduct.readFileProduct("Products.xls").get(0);
                product = MapperProduct.convertToEmsDto(pro);
                productRepository.saveAndFlush(ProductMapper.toEntity(product, false));
            }   */

            if (null != msgSend && msgSend.isPrmMsgSendActive() && "xls".equals(msgSend.getPrmMsgSendFormat().trim())) {

                writeFileProduct(msgSend.getPrmMsgSendPath(), product);
                writeFileProduct(msgSend.getPrmMsgSendArcPath(), product);
            }

        }

        return product;
    }

    private PrmMsgSend getPrmMsgSend() {
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search
                    .expression("fileType:PRO", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator()) {
                if (msgSends.iterator().hasNext()) {
                    return msgSends.iterator().next();
                }
            }
        } catch (AttributesNotFound attributesNotFound) {
        } catch (ErrorType errorType) {
        }
        return null;
    }


    private void writeFileProduct(String path, Product pro) {

        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";
            com.sinno.wms.crud.modelbasic.products.Product product = com.sinno.ems.mapperWms.MapperProduct.convertToWmsDto(pro);
            ConvertManagerProduct.writeFileProduct(path + File.separator + "IPR01" + dateFormat.format(new Date()) + ".xls", langue, product);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void writeFileProduct(String path, List<Product> products) {

        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";
            List<com.sinno.wms.crud.modelbasic.products.Product> productList = new ArrayList<>();
            for (Product pro : products) {
                productList.add(com.sinno.ems.mapperWms.MapperProduct.convertToWmsDto(pro));
            }
            ConvertManagerProduct.writeFileProduct(path + File.separator + "IPR01" + dateFormat.format(new Date()) + ".xls", langue, productList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void readFileProduct(com.sinno.wms.crud.modelbasic.products.Product pro) {
        try {
            pro = ConvertManagerProduct.readFileProduct("IPR01.xls").get(0);
            Product product = new Product();
            product = MapperProduct.convertToEmsDto(product, pro);
            productRepository.saveAndFlush(ProductMapper.toEntity(product, false));

        } catch (Exception e) {
            e.printStackTrace();
        }

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
        return productRepository.exists(id);
    }

    @Override
    public Product findById(Long id) throws IdNotFound {
        Product product =setQuantities( ProductMapper.toDto(productRepository.findOne(id),
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
    public void delete(Long id) throws WarehouseException {
        LOGGER.info("delete Product");
        PdtProduct pdtProduct = productRepository.findOne(id);
        if (checkBeforeDelete(id)) {
            pdtProduct.setPdtProductIsActive(false);
            productRepository.saveAndFlush(pdtProduct);
        } else {
            LOGGER.error("delete Product");
            throw new WarehouseException("impossible de supprimer " + pdtProduct.getPdtProductCode());
        }

    }

    @Override
    public void delete(Product product) {
        LOGGER.info("delete Product");
        PdtProduct pdtProduct = productRepository.findOne(product.getId());
        pdtProduct.setPdtProductIsActive(false);
        productRepository.saveAndFlush(pdtProduct);
        // productRepository.delete(ProductMapper.toEntity(product, false));
        String codeProduct = "";
        PrmMsgSend msgSend = null;
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search
                    .expression("fileType:PRO", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator()
                    && msgSends.iterator().hasNext()) {
                msgSend = msgSends.iterator().next();
            }
        } catch (AttributesNotFound attributesNotFound) {
            // attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            // e.printStackTrace();
        }
        if (null != msgSend && msgSend.isPrmMsgSendActive()) {
            ProductExport.export(msgSend.getPrmMsgSendPath(), pdtProduct,
                    codeProduct, "M", servletContext);
        }
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
    public BigInteger getNextVal() {
        List<BigInteger> objects = productRepository.getNextVal();
        return objects.get(0);

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

    @Transactional
    public Product loadWmsProduct(com.sinno.wms.crud.modelbasic.products.Product product) {
        PdtProduct pdtProduct = productRepository.findByPdtProductCode(product.getProduct_code());
        Product pdt = null;

        ProductType productType = ProductTypeMapper.toDto(productTypeRepository.findByPdtProductTypeCode(product.getProduct_type_code()), false);
        List<Uom> uoms = null;
        try {
            uoms = UomMapper.toDtos(uomRepository.findAll(Search.expression("code:" + product.getUom_base_code() + ",owner.code:" + product.getOwner_code(), PdtUom.class)), false);
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }

        Uom uom = uoms.size() > 0 ? uoms.get(0) : null;
        Owner owner = OwnerMapper.toDto(ownerRepository.findByOwnOwnerCode(product.getOwner_code()), false);
        Supplier supplier = SupplierMapper.toDto(supplierRepository.findByRcpSupplierCode(product.getDefault_supplier()), false);
        ProductType productUnderType = ProductTypeMapper.toDto(productTypeRepository.findByPdtProductTypeCode(product.getProduct_under_type_code()), false);
        List<Uom> uomSales = null;
        try {
            uomSales = UomMapper.toDtos(uomRepository.findAll(Search.expression("code:" + product.getSales_unit() + ",owner.code:" + product.getOwner_code(), PdtUom.class)), false);
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }
        Uom uomSale = uomSales.size() > 0 ? uomSales.get(0) : null;
        List<Uom> uomPursahses = null;
        try {
            uomPursahses = UomMapper.toDtos(uomRepository.findAll(Search.expression("code:" + product.getPurchase_unit() + ",owner.code:" + product.getOwner_code(), PdtUom.class)), false);
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }
        Uom uomPurshase = uomPursahses.size() > 0 ? uomPursahses.get(0) : null;


        if (null != pdtProduct) {
            pdt = ProductMapper.toDto(pdtProduct, false);
        } else {
            // NEW PRODUCT
            pdt = new Product();
            pdt.setCreationDate(EmsDate.getDateNow());
        }
        if (null == uom) {
            //NEW UOM
            uom = new Uom();
            uom.setCode(product.getBase_unit_price());
            uom.setOwner(owner);
            uom = UomMapper.toDto(uomRepository.saveAndFlush(UomMapper.toEntity(uom, false)), false);
        }

        if (null != pdt) {
            pdt = MapperProduct.convertToEmsDto(pdt, product);
            pdt.setUpdateDate(EmsDate.getDateNow());
            pdt.setProductType(productType);
            pdt.setUomByProductUomBase(uom);
            pdt.setUomByProductUomPurshase(uomPurshase);
            pdt.setUomByProductUomSale(uomSale);
            if (null == pdt.getAlias()) {
                Alias alias = new Alias();
                alias.setEanCode(product.getProduct_pseudo());
                pdt.setAlias(alias);
            } else {
                pdt.getAlias().setEanCode(product.getProduct_pseudo());
            }
            pdt.setProductSubType(productUnderType);
            pdt.setSupplier(supplier);
            pdt.setOwner(owner);
            pdt = save(pdt);
            return pdt;
        }
        return null;
    }

    @Override
    public List<Product> exportWmsProduct(List<Product> products) {
        writeFileProduct(null != getPrmMsgSend() ? getPrmMsgSend().getPrmMsgSendPath() : System.getenv("APPDATA"), products);
        return products;
    }

    private Boolean checkBeforeDelete(Long id) {
        String search = "warehouse.id:" + id;

        try {
            ArrayList<StkStock> stkStocks = Lists.newArrayList(stockRepository.findAll(Search.expression(search, StkStock.class)));
            ArrayList<RcpReceptionLine> rcpReceptions = Lists.newArrayList(receptionLineRepository.findAll(Search.expression(search, RcpReception.class)));
            ArrayList<RcpPurshaseOrderLine> rcpPurshaseOrders = Lists.newArrayList(purshaseOrderLineRepository.findAll(Search.expression(search, RcpPurshaseOrder.class)));
            ArrayList<CmdDeliveryLine> cmdDeliveries = Lists.newArrayList(deliveryLineRepository.findAll(Search.expression(search, CmdDelivery.class)));
            ArrayList<CmdSaleOrderLine> cmdSaleOrders = Lists.newArrayList(saleOrderLineRepository.findAll(Search.expression(search, CmdSaleOrder.class)));
            if ((null == stkStocks || 0 == stkStocks.size())
                    && (null == rcpPurshaseOrders || 0 == rcpPurshaseOrders.size())
                    && (null == cmdDeliveries || 0 == cmdDeliveries.size())
                    && (null == rcpReceptions || 0 == rcpReceptions.size())
                    && (null == cmdSaleOrders || 0 == cmdSaleOrders.size())
                    ) {
                return true;
            }

        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        return false;
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