package com.bagile.gmo.services;

import com.bagile.gmo.dto.Document;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface DocumentService {
    Document save(Document document);

    Long size();

    Boolean isExist(Long id);

    Document findById(Long id) throws IdNotFound;

    List<Document> find(String search) throws AttributesNotFound, ErrorType;

    List<Document> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Document document);
    void deleteAll (List<Long> ids);
    List<Document> findAll();

    List<Document> findAll(int page, int size);
}
