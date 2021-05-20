package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.StkStock;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.CustomException;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.StockMapper;
import com.bagile.gmo.repositories.StockRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService, AddActive {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private SettingService settingService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ContainerService containerService;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(StockService.class);
    @Autowired
    private ProductPackService productPackService;

    @Autowired
    private NotificationService notificationService;

    /**
     * create or updated stock
     * if stock exist already add quantity to the old stock
     *
     * @param stock
     * @return
     */
    @Override
    @Transactional
    public Stock save(Stock stock) throws IdNotFound, CustomException, AttributesNotFound, ErrorType {

        LOGGER.info("save Stock");
        stock.setUpdateDate(EmsDate.getDateNow());
       /* Stock stkFound = searchStock(stock);
        if (stkFound != null) {
            BigDecimal quantity = stock.getQuantity();
            if (stock.getId() > 0)
                delete(stock);
            stock = stkFound;
            stock.setQuantity(stock.getQuantity().add(quantity));
        }*/
        if (0 == stock.getId()) {
            stock.setCreationDate(EmsDate.getDateNow());
            if (!settingService.containerManagement()) {
                LOGGER.info(">Create a new Stock ");
                Container container = containerService.createContainer(stock);
                stock.setContainer(container);
            }
        }
        if (null == stock.getPurchasePrice())
            stock.setPurchasePrice(stock.getProduct().getPurshasePriceUB());
        updateQuantity(stock);

        if (stock.getProduct().getStockQuantity() == null) {
            stock.getProduct().setStockQuantity(BigDecimal.ZERO);
        }
        Notification notification = notificationService.findOne("productId:" + stock.getProduct().getId());
        if (notification != null) {
            if (stock.getProduct().getStockQuantity().compareTo(stock.getProduct().getMinStock()) <= 0) {
                notificationService.delete(notification.getId());

            }
        }


        return StockMapper.toDto(stockRepository.saveAndFlush(StockMapper.toEntity(stock, false)), false);
    }

    /**
     * get the size of the records in stock table
     *
     * @return
     */

    @Override
    public Long size() {
        return stockRepository.count();
    }

    /**
     * check if id exist in database
     *
     * @param id
     * @return
     */
    @Override
    public Boolean isExist(Long id) {
        return stockRepository.existsById(id);
    }

    /**
     * find entity by id
     *
     * @param id
     * @return the entity if found
     * @throws IdNotFound
     */
    @Override
    public Stock findById(Long id) throws IdNotFound {
        return StockMapper.toDto(stockRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }

    /**
     * find only one entity
     *
     * @param search query
     * @return Stock
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public Stock findOne(String search) throws AttributesNotFound, ErrorType {
        return StockMapper.toDto(stockRepository.findOne(Search.expression (search, StkStock.class)).orElseThrow (() -> new AttributesNotFound (search)), false);
    }

    /**
     * find list of stocks
     *
     * @param search query
     * @return List<Stock>
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public List<Stock> find(String search) throws AttributesNotFound, ErrorType {

        if (search.equals("")){
            return findAll ();
        }
        return StockMapper.toDtos(stockRepository.findAll(Search.expression(search, StkStock.class)), false);



    }

    /**
     * find list of accounts with pagination
     *
     * @param search query
     * @param page   page number
     * @param size   size of the page
     * @return List<Stock>
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public List<Stock> find(String search, int page, int size) throws AttributesNotFound, ErrorType {

        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return StockMapper.toDtos(stockRepository.findAll(Search.expression(search, StkStock.class), pageable), false);
    }

    /**
     * get the size of records for a search query
     *
     * @param search search query
     * @return Long
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return stockRepository.count(Search.expression(search, StkStock.class));
    }

    /**
     * delete a record on the database
     *
     * @param id the id that will be deleted
     */
    @Override
    public void delete(Long id) throws IdNotFound {
        LOGGER.info("delete Stock");
        delete(findById(id));
    }

    /**
     * delete a record on the database
     *
     * @param stock the stock that will be deleted
     */
    @Override
    public void delete(Stock stock) {

        stock.setActive(false);
        stock.setSalePrice(BigDecimal.ZERO);
        stockRepository.saveAndFlush(StockMapper.toEntity(stock, false));
    }

    /**
     * get all the records from the database
     *
     * @return List<Stock>
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public List<Stock> findAll() {
        return StockMapper.toDtos(stockRepository.findAll(), false);
    }

    @Override
    public List<Stock> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return StockMapper.toDtos(stockRepository.findAll(pageable), false);
    }

    /**
     * get all the records from the database with pagination
     *

     * @return List<Account>
     * @throws AttributesNotFound
     * @throws ErrorType
     */



    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            stockRepository.deleteById(id);        }
    }

    /**
     * this function is used to create stock
     *
     * @param stock     the stock to clone
     * @param uom       the new uom
     * @param quantity  the new quantity
     * @param location  the location
     * @param container container
     * @return the created container
     * @throws IdNotFound
     */
    @Override
    public Stock createStock(Stock stock, Uom uom, BigDecimal quantity, Location location, Container container, ProductPack productPack, Boolean accounted, BigDecimal salePrice) throws
            IdNotFound, CustomException, AttributesNotFound, ErrorType {

        Stock stk = null;
        try {
            stk = EmsClone.clone(stock, Stock.class);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        stk.setId(0);
        stk.setUom(uom);
        stk.setProductPack(productPack);
        stk.setLocation(location);
//        stk.setWarehouse(location.getWarehouse());
        stk.setQuantity(quantity);
        stk.setAccountedSale(accounted);
        stk.setActive(false);
        stk.setContainer(container);
        stk.setSalePrice(salePrice);
        return save(stk);
    }

    /**
     * create sotck from reception stock
     *
     * @param receptionStock
     * @return
     */
    @Override
    public Stock createStock(ReceptionStock receptionStock, Boolean accounted) {
        LOGGER.info("> Creating Stock");
        Stock stock = new Stock();
        stock.setContainer(receptionStock.getContainer());
        stock.setBlockType(receptionStock.getBlockType());
        stock.setQuantity(receptionStock.getQuantityReceived());
        stock.setOwner(receptionStock.getOwner());
        stock.setProduct(receptionStock.getProduct());
        stock.setUom(receptionStock.getUom());
        stock.setDluo(receptionStock.getDluo());
        stock.setSupplier(receptionStock.getReception().getSupplier());
        stock.setReceptionDate(receptionStock.getReceptionDate());
        stock.setUpdateDate(EmsDate.getDateNow());
        stock.setDlc(receptionStock.getDlc());
        stock.setProductPack(receptionStock.getProductPack());
       // stock.setProductDimension(receptionStock.getProductDimension());
        stock.setWarehouse(receptionStock.getWarehouse());
        stock.setSerialNo(receptionStock.getSerialNo());
        stock.setLot(receptionStock.getLot());
        stock.setColor(receptionStock.getColor());
        stock.setAccountedPurchase(receptionStock.getReception().getAccounted());
        stock.setReceptionLine(receptionStock.getReceptionLine());
        stock.setLocation(receptionStock.getLocation());
        stock.setPurchasePrice(receptionStock.getReceptionLine().getPurshasePrice());
        LOGGER.info("> Stock Created");
        return stock;
    }

    /**
     * search stock based on saleOrderStock properties
     *
     * @param maintenanceStock
     * @return the list of stocks founded
     */
    @Override
    public List<Stock> searchStock(MaintenanceStock maintenanceStock) {
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            StringBuffer search = new StringBuffer();
            search.append("active:true,");
            if (null != maintenanceStock.getProduct()) {
                search.append("product.id:");
                search.append(maintenanceStock.getProduct().getId());
            } else {
                throw new RuntimeException("Can not search a stock without product :p");
            }
            if (null != maintenanceStock.getOwner()) {
                search.append(",owner.id:");
                search.append(maintenanceStock.getOwner().getId());
            }
            if (maintenanceStock.getBlockType() != null) {
                search.append(",blockType.id:");
                search.append(maintenanceStock.getBlockType().getId());
            }
            if (maintenanceStock.getContainerSource() != null && settingService.containerManagement()) {
                search.append(",container.code:");
                search.append(maintenanceStock.getContainerSource());
            }
            if (maintenanceStock.getDlc() != null) {
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(maintenanceStock.getDlc());
                search.append(",dlc:");
                search.append(dateFormat.format(calendar1.getTime()));
            }

            if (maintenanceStock.getColor() != null) {
                search.append(",color.id:");
                search.append(maintenanceStock.getColor().getId());
            }
            if (maintenanceStock.getDluo() != null) {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(maintenanceStock.getDluo());
                search.append(",dluo:");
                search.append(dateFormat.format(calendar2.getTime()));
            }
            if (maintenanceStock.getLot() != null && !maintenanceStock.getLot().trim().equals("")) {
                search.append(",lot:");
                search.append(maintenanceStock.getLot());
            }
            if (maintenanceStock.getWeight() != null) {
                search.append(",weight:");
                search.append(maintenanceStock.getWeight());
            }
            if (maintenanceStock.getQuality() != null) {
                search.append(",quality:");
                search.append(maintenanceStock.getQuality());
            }
           /* if (saleOrderStock.getProductDimension() != null) {
                search.append(",productDimension.id:");
                search.append(saleOrderStock.getProductDimension().getId());
            }*/
            if (maintenanceStock.getWarehouse() != null) {
                search.append(",warehouse.id:");
                search.append(maintenanceStock.getWarehouse().getId());
            }
         //   if (maintenanceStock.getMaintenance().geta() != null && maintenanceStock.getDelivery().getAccounted()) {
          //      search.append(",accountedPurchase:true");

          //  }
            return find(search.toString());
        } catch (AttributesNotFound | ErrorType | RuntimeException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    /***
     * search stock based on existing stock
     * @param stock
     * @return
     */
    @Override
    public Stock searchStock(Stock stock) {
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            StringBuffer search = new StringBuffer();
            if (null != stock.getProduct()) {
                search.append("product.id:");
                search.append(stock.getProduct().getId());
            }
            if (null != stock.getOwner()) {
                search.append(",owner.id:");
                search.append(stock.getOwner().getId());
            }
            if (stock.getBlockType() != null) {
                search.append(",blockType.id:");
                search.append(stock.getBlockType().getId());
            }
            if (stock.getContainer() != null) {
                search.append(",container.code:");
                search.append(stock.getContainer().getCode());
            }
            if (stock.getDlc() != null) {
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(stock.getDlc());
                search.append(",dlc:");
                search.append(dateFormat.format(calendar1.getTime()));
            }

            if (stock.getColor() != null) {
                search.append(",color.id:");
                search.append(stock.getColor().getId());
            }
            if (stock.getDluo() != null) {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(stock.getDluo());
                search.append(",dluo:");
                search.append(dateFormat.format(calendar2.getTime()));
            }
            if (stock.getLot() != null && !stock.getLot().trim().equals("")) {
                search.append(",lot:");
                search.append(stock.getLot());
            }
            if (stock.getWeight() != null) {
                search.append(",weight:");
                search.append(stock.getWeight());
            }
            if (stock.getQuality() != null) {
                search.append(",quality:");
                search.append(stock.getQuality());
            }
           /* if (stock.getProductDimension() != null) {
                search.append(",productDimension.id:");
                search.append(stock.getProductDimension().getId());
            }*/
            if (stock.getWarehouse() != null) {
                search.append(",warehouse.id:");
                search.append(stock.getWarehouse().getId());
            }
            if (stock.getAccountedPurchase() != null) {
                search.append(",accountedPurchase:");
                search.append(stock.getAccountedPurchase());
            }
            if (stock.getAccountedSale() != null) {
                search.append(",accountedSale:");
                search.append(stock.getAccountedSale());
            }
            if (stock.getActive() != null) {
                search.append(",active:");
                search.append(stock.getActive());
            }
            List<Stock> stocks = find(search.toString());
            for (Stock stkFound : stocks) {
                if (EmsComprator.compare(stkFound.getBlockType(), stock.getBlockType())
                        && !EmsComprator.compare(stkFound, stock)
                        && EmsComprator.compare(stkFound.getDlc(), stock.getDlc())
                        && EmsComprator.compare(stkFound.getDluo(), stock.getDluo())
                        && EmsComprator.compare(stkFound.getLot(), stock.getLot())
                        && EmsComprator.compare(stkFound.getWeight(), stock.getWeight())
                        && EmsComprator.compare(stkFound.getQuality(), stock.getQuality())
                        && EmsComprator.compare(stkFound.getProduct(), stock.getProduct())
                        && EmsComprator.compare(stkFound.getSerialNo(), stock.getSerialNo())
                        && EmsComprator.compare(stkFound.getColor(), stock.getColor())
                       // && EmsComprator.compare(stkFound.getProductDimension(), stock.getProductDimension())
                        && EmsComprator.compare(stkFound.getContainer(), stock.getContainer())
                        && EmsComprator.compare(stkFound.getWarehouse(), stock.getWarehouse())
                ) {
                    return stkFound;
                }
            }
        } catch (AttributesNotFound | ErrorType e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
        return null;
    }


    @Override
    public Stock createStock(MaintenanceStock maintenanceStock) {


        List<Container> containers = null;
        try {
            containers = containerService.find("code:" + maintenanceStock.getContainerSource());
        } catch (AttributesNotFound | ErrorType e) {
            LOGGER.error(e.getMessage(), e);
        }
        if (containers != null && containers.size() > 0) {
            containers = containers.stream().filter(container -> container.getOutBoundDate() == null).collect(Collectors.toList());
        }
        Container container = null;
        if (containers != null && containers.size() > 0) {
            container = containers.get(0);
        } else {
            container = containerService.createContainer(maintenanceStock);
            container.setOutBoundDate(null);
            container = containerService.save(container);
        }


        Stock stock = new Stock();
        stock.setBlockType(maintenanceStock.getBlockType());
        stock.setProduct(maintenanceStock.getProduct());
        stock.setUom(maintenanceStock.getUom());
        stock.setContainer(container);
        stock.setLocation(container.getLocation());
        stock.setProductPack(maintenanceStock.getProductPack());
        stock.setDlc(maintenanceStock.getDlc());
        stock.setDluo(maintenanceStock.getDluo());
        stock.setSerialNo(maintenanceStock.getSerialNo());
        stock.setLot(maintenanceStock.getLot());
        stock.setWeight(maintenanceStock.getWeight());
        stock.setQuality(maintenanceStock.getQuality());
       // stock.setProductDimension(saleOrderStock.getProductDimension());
        stock.setQuantity(maintenanceStock.getQuantityServed());
        stock.setOwner(maintenanceStock.getOwner());
        stock.setWarehouse(maintenanceStock.getWarehouse());
        stock.setProductPack(maintenanceStock.getProductPack());
        stock.setCreationDate(EmsDate.getDateNow());
        stock.setUpdateDate(EmsDate.getDateNow());
        stock.setSalePrice(maintenanceStock.getActionLineMaintenance().getUnitPrice());
       // stock.setAccountedPurchase(maintenanceStock.getMaintenance().geta());
        try {
            save(stock);
        } catch (IdNotFound e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        } catch (CustomException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }
        return stock;
    }

    @Override
    public void updateQuantity(Stock stock) {
        Stock oldStock = null;


        ProductPack productPack = null;
        try {
            productPack = productPackService.findById(stock.getProductPack().getId());

            if (stock.getId() > 0) {
                oldStock = findById(stock.getId());
                if (null != productPack && stock.getQuantityUomBase().compareTo(oldStock.getQuantityUomBase()) != 0) {
                    stock.setQuantity(stock.getQuantityUomBase().divide(productPack.getQuantity()));
                } else {
                    stock.setQuantityUomBase(stock.getQuantity().multiply(productPack.getQuantity()));
                }
            } else {
                if (stock.getQuantity() != null)
                    stock.setQuantityUomBase(stock.getQuantity().multiply(productPack.getQuantity()));
                else
                    stock.setQuantity(stock.getQuantityUomBase().divide(productPack.getQuantity()));

            }
            if(stock.getQuantity().compareTo(BigDecimal.ZERO)==0){
                stock.setActive(false);
            }
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }

    }

    @Override
    public void generateStocks() {
        List<Product> products = null;
        try {
            products = productService.findAll();

            Warehouse warehouse = new Warehouse();
            warehouse.setId(1);
            Location location = new Location();
            location.setId(12600);
            for (Product product : products) {
                Stock stock = new Stock();
                stock.setProduct(product);
                stock.setWarehouse(warehouse);
                stock.setOwner(product.getOwner());
                stock.setAccountedSale(true);
                stock.setActive(true);
                stock.setUom(product.getUomByProductUomBase());
                stock.setProductPack(product.getProductPack());
                stock.setQuantity(BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(5, 1000 + 1)));
                stock.setLocation(location);
                stock.setContainer(containerService.createContainer(stock));
                save(stock);
            }
        } catch (AttributesNotFound | ErrorType | IdNotFound | CustomException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Object[]> getProductQuantity(long warehouseId, long productId) {
        return stockRepository.getProductQuantity(warehouseId, productId);
    }

    @Override
    public List<Object[]> getProductQuantityLocation(long warehouseId, long productId, long locationId) {
        return stockRepository.getProductQuantityLocation(warehouseId, productId, locationId);
    }


    @Override
    public Stock refreshStockQuantityForVariableWeightsProduct(Stock stock) throws IdNotFound, CustomException, AttributesNotFound, ErrorType {
        Stock oldStock = findById(stock.getId());
        BigDecimal oldStockPurchasePrice = oldStock.getPurchasePrice();
        stock.setPurchasePrice(oldStockPurchasePrice.multiply(oldStock.getQuantity().divide(stock.getQuantity(), 2, BigDecimal.ROUND_HALF_UP)));
        stock.setAppliedBruteToNet(true);
        return save(stock);
    }

    @Override
    public String addActiveToSearch(String search) {
        return null;
    }
}