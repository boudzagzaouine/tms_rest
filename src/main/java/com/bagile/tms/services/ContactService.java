package com.bagile.tms.services;


import com.bagile.tms.dto.Contact;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactService {

    Contact save(Contact contact);

    Long size();

    Boolean isExist(Long id);

    Contact findById(Long id) throws IdNotFound;

    List<Contact> find(String search) throws AttributesNotFound, ErrorType;

    List<Contact> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Contact findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Contact contact);

    List<Contact> findAll() throws AttributesNotFound, ErrorType;

    List<Contact> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;
}