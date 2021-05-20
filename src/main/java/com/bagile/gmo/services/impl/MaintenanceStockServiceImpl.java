package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.GmoMaintenanceStock;
import com.bagile.gmo.exceptions.*;
import com.bagile.gmo.mapper.MaintenanceStockMapper;
import com.bagile.gmo.repositories.MaintenanceStockRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.EmsClone;
import com.bagile.gmo.util.EmsComprator;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MaintenanceStockServiceImpl implements MaintenanceStockService {

    @Autowired
    private MaintenanceStockRepository maintenanaceStockRepository;


    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private MaintenanceStateService maintenanceStateService;
    @Autowired
    private ActionLineMaintenanceService actionLineMaintenanceService;

    @Autowired
    private SettingService settingService;
    @Autowired
    private ContainerService containerService;

    @Autowired
    private StockService stockService;
    @Autowired
    private ProductService productService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private DieselDeclarationService dieselDeclarationService;


    private final static Logger LOGGER = LoggerFactory
            .getLogger(MaintenanceStockService.class);

    @Override
    @Transactional
    public MaintenanceStock save(MaintenanceStock maintenanceStock) throws ProductControls, IdNotFound {
        LOGGER.info("Deliver one deliveryLine");

           // if (settingService.posCanStockBeNegative()) {
        if(maintenanceStock.getMaintenance() != null) {
            return actionStockProduct(maintenanceStock);
        }
        else{
            return actionStockProductwithDeclarationGasoil(maintenanceStock);
        }
           // } else return actionStockProduct(maintenanceStock);

    }

    //clone saleOrder stock and modifying the quantity and the stock
    private MaintenanceStock copyMaintenanceStock(MaintenanceStock maintenanceStock, BigDecimal quantity, Stock stock) {
        MaintenanceStock orderStock = null;
        try {
            orderStock = EmsClone.clone(maintenanceStock, MaintenanceStock.class);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        orderStock.setId(0);
        orderStock.setQuantityServed(quantity);
        orderStock.setStock(stock);
        return MaintenanceStockMapper.toDto(maintenanaceStockRepository.saveAndFlush(MaintenanceStockMapper.toEntity(orderStock, false)), false);

    }

    //this function is used to check the source container
    private boolean checkContainerSource(MaintenanceStock maintenanceStock, Stock stock) {

        if (null != maintenanceStock.getContainerSource() && !"".equals(maintenanceStock.getContainerSource())) {
            return EmsComprator.compare(maintenanceStock.getContainerSource(), stock.getContainer().getCode());
        } else
            return true;
    }

    @Override
    public Long size() {
        return maintenanaceStockRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return maintenanaceStockRepository.existsById(id);
    }

    @Override
    public MaintenanceStock findById(Long id) throws IdNotFound {
        return MaintenanceStockMapper.toDto(maintenanaceStockRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }

    @Override
    public MaintenanceStock findOne(String search) throws AttributesNotFound, ErrorType {
        return null ;//MaintenanceStockMapper.toDto(maintenanaceStockRepository.findOne(Search.expression(search, GmoMaintenanceStock.class)), false);
    }

    @Override
    public List<MaintenanceStock> find(String search) throws AttributesNotFound, ErrorType {
        return MaintenanceStockMapper.toDtos(maintenanaceStockRepository.findAll(Search.expression(search, GmoMaintenanceStock.class)), false);
    }

    @Override
    public List<MaintenanceStock> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return MaintenanceStockMapper.toDtos(maintenanaceStockRepository.findAll(Search.expression(search, GmoMaintenanceStock.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return maintenanaceStockRepository.count(Search.expression(search, GmoMaintenanceStock.class));
    }

    @Override
    public void delete(Long id) {
        maintenanaceStockRepository.deleteById(id);
    }

    @Override
    public void delete(MaintenanceStock maintenanceStock) {
        maintenanaceStockRepository.delete(MaintenanceStockMapper.toEntity(maintenanceStock, false));
    }

    @Override
    public List<MaintenanceStock> findAll() {
        return MaintenanceStockMapper.toDtos(maintenanaceStockRepository.findAll(), false);
    }

    @Override
    public List<MaintenanceStock> findAll(Pageable pageable) {
        return MaintenanceStockMapper.toDtos(maintenanaceStockRepository.findAll(pageable), false);
    }


    @Override
    public List<MaintenanceStock> saveAll(List<MaintenanceStock> saleOrderStockList) {
        List<MaintenanceStock> saleOrderStocks = new ArrayList<>();
        saleOrderStockList.stream().forEach(sos -> {
            try {
                MaintenanceStock savedMaintenanceStock = save(sos);
                if (savedMaintenanceStock != null) {
                    saleOrderStocks.add(savedMaintenanceStock);
                }
            } catch (ProductControls | IdNotFound   e) {
                LOGGER.error(e.getMessage(), e);
            }
        });
        return saleOrderStocks;
    }


    /**
     * deliver non stocked Product
     *
     * @param maintenanceStock
     * @return maintenanceStock
     * @throws AttributesNotFound
     * @throws ErrorType
     */

    /**
     * deliver sotcked product
     *
     * @param maintenanceStock
     * @return maintenanceStock
     * @throws IdNotFound
     * @throws ProductControls
     */
    private MaintenanceStock actionStockProduct(MaintenanceStock maintenanceStock) throws IdNotFound {
        ActionLineMaintenance actionLineMaintenance = actionLineMaintenanceService.findById(maintenanceStock.getActionLineMaintenance().getId());

        Boolean accounted = null;

        if (maintenanceStock.getOrderDate() == null) {
            maintenanceStock.setOrderDate(EmsDate.getDateNow());
        }
        maintenanceStock.setUpdateDate(EmsDate.getDateNow());
        if (0 >= maintenanceStock.getId()) {
            maintenanceStock.setCreationDate(EmsDate.getDateNow());
        }
        try {
           // if(actionLineMaintenance.getMaintenanceState().getId() != 4 ) {
                //search stock with the same informations of maintenanceStock
                List<Stock> stocks = stockService.searchStock(maintenanceStock);
                if (stocks == null || stocks.isEmpty()) {
                    LOGGER.info("stock to deliver not found  in maintenanceStock");
                    throw new RuntimeException("Stock to deliver not found for maintenanceStock");

                }
                boolean found = false;
                BigDecimal quantityServed = maintenanceStock.getQuantityServed();
                BigDecimal allReadyServerd = BigDecimal.ZERO;
                for (int i = 0; i < stocks.size(); i++) {
                    Stock stock = stocks.get(i);
                    if (EmsComprator.compare(maintenanceStock.getBlockType(), stock.getBlockType())
                            && (!settingService.dlcManagement() || EmsComprator.compare(maintenanceStock.getDlc(), stock.getDlc()))
                            // && (!settingService.dluoManagement() || EmsComprator.compare(maintenanceStock.getDluo(), stock.getDluo()))
                            //&& (!settingService.lotManagement() || EmsComprator.compare(maintenanceStock.getLot(), stock.getLot()))
                            && (!settingService.weightManagement() || EmsComprator.compare(maintenanceStock.getWeight(), stock.getWeight()))
                            //&& (!settingService.qualityManagement() || EmsComprator.compare(maintenanceStock.getQuality(), stock.getQuality()))
                            && EmsComprator.compare(maintenanceStock.getProduct(), stock.getProduct())
                            && (!settingService.serialNumberManagement() || EmsComprator.compare(maintenanceStock.getSerialNo(), stock.getSerialNo()))
                            //&& (!settingService.colorManagement() || EmsComprator.compare(maintenanceStock.getColor(), stock.getColor()))
                            //  && (!settingService.dimensionManagement() || EmsComprator.compare(maintenanceStock.getProductDimension(), stock.getProductDimension()))
                            && checkContainerSource(maintenanceStock, stock)
                    ) {
                        BigDecimal convertedStockQuantity = productService.convertQuantityByUom(stock.getQuantity(), maintenanceStock.getProductPack(), stock.getProductPack());
                        Container container = null;
                        if (maintenanceStock.getContainer() != null)
                            container = containerService.findOne("code:" + maintenanceStock.getContainer().getCode());
                        if (null == container) {
                            container = containerService.createContainer(maintenanceStock);
                            maintenanceStock.setContainer(container);
                        } else {
                            maintenanceStock.setContainer(container);
                        }
                        found = true;
                        if (convertedStockQuantity.compareTo(quantityServed) < 0) {
                            quantityServed = quantityServed.subtract(convertedStockQuantity);
                            stock.setSalePrice(actionLineMaintenance.getUnitPrice());
                            stock.setActive(false);
                            allReadyServerd = allReadyServerd.add(convertedStockQuantity);
                            MaintenanceStock maintenanceStock1 = copyMaintenanceStock(maintenanceStock, convertedStockQuantity, stock);
                            if (i == stocks.size() - 1)
                                //maintenanceStock.setQuantityServed(quantityServed);

                                maintenanceStock = maintenanceStock1;

                        } else if (convertedStockQuantity.compareTo(quantityServed) == 1) {
                            Stock stockForMaintenance = stockService.createStock(stock, maintenanceStock.getUom(), quantityServed, maintenanceStock.getLocation(), container, maintenanceStock.getProductPack(), accounted, actionLineMaintenance.getUnitPrice());
                            maintenanceStock.setStock(stockForMaintenance);
                            BigDecimal convertedQuantityServed = productService.convertQuantityByUom(quantityServed, stock.getProductPack(), maintenanceStock.getProductPack());
                            stock.setQuantity(stock.getQuantity().subtract(convertedQuantityServed));
                            maintenanceStock.setQuantityServed(quantityServed);
                            allReadyServerd = allReadyServerd.add(quantityServed);
                            quantityServed = BigDecimal.ZERO;
                            maintenanceStock = MaintenanceStockMapper.toDto(maintenanaceStockRepository.saveAndFlush(MaintenanceStockMapper.toEntity(maintenanceStock, false)), false);

                        } else {
                            maintenanceStock.setStock(stock);
                            maintenanceStock.setQuantityServed(quantityServed);
                            allReadyServerd = allReadyServerd.add(quantityServed);
                            quantityServed = BigDecimal.ZERO;
                            stock.setActive(false);
                            stock.setSalePrice(actionLineMaintenance.getUnitPrice());
                            maintenanceStock = MaintenanceStockMapper.toDto(maintenanaceStockRepository.saveAndFlush(MaintenanceStockMapper.toEntity(maintenanceStock, false)), false);
                        }
                        if (null != stock.getContainer()) {
                            stock.setContainer(containerService.setOutBoundDate(maintenanceStock));
                        }
                        // stock.setAccountedSale(accounted);


                        stock = stockService.save(stock);
                        //receptionLineService.closeReceptionLineWhenUsingStock(stock);
                        if (0 == quantityServed.compareTo(BigDecimal.ZERO)) {
                            break;
                        }
                    }
                }
                // modifier status action line et save
                long id =4;
                MaintenanceState maintenanceState= maintenanceStateService.findById(id);
                //actionLineMaintenance.setMaintenanceState(maintenanceState);
                actionLineMaintenanceService.save(actionLineMaintenance);
                ActionLineMaintenance actionLineMaintenancee = null;
                if (found) {
                    BigDecimal subtract = allReadyServerd.subtract(quantityServed);
                    actionLineMaintenancee = actionLineMaintenanceService.findById(actionLineMaintenance.getId());
                    maintenanceService.updateMaintenance(actionLineMaintenancee.getMaintenance());
                }
           // }
        } catch (ProductControls | IdNotFound | AttributesNotFound | ErrorType | CustomException  e) {
            LOGGER.error(e.getMessage(), e);
        }
        return maintenanceStock;
    }
    //this is customized to bcgs projet




    private MaintenanceStock actionStockProductwithDeclarationGasoil(MaintenanceStock maintenanceStock) throws IdNotFound {


        DieselDeclaration dieselDeclaration = dieselDeclarationService.findById(maintenanceStock.getDieselDeclaration().getId());

        Boolean accounted = null;

        if (maintenanceStock.getOrderDate() == null) {
            maintenanceStock.setOrderDate(EmsDate.getDateNow());
        }
        maintenanceStock.setUpdateDate(EmsDate.getDateNow());
        if (0 >= maintenanceStock.getId()) {
            maintenanceStock.setCreationDate(EmsDate.getDateNow());
        }
        try {
            // if(actionLineMaintenance.getMaintenanceState().getId() != 4 ) {
            //search stock with the same informations of maintenanceStock
            List<Stock> stocks = stockService.searchStock(maintenanceStock);
            if (stocks == null || stocks.isEmpty()) {
                LOGGER.info("stock to deliver not found  in maintenanceStock");
                throw new RuntimeException("Stock to deliver not found for maintenanceStock");
            }
            boolean found = false;
            BigDecimal quantityServed =  maintenanceStock.getQuantityServed();
            BigDecimal allReadyServerd = BigDecimal.ZERO;
            for (int i = 0; i < stocks.size(); i++) {
                Stock stock = stocks.get(i);
                if (EmsComprator.compare(maintenanceStock.getBlockType(), stock.getBlockType())
                        && (!settingService.dlcManagement() || EmsComprator.compare(maintenanceStock.getDlc(), stock.getDlc()))
                        // && (!settingService.dluoManagement() || EmsComprator.compare(maintenanceStock.getDluo(), stock.getDluo()))
                        //&& (!settingService.lotManagement() || EmsComprator.compare(maintenanceStock.getLot(), stock.getLot()))
                        && (!settingService.weightManagement() || EmsComprator.compare(maintenanceStock.getWeight(), stock.getWeight()))
                        //&& (!settingService.qualityManagement() || EmsComprator.compare(maintenanceStock.getQuality(), stock.getQuality()))
                        && EmsComprator.compare(maintenanceStock.getProduct(), stock.getProduct())
                        && (!settingService.serialNumberManagement() || EmsComprator.compare(maintenanceStock.getSerialNo(), stock.getSerialNo()))
                        //&& (!settingService.colorManagement() || EmsComprator.compare(maintenanceStock.getColor(), stock.getColor()))
                        //  && (!settingService.dimensionManagement() || EmsComprator.compare(maintenanceStock.getProductDimension(), stock.getProductDimension()))
                        && checkContainerSource(maintenanceStock, stock)
                ) {
                    BigDecimal convertedStockQuantity = productService.convertQuantityByUom(stock.getQuantity(), maintenanceStock.getProductPack(), stock.getProductPack());
                    Container container = null;
                    if (maintenanceStock.getContainer() != null)
                        container = containerService.findOne("code:" + maintenanceStock.getContainer().getCode());
                    if (null == container) {
                        container = containerService.createContainer(maintenanceStock);
                        maintenanceStock.setContainer(container);
                    } else {
                        maintenanceStock.setContainer(container);
                    }
                    found = true;
                    if (convertedStockQuantity.compareTo(quantityServed) < 0) {
                        quantityServed = quantityServed.subtract(convertedStockQuantity);
                        stock.setSalePrice(dieselDeclaration.getAmount());
                        stock.setActive(false);
                        allReadyServerd = allReadyServerd.add(convertedStockQuantity);
                        MaintenanceStock maintenanceStock1 = copyMaintenanceStock(maintenanceStock, convertedStockQuantity, stock);
                        if (i == stocks.size() - 1)
                            //maintenanceStock.setQuantityServed(quantityServed);

                            maintenanceStock = maintenanceStock1;

                    } else if (convertedStockQuantity.compareTo(quantityServed) == 1) {
                        Stock stockForMaintenance = stockService.createStock(stock, maintenanceStock.getUom(), quantityServed, maintenanceStock.getLocation(), container, maintenanceStock.getProductPack(), accounted, dieselDeclaration.getAmount());
                        maintenanceStock.setStock(stockForMaintenance);
                        BigDecimal convertedQuantityServed = productService.convertQuantityByUom(quantityServed, stock.getProductPack(), maintenanceStock.getProductPack());
                        stock.setQuantity(stock.getQuantity().subtract(convertedQuantityServed));
                        maintenanceStock.setQuantityServed(quantityServed);
                        allReadyServerd = allReadyServerd.add(quantityServed);
                        quantityServed = BigDecimal.ZERO;
                        maintenanceStock = MaintenanceStockMapper.toDto(maintenanaceStockRepository.saveAndFlush(MaintenanceStockMapper.toEntity(maintenanceStock, false)), false);

                    } else {
                        maintenanceStock.setStock(stock);
                        maintenanceStock.setQuantityServed(quantityServed);
                        allReadyServerd = allReadyServerd.add(quantityServed);
                        quantityServed = BigDecimal.ZERO;
                        stock.setActive(false);
                        stock.setSalePrice(dieselDeclaration.getAmount());
                        maintenanceStock = MaintenanceStockMapper.toDto(maintenanaceStockRepository.saveAndFlush(MaintenanceStockMapper.toEntity(maintenanceStock, false)), false);
                    }
                    if (null != stock.getContainer()) {
                        stock.setContainer(containerService.setOutBoundDate(maintenanceStock));
                    }
                    // stock.setAccountedSale(accounted);


                    stock = stockService.save(stock);
                    //receptionLineService.closeReceptionLineWhenUsingStock(stock);
                    if (0 == quantityServed.compareTo(BigDecimal.ZERO)) {
                        break;
                    }
                }
            }
            // modifier status action line et save
            long id =4;
          //  MaintenanceState maintenanceState= maintenanceStateService.findById(id);
            //actionLineMaintenance.setMaintenanceState(maintenanceState);
          //  actionLineMaintenanceService.save(actionLineMaintenance);
          //  ActionLineMaintenance actionLineMaintenancee = null;
            if (found) {
                BigDecimal subtract = allReadyServerd.subtract(quantityServed);
               // actionLineMaintenancee = actionLineMaintenanceService.findById(actionLineMaintenance.getId());
               // maintenanceService.updateMaintenance(actionLineMaintenancee.getMaintenance());
            }
            // }
        } catch (ProductControls | IdNotFound | AttributesNotFound | ErrorType | CustomException  e) {
            LOGGER.error(e.getMessage(), e);
        }
        return maintenanceStock;
    }
















}