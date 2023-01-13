package com.bagile.gmo.services;

import com.bagile.gmo.dto.ContactFunction;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ContactFunctionService {
    ContactFunction save(ContactFunction contactFunction);

    Long size();

    Boolean isExist(Long id);

    ContactFunction findById(Long id) throws IdNotFound;

    List<ContactFunction> find(String search) throws AttributesNotFound, ErrorType;

    List<ContactFunction> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ContactFunction contactFunction);
    void deleteAll (List<Long> ids);

    List<ContactFunction> findAll();

    List<ContactFunction> findAll(int page, int size);

	ContactFunction findOne(String search) throws AttributesNotFound, ErrorType;

}
