package com.bagile.gmo.services;

import com.bagile.gmo.dto.PurshaseOrder;
import com.bagile.gmo.dto.PurshaseOrder;
import com.bagile.gmo.dto.Reception;
import com.bagile.gmo.dto.SaleOrder;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PurshaseOrderService {

    PurshaseOrder save(PurshaseOrder purshaseOrder);

    Long size();

    Boolean isExist(Long id);

    PurshaseOrder findById(Long id) throws IdNotFound;

    List<PurshaseOrder> find(String search) throws AttributesNotFound, ErrorType;

    List<PurshaseOrder> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    PurshaseOrder findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(PurshaseOrder badgeTypeDriver);
    void deleteAll (List<Long> ids);
    List<PurshaseOrder> findAll() throws AttributesNotFound, ErrorType;

    List<PurshaseOrder> findAll(int page, int size) throws AttributesNotFound, ErrorType;

    void updatePurshaseOrder(PurshaseOrder purshaseOrder);

}