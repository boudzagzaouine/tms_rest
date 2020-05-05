package com.bagile.gmo.services;

import com.bagile.gmo.dto.UserGroupOwner;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
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