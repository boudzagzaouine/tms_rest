package com.bagile.tms.services;

import com.bagile.tms.dto.UserActions;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
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