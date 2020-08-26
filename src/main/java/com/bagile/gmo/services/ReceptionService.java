package com.bagile.gmo.services;


import com.bagile.gmo.dto.Reception;
import com.bagile.gmo.dto.PurshaseOrder;
import com.bagile.gmo.dto.Reception;
import com.bagile.gmo.exceptions.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReceptionService {

    Reception save(Reception reception);

    Long size();

    Boolean isExist(Long id);

    Reception findById(Long id) throws IdNotFound;

    List<Reception> find(String search) throws AttributesNotFound, ErrorType;

    List<Reception> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Reception findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Reception badgeTypeDriver);
    void deleteAll (List<Long> ids);
    List<Reception> findAll() throws AttributesNotFound, ErrorType;

    List<Reception> findAll(int page, int size) throws AttributesNotFound, ErrorType;
}