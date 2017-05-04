package com.sinno.ems.service;

import com.sinno.ems.dto.Habilitation;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HabilitationService {

    public Habilitation save(Habilitation habilitation);

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