package com.bagile.gmo.services;

import com.bagile.gmo.dto.Habilitation;
import com.bagile.gmo.dto.Habilitation;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HabilitationService {

    Habilitation save(String[] habilitation);

    Habilitation save(Habilitation habilitation);

    Long size();

    Boolean isExist(Long id);

    Habilitation findById(Long id) throws IdNotFound;

    List<Habilitation> find(String search) throws AttributesNotFound, ErrorType;

    List<Habilitation> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Habilitation habilitation);
    void deleteAll (List<Long> ids);

    List<Habilitation> findAll();

    List<Habilitation> findAll(int page, int size);

    Habilitation findOne(String search) throws AttributesNotFound, ErrorType;
}