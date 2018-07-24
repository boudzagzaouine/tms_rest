package com.bagile.tms.services;

import com.sinno.ems.dto.UserActions;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserActionsService {

    public UserActions save(UserActions userActions);

    public Long size();

    public Boolean isExist(Long id);

    public UserActions findById(Long id) throws IdNotFound;

    public List<UserActions> find(String search) throws AttributesNotFound, ErrorType;

    public List<UserActions> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(UserActions userActions);

    public List<UserActions> findAll();

    public List<UserActions> findAll(Pageable pageable);
}