package com.bagile.gmo.services;

import com.bagile.gmo.dto.DocumentType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface DocumentTypeService {
    DocumentType save(DocumentType documentType);

    Long size();

    Boolean isExist(Long id);

    DocumentType findById(Long id) throws IdNotFound;

    List<DocumentType> find(String search) throws AttributesNotFound, ErrorType;

    List<DocumentType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(DocumentType documentType);
    void deleteAll (List<Long> ids);
    List<DocumentType> findAll();

    List<DocumentType> findAll(int page, int size);
}
