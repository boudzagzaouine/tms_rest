package com.bagile.gmo.services;

import com.bagile.gmo.dto.Vat;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface VatService {
    Vat save(Vat vat);

    Long size();

    Boolean isExist(Long id);

    Vat findById(Long id) throws IdNotFound;

    List<Vat> find(String search) throws AttributesNotFound, ErrorType;

    List<Vat> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Vat vat);

    void deleteAll (List<Long> ids);

    List<Vat> findAll();

    List<Vat> findAll(int page, int size);
}
