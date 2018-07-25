package com.bagile.tms.services;

import com.bagile.tms.dto.Uom;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UomService {

    public Uom save(Uom uom);

    public Long size();

    public Boolean isExist(Long id);

    public Uom findById(Long id) throws IdNotFound;

    public List<Uom> find(String search) throws AttributesNotFound, ErrorType;

    public List<Uom> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Uom uom);

    public List<Uom> findAll();

    public List<Uom> findAll(Pageable pageable);
}