package com.bagile.gmo.services;

import com.bagile.gmo.entities.Template;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface TemplateService {
    Template save(Template template);

    Long size();

    Boolean isExist(Long id);

    Template findById(Long id) throws IdNotFound;

    void delete(Long id);

    void delete(Template template);

    List<Template> findAll();

    List<Template> findAll(int page, int size);

    Iterable<Template> find(String search) throws AttributesNotFound, ErrorType;

    Iterable<Template> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;
}
