package com.bagile.tms.services;

import com.bagile.tms.dto.Habilitation;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HabilitationService {

    public Habilitation save(Habilitation habilitation);
    public Habilitation save(String[] habilitation);

    public Long size();

    public Boolean isExist(Long id);

    public Habilitation findById(Long id) throws IdNotFound;

    public List<Habilitation> find(String search) throws AttributesNotFound, ErrorType;

    public List<Habilitation> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Habilitation habilitation);

    public List<Habilitation> findAll();

    public List<Habilitation> findAll(Pageable pageable);
}