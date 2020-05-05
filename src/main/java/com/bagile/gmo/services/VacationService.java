package com.bagile.gmo.services;

import com.bagile.gmo.dto.Vacation;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VacationService {

    Vacation save(Vacation vacation);

    Long size();

    Boolean isExist(Long id);

    Vacation findById(Long id) throws IdNotFound;

    List<Vacation> find(String search) throws AttributesNotFound, ErrorType;

    List<Vacation> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Vacation vacation);

    List<Vacation> findAll();

    List<Vacation> findAll(int page, int size);
}
