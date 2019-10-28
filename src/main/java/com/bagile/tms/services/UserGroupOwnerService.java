package com.bagile.tms.services;

import com.bagile.tms.dto.UserGroupOwner;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserGroupOwnerService {

    public UserGroupOwner save(UserGroupOwner userGroupOwner);

    public Long size();

    public Boolean isExist(Long id);

    public UserGroupOwner findById(Long id) throws IdNotFound;

    public List<UserGroupOwner> find(String search) throws AttributesNotFound, ErrorType;

    public List<UserGroupOwner> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(UserGroupOwner userGroupOwner);

    public List<UserGroupOwner> findAll();

    public List<UserGroupOwner> findAll(Pageable pageable);
}