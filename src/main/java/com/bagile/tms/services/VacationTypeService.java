package com.bagile.tms.services;

import com.bagile.tms.dto.VacationType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VacationTypeService {

    VacationType save(VacationType vacationtype);

    Long size();

    Boolean isExist(Long id);

    VacationType findById(Long id) throws IdNotFound;

    List<VacationType> find(String search) throws AttributesNotFound, ErrorType;

    List<VacationType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(VacationType badge);

    List<VacationType> findAll();

    List<VacationType> findAll(Pageable pageable);
}
