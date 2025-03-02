package com.bagile.gmo.services;

import com.bagile.gmo.dto.VacationType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VacationTypeService {

    VacationType save(VacationType vacationtype);

    Long size();

    Boolean isExist(Long id);

    VacationType findById(Long id) throws IdNotFound;

    List<VacationType> find(String search) throws AttributesNotFound, ErrorType;

    List<VacationType> find(String search, int page ,int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(VacationType badge);

    List<VacationType> findAll();

    List<VacationType> findAll(int page,int size);
}
