package com.bagile.tms.services;

import com.sinno.ems.dto.DeliveryLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 21/04/2016.
 */
public interface DeliveryLineService {
    public DeliveryLine save(DeliveryLine deliveryLine) throws ProductControls;

    public Long size();

    public Boolean isExist(Long id);

    public DeliveryLine findById(Long id) throws IdNotFound;

    public List<DeliveryLine> find(String search) throws AttributesNotFound, ErrorType;

    public List<DeliveryLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(DeliveryLine deliveryLine);

    public List<DeliveryLine> findAll();

    public List<DeliveryLine> findAll(Pageable pageable);
}
