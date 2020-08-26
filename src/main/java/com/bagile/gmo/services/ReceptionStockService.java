package com.bagile.gmo.services;


import com.bagile.gmo.dto.ReceptionStock;
import com.bagile.gmo.dto.ReceptionLine;
import com.bagile.gmo.dto.ReceptionStock;
import com.bagile.gmo.exceptions.*;
import org.springframework.data.domain.Pageable;

import java.awt.*;
import java.util.List;

public interface ReceptionStockService {

    ReceptionStock save(ReceptionStock receptionStock);

    Long size();

    Boolean isExist(Long id);

    ReceptionStock findById(Long id) throws IdNotFound;

    List<ReceptionStock> find(String search) throws AttributesNotFound, ErrorType;

    List<ReceptionStock> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    ReceptionStock findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ReceptionStock badgeTypeDriver);
    void deleteAll (List<Long> ids);
    List<ReceptionStock> findAll() throws AttributesNotFound, ErrorType;

    List<ReceptionStock> findAll(int page, int size) throws AttributesNotFound, ErrorType;
}