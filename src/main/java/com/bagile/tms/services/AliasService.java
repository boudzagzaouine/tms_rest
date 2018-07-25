package com.bagile.tms.services;

import com.bagile.tms.dto.Alias;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AliasService {

    public Alias save(Alias alias);

    public Long size();

    public Boolean isExist(Long id);

    public Alias findById(Long id) throws IdNotFound;

    public List<Alias> find(String search) throws AttributesNotFound, ErrorType;

    public List<Alias> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Alias alias);

    public List<Alias> findAll();

    public List<Alias> findAll(Pageable pageable);
}