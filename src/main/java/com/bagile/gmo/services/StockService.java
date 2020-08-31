package com.bagile.gmo.services;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.exceptions.*;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface StockService {

    Stock save(Stock stock) throws IdNotFound, CustomException, AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    Stock findById(Long id) throws IdNotFound;

    Stock findOne(String search) throws AttributesNotFound, ErrorType;

    List<Stock> find(String search) throws AttributesNotFound, ErrorType;

    List<Stock> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id) throws IdNotFound;

    void delete(Stock stock);
    void deleteAll (List<Long> ids);

    List<Stock> findAll() throws AttributesNotFound, ErrorType;

    List<Stock> findAll(int page, int size) throws AttributesNotFound, ErrorType;

    Stock createStock(Stock stock, Uom uom, BigDecimal quantity, Location location, Container container, ProductPack productPack, Boolean accounted, BigDecimal salePrice) throws
            ProductControls, IdNotFound, CustomException, AttributesNotFound, ErrorType;
    Stock createStock(ReceptionStock receptionStock, Boolean accounted);
    List<Stock> searchStock(SaleOrderStock saleOrderStock);
   // List<Stock> searchStock(Task task);
    Stock createStock(SaleOrderStock saleOrderStock);
    //Stock createStock(Task task);

    List<Object[]> getProductQuantity(long warehouseId, long productId);

    List<Object[]> getProductQuantityLocation(long warehouseId, long productId, long locationId);

    Stock refreshStockQuantityForVariableWeightsProduct(Stock stock) throws IdNotFound, CustomException, AttributesNotFound, ErrorType;
    void generateStocks();
    void updateQuantity(Stock stock);
    Stock searchStock(Stock stock);

}