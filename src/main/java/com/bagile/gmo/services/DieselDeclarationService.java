package com.bagile.gmo.services;

import com.bagile.gmo.dto.DieselDeclaration;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.io.IOException;
import java.util.List;

public interface DieselDeclarationService {
    DieselDeclaration save(DieselDeclaration dieselDeclaration) throws AttributesNotFound, ErrorType, IdNotFound, IOException;

    Long size();

    Boolean isExist(Long id);

    DieselDeclaration findById(Long id) throws IdNotFound;

    List<DieselDeclaration> find(String search) throws AttributesNotFound, ErrorType;

    List<DieselDeclaration> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(DieselDeclaration dieselDeclaration);
    void deleteAll(List<Long> ids);
    List<DieselDeclaration> findAll();

    List<DieselDeclaration> findAll(int page, int size);

    String getNextVal();

}
