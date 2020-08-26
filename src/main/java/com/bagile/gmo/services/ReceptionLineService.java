package com.bagile.gmo.services;

import com.bagile.gmo.dto.ReceptionLine;
import com.bagile.gmo.dto.ReceptionLine;
import com.bagile.gmo.dto.Stock;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.exceptions.ProductControls;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReceptionLineService {

    ReceptionLine save(ReceptionLine receptionLine);

    Long size();

    Boolean isExist(Long id);

    ReceptionLine findById(Long id) throws IdNotFound;

    List<ReceptionLine> find(String search) throws AttributesNotFound, ErrorType;

    List<ReceptionLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    ReceptionLine findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ReceptionLine badgeTypeDriver);
    void deleteAll (List<Long> ids);
    List<ReceptionLine> findAll() throws AttributesNotFound, ErrorType;

    List<ReceptionLine> findAll(int page, int size) throws AttributesNotFound, ErrorType;

}