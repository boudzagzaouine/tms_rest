package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserBoxService {

    UserBox save(UserBox color);

    Long size();

    Boolean isExist(Long id);

    UserBox findById(Long id) throws IdNotFound;

    List<UserBox> find(String search) throws AttributesNotFound, ErrorType;

    List<UserBox> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(UserBox color);

    List<UserBox> findAll();

    List<UserBox> findAll(Pageable pageable);
}