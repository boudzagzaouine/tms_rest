package com.bagile.gmo.services;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.exceptions.*;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface ReceptionStockService {

    ReceptionStock save(ReceptionStock receptionStock) throws AttributesNotFound, ErrorType, ContainerException, ProductControls, IdNotFound, CustomException;

    Long size();

    Boolean isExist(Long id);

    ReceptionStock findById(Long id) throws IdNotFound;

    ReceptionStock findOne(String search) throws AttributesNotFound, ErrorType;

    List<ReceptionStock> find(String search) throws AttributesNotFound, ErrorType;

    List<ReceptionStock> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ReceptionStock receptionStock);

    List<ReceptionStock> findAll();

    List<ReceptionStock> findAll(int page, int size);

    Container checkContainer(ReceptionStock receptionStock);

    List<ReceptionStock> saveAll(List<ReceptionStock> receptionStockList, boolean fromPos);

    ReceptionLine updateReceptionStock(ReceptionLine receptionLine) throws AttributesNotFound, ErrorType, IdNotFound, CustomException, ProductControls, ContainerException;

    public void deleteAll(List<Long> ids) ;
    Boolean checkStatus(ReceptionLine receptionLine);
    ReceptionLine createReceptionLine(ReceptionStock receptionStock, BigDecimal quantity);
    Stock checkStock(ReceptionStock receptionStock);
    ReceptionLine compareRlineRStock(ReceptionLine receptionLine, ReceptionStock receptionStock);
    ReceptionLine checkUom(ReceptionStock receptionStock, ReceptionLine receptionLine);
    PurshaseOrderLine checkUomPurshaseOrderLine(ReceptionStock receptionStock, PurshaseOrderLine purshaseOrderLine);
}