package com.bagile.gmo.services;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ContainerException;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContainerService {

    Container save(Container container);

    Long size();

    Boolean isExist(Long id);

    Container findById(Long id) throws IdNotFound;

    Container findOne(String search) throws AttributesNotFound, ErrorType, ErrorType;

    Container findByCode(String code);

    List<Container> find(String search) throws AttributesNotFound, ErrorType;

    List<Container> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Container container);

    List<Container> findAll();

    List<Container> findAll(Pageable pageable);

    String getNextVal();

    //Create container for SaleOrderStock
    Container createContainer(SaleOrderStock saleOrderStock);

    //Create Container for DeliveryLine
    Container createContainer(DeliveryLine deliveryLine);

    Container createContainer(Stock stock) throws IdNotFound, AttributesNotFound, ErrorType;

    Container setOutBoundDate(SaleOrderStock saleOrderStock) throws IdNotFound;

    Container createContainer(ReceptionStock receptionStock) throws AttributesNotFound, ErrorType, ContainerException;

    Container createContainer(SaleOrderLine saleOrderLine);

    void archiveContainer(Container container);
}