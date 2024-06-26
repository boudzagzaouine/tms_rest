package com.bagile.gmo.services;


import com.bagile.gmo.dto.Pays;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaysService {
    Pays save(Pays pays);

    Long size();

    Boolean isExist(Long id);

    Pays findById(Long id) throws IdNotFound;

    List<Pays> find(String search) throws AttributesNotFound, ErrorType;

    List<Pays> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Pays pays);
    void deleteAll (List<Long> ids);

    List<Pays> findAll() throws AttributesNotFound, ErrorType;

    List<Pays> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;
}
