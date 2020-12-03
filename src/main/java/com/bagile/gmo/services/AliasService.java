package com.bagile.gmo.services;

import com.bagile.gmo.dto.Alias;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AliasService {

    Alias save(Alias alias);

    Long size();

    Boolean isExist(Long id);

    Alias findById(Long id) throws IdNotFound;

    List<Alias> find(String search) throws AttributesNotFound, ErrorType;

    List<Alias> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    Alias findOne(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Alias alias);

    List<Alias> findAll();

    List<Alias> findAll(Pageable pageable);
}