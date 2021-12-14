package com.bagile.gmo.services;


import com.bagile.gmo.dto.Ville;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VilleService {
    Ville save(Ville ville);

    Long size();

    Boolean isExist(Long id);

    Ville findById(Long id) throws IdNotFound;

    List<Ville> find(String search) throws AttributesNotFound, ErrorType;

    List<Ville> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Ville ville);

    List<Ville> findAll() throws AttributesNotFound, ErrorType;

    List<Ville> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;
}
