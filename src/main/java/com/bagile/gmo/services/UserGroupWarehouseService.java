package com.bagile.gmo.services;

import com.bagile.gmo.dto.UserGroupWarehouse;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserGroupWarehouseService {

    public UserGroupWarehouse save(UserGroupWarehouse userGroupWarehouse);

    public Long size();

    public Boolean isExist(Long id);

    public UserGroupWarehouse findById(Long id) throws IdNotFound;

    public List<UserGroupWarehouse> find(String search) throws AttributesNotFound, ErrorType;

    public List<UserGroupWarehouse> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(UserGroupWarehouse userGroupWarehouse);

    public List<UserGroupWarehouse> findAll();

    public List<UserGroupWarehouse> findAll(Pageable pageable);
}