package com.bagile.tms.services;

import com.bagile.tms.dto.Delivery;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.exceptions.WarehouseException;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 21/04/2016.
 */
public interface DeliveryService {
    public Delivery save(Delivery delivery) throws WarehouseException;

    public Long size();

    public Boolean isExist(Long id);

    public Delivery findById(Long id) throws IdNotFound;

    public List<Delivery> find(String search) throws AttributesNotFound, ErrorType;

    public List<Delivery> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Delivery delivery);

    public List<Delivery> findAll();

    public List<Delivery> findAll(Pageable pageable);
    public BigInteger getNextVal();

}
