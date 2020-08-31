package com.bagile.gmo.services;

import com.bagile.gmo.dto.PurshaseOrderLine;
import com.bagile.gmo.dto.PurshaseOrderLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PurshaseOrderLineService {
    
    PurshaseOrderLine save(PurshaseOrderLine purshaseOrder);

    Long size();

    Boolean isExist(Long id);

    PurshaseOrderLine findById(Long id) throws IdNotFound;

    List<PurshaseOrderLine> find(String search) throws AttributesNotFound, ErrorType;

    List<PurshaseOrderLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    PurshaseOrderLine findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(PurshaseOrderLine badgeTypeDriver);
    void deleteAll (List<Long> ids);
    List<PurshaseOrderLine> findAll() throws AttributesNotFound, ErrorType;

    List<PurshaseOrderLine> findAll(int page, int size) throws AttributesNotFound, ErrorType;
    void updatePurshaseOrderLine(PurshaseOrderLine purshaseOrderLine);

}