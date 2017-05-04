package com.sinno.ems.service;

import com.sinno.ems.dto.Contact;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactService {

    public Contact save(Contact contact);

    public Long size();

    public Boolean isExist(Long id);

    public Contact findById(Long id) throws IdNotFound;

    public List<Contact> find(String search) throws AttributesNotFound, ErrorType;

    public List<Contact> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Contact contact);

    public List<Contact> findAll() throws AttributesNotFound, ErrorType;

    public List<Contact> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;
}