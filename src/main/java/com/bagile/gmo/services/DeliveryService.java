package com.bagile.tms.services;

import com.bagile.gmo.dto.Delivery;
import com.bagile.gmo.dto.SaleOrder;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.CustomException;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import org.springframework.data.domain.Pageable;

import java.util.List;


public interface DeliveryService  {
    Delivery save(Delivery delivery);


    Long size();

    Boolean isExist(Long id);

    Delivery findById(Long id) throws IdNotFound;

    Delivery findOne(String search) throws AttributesNotFound, ErrorType;

    List<Delivery> find(String search) throws AttributesNotFound, ErrorType;

    List<Delivery> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Delivery delivery);

    List<Delivery> findAll();

    List<Delivery> findAll(int page, int size);

    String getNextVal();

    List<Delivery> exportWmsSaleOrder(List<Delivery> deliveries);

    void updateDelivery(Delivery delivery);

    Delivery generateDeliveryFromSaleOrder(SaleOrder saleOrder) throws IdNotFound, AttributesNotFound, ErrorType, CustomException;


    void calculateAllLines(Delivery delivery);

    Delivery cancel(Delivery delivery) throws IdNotFound;

    Delivery close(Delivery delivery) throws IdNotFound, AttributesNotFound, ErrorType, CustomException;
}
