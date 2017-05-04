package com.sinno.ems.sqlite.service.impl;

import com.sinno.ems.dto.*;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import com.sinno.ems.service.*;
import com.sinno.ems.sqlite.entities.WmsStock;
import com.sinno.ems.sqlite.repositories.WmsStockRepository;
import com.sinno.ems.sqlite.service.SyncStockService;
import com.sinno.ems.util.EmsDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.Exception;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Enissay on 17/11/2016.
 */
@Service
public class SyncStockServiceImpl implements SyncStockService {
    @Autowired
    private WmsStockRepository wmsStockRepository;
    @Autowired
    private StockService stockService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UomService uomService;
    @Autowired
    private ContainerService containerService;
    @Autowired
    private BlockTypeService blockTypeService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private StockExceptionService stockExceptionService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private WarehouseService warehousSerivce;
    @Autowired
    private ExceptionService exceptionService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SyncStockServiceImpl.class);


    @Override
    public void syncStocks() throws ProductControls, AttributesNotFound, ErrorType {
        List<WmsStock> wmsStocks = wmsStockRepository.getWmsStocks();
        for (WmsStock wmsStock : wmsStocks) {
            List<Stock> stocks = searchStock(wmsStock);
            if (!stocks.isEmpty()) {
                BigDecimal quantity = BigDecimal.ZERO;
                for (Stock stock : stocks) {
                    quantity = quantity.add(stock.getQuantity());
                }
                if (0 == quantity.compareTo(wmsStock.getQuantity()))
                    continue;
                else if (1 == quantity.compareTo(wmsStock.getQuantity())) {
                    BigDecimal substractQuantity = quantity.subtract(wmsStock.getQuantity());
                    for (Stock stock : stocks) {
                        if (-1 < stock.getQuantity().compareTo(substractQuantity)) {
                            stock.setQuantity(quantity.subtract(substractQuantity));
                            stock = updateStockLocation(wmsStock, stock);
                            stockService.save(stock);
                            Stock stockOld = null;

                            try {
                                stockOld = stockService.findById(stock.getId());
                            } catch (IdNotFound idNotFound) {
                                idNotFound.printStackTrace();
                            }
                            createStockException(stock, stockOld);
                            break;
                        } else {
                            substractQuantity = substractQuantity.subtract(stock.getQuantity());
                            quantity = quantity.subtract(stock.getQuantity());

                            stock.setQuantity(BigDecimal.ZERO);
                            Stock stockOld = null;
                            try {
                                stockOld = stockService.findById(stock.getId());
                            } catch (IdNotFound idNotFound) {
                                idNotFound.printStackTrace();
                            }
                            createStockException(stock, stockOld);
                            stockService.delete(stock.getId());
                        }
                    }
                } else {
                    try {
                        Stock stock = stocks.get(0);
                        stock.setQuantity(stock.getQuantity().add(wmsStock.getQuantity().subtract(quantity)));
                        Stock stockOld = stockService.findById(stock.getId());
                        createStockException(stock, stockOld);
                        stock = updateStockLocation(wmsStock, stock);
                        stockService.save(stock);
                    } catch (IdNotFound idNotFound) {
                        LOGGER.error(idNotFound.getMessage());
                    }
                }

            } else {
                createStock(wmsStock);
            }
        }
        deleteNoneExistingContainer(wmsStocks);

    }

    private List<Stock> searchStock(WmsStock wmsStock) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String search = "product.code:" + wmsStock.getProductCode();

        search = search + ",container.code:" + wmsStock.getContainerCode();

        //search = search + ",location.code:" + wmsStock.getLocationCode();

        if (null != wmsStock.getBlockType() && !"".equals(wmsStock.getBlockType().trim()))
            search = search + ",blockType.code:" + wmsStock.getBlockType();

        if (null != wmsStock.getOwner_code() && !"".equals(wmsStock.getOwner_code().trim()))
            search = search + ",owner.code:" + wmsStock.getOwner_code();

        if (null != wmsStock.getDlc()) {
            c.setTime(wmsStock.getDlc());
            search = search + ",dlc:" + format.format(c.getTime());
        }

        if (null != wmsStock.getLot() && !"".equals(wmsStock.getLot().trim()))
            search = search + ",lot:" + wmsStock.getLot();

        if (null != wmsStock.getSerial_No() && !"".equals(wmsStock.getSerial_No().trim()))
            search = search + ",serialNo:" + wmsStock.getSerial_No();

        if (null != wmsStock.getUomCode() && !"".equals(wmsStock.getUomCode().trim()))
            search = search + ",uom.code:" + wmsStock.getUomCode();
        if (null != wmsStock.getSupplierCode() && !"".equals(wmsStock.getSupplierCode().trim()))
            search = search + ",supplier.code:" + wmsStock.getSupplierCode();
        try {
            return stockService.find(search);
        } catch (AttributesNotFound attributesNotFound) {
            LOGGER.error(attributesNotFound.getMessage());

            return null;
        } catch (ErrorType errorType) {
            LOGGER.error(errorType.getMessage());
            return null;
        }
    }

    private void createStockException(Stock stock, Stock stockOld) {
        com.sinno.ems.dto.Exception exception = null;
        try {
            exception = exceptionService.findById(8L);
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }
        StockException stockException = new StockException();
        stockException.setBlockTypeOld(stockOld.getBlockType());
        stockException.setException(exception);
        stockException.setColorOld(stockOld.getColor());
        stockException.setWeightOld(stockOld.getWeight());
        stockException.setWeightNew(stock.getWeight());
        stockException.setUpdateDateOld(stockOld.getUpdateDate());
        stockException.setUomOld(stockOld.getUom());
        stockException.setSupplierOld(stockOld.getSupplier());
        stockException.setSerialNoOld(stockOld.getSerialNo());
        stockException.setReceptionDateOld(stockOld.getReceptionDate());
        stockException.setQuantityOld(stockOld.getQuantity());
        stockException.setQuantityNew(stock.getQuantity());
        stockException.setQualityOld(stockOld.getQuality());
        stockException.setQualityNew(stock.getQuality());
        stockException.setProductOld(stockOld.getProduct());
        stockException.setOwner(stockOld.getOwner());
        stockException.setLotOld(stockOld.getLot());
        stockException.setContainerOld(stockOld.getContainer());
        stockException.setLocationOld(stockOld.getLocation());
        stockException.setKitOld(stockOld.getKit());
        stockException.setDluoOld(stockOld.getDluo());
        stockException.setDlcOld(stockOld.getDlc());
        stockException.setCreationDateOld(stock.getCreationDate());
        stockExceptionService.save(stockException);
    }

    private Container createContainer(String containerCode, Location location, Owner owner, Warehouse warehouse) {
        Container container = new Container();
        container.setCode(containerCode);
        container.setLocation(location);
        container.setOwner(owner);
        container.setWarehouse(warehouse);
        container.setCreationDate(EmsDate.getDateNow());
        container.setUpdateDate(EmsDate.getDateNow());
        container.setReceptionDate(EmsDate.getDateNow());
        try {
            return containerService.save(container);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    private void createStock(WmsStock wmsStock) throws AttributesNotFound, ErrorType, ProductControls {
        List<Product> products = productService.find("code:" + wmsStock.getProductCode());
        List<Uom> uoms = uomService.find("code:" + wmsStock.getUomCode());
        List<BlockType> blockTypes = blockTypeService.find("code:" + wmsStock.getBlockType());
        List<Location> locations = locationService.find("code:" + wmsStock.getLocationCode());
        List<Owner> owners = ownerService.find("code:" + wmsStock.getOwner_code());
        List<Container> containers = containerService.find("code:" + wmsStock.getContainerCode());
        List<Supplier> suppliers = supplierService.find("code:" + wmsStock.getSupplierCode());
        BlockType blockType = blockTypes.size() > 0 ? blockTypes.get(0) : null;
        Location location = locations.size() > 0 ? locations.get(0) : null;
        Owner owner = owners.size() > 0 ? owners.get(0) : null;
        Supplier supplier = suppliers.size() > 0 ? suppliers.get(0) : null;
        Warehouse warehouse = warehousSerivce.findAll().get(0);
        Container container = containers.size() > 0 ? containers.get(0) : createContainer(wmsStock.getContainerCode(), location, owner, warehouse);
        Product product = products.size() > 0 ? products.get(0) : null;
        Uom uom = uoms.size() > 0 ? uoms.get(0) : null;
        Stock stock = new Stock();
        stock.setBlockType(blockType);
        stock.setProduct(product);
        stock.setUom(uom);
        stock.setContainer(container);
        stock.setLocation(location);
        stock.setDlc(wmsStock.getDlc());
        stock.setSerialNo(wmsStock.getSerial_No());
        stock.setLot(wmsStock.getLot());
        stock.setQuantity(wmsStock.getQuantity());
        stock.setOwner(owner);
        stock.setCreationDate(EmsDate.getDateNow());
        stock.setUpdateDate(EmsDate.getDateNow());
        stock.setSupplier(supplier);
        try {
            stock = stockService.save(stock);
            createStockException(stock, stock);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    private Stock updateStockLocation(WmsStock wmsStock, Stock stock) {
        if (!stock.getLocation().equals(wmsStock.getLocationCode())) {
            List<Location> locations = null;
            try {
                locations = locationService.find("code:" + wmsStock.getLocationCode());

                List<Container> containers = containerService.find("code:" + wmsStock.getContainerCode());
                if (locations.size() > 0) {
                    stock.setLocation(locations.get(0));
                    if (containers.size() > 0) {
                        Container container = containers.get(0);
                        container.setLocation(locations.get(0));
                        containerService.save(container);
                    }
                }
            } catch (AttributesNotFound attributesNotFound) {
                attributesNotFound.printStackTrace();
            } catch (ErrorType errorType) {
                LOGGER.error(errorType.getMessage());
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
        return stock;
    }

    private void deleteNoneExistingContainer(List<WmsStock> wmsStocks) {
        List<Stock> all = null;
        try {
            all = stockService.findAll();

            boolean founded = false;
            for (Stock stock : all) {

                for (WmsStock wmsStock : wmsStocks) {
                    if (stock.getContainer().getCode().trim().equals(wmsStock.getContainerCode().trim())) {
                        founded = true;
                        break;
                    }
                }
                if (!founded) {
                    List<Stock> stocks = stockService.find("container.code:" + stock.getContainer().getCode());
                    for (Stock s : stocks) {
                        try {
                            stockService.delete(s.getId());
                        } catch (Exception e) {
                            break;
                        }
                    }
                }
            }
        } catch (AttributesNotFound attributesNotFound) {
            LOGGER.error(attributesNotFound.getMessage());
        } catch (ErrorType errorType) {
            LOGGER.error(errorType.getMessage());
        }
    }
}


