package com.bagile.tms.services;

import com.bagile.tms.dto.Vacation;
import com.bagile.tms.dto.Zone;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VacationService {

    Vacation save(Vacation vacation);

    Long size();

    Boolean isExist(Long id);

    Vacation findById(Long id) throws IdNotFound;

    List<Vacation> find(String search) throws AttributesNotFound, ErrorType;

    List<Vacation> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Vacation vacation);

    List<Vacation> findAll();

    List<Vacation> findAll(Pageable pageable);
}
