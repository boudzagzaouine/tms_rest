package com.bagile.gmo.services;


import com.bagile.gmo.dto.Contact;
import com.bagile.gmo.dto.Contact;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactService {

    Contact save(Contact contact) throws ErrorType, AttributesNotFound;

    Long size() throws AttributesNotFound, ErrorType;

    Boolean isExist(Long id);

    Contact findById(Long id) throws IdNotFound;

    List<Contact> find(String search) throws AttributesNotFound, ErrorType;

    List<Contact> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Contact contact);
    void deleteAll (List<Long> ids);

    List<Contact> findAll() throws AttributesNotFound, ErrorType;

    List<Contact> findAll(int page, int size) throws AttributesNotFound, ErrorType;
    String getNextVal();
}