package com.bagile.tms.services;


import com.bagile.tms.dto.Uom;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UomService {

    Uom save(Uom uom);

    Long size();

    Boolean isExist(Long id);

    Uom findById(Long id) throws IdNotFound;

    Uom findOne(String search) throws AttributesNotFound, ErrorType;

    List<Uom> find(String search) throws AttributesNotFound, ErrorType;

    List<Uom> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Uom uom);

    List<Uom> findAll();

    List<Uom> findAll(Pageable pageable);

    Uom findFirstByCode(String code);
}