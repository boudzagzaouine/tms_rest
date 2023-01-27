package com.bagile.gmo.services;

import com.bagile.gmo.dto.UserGroup;
import com.bagile.gmo.dto.UserGroup;
import com.bagile.gmo.dto.UserGroup;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserGroupService {

     UserGroup save(UserGroup userGroup);


    Long size();

    Boolean isExist(Long id);

    UserGroup findById(Long id) throws IdNotFound;

    List<UserGroup> find(String search) throws AttributesNotFound, ErrorType;

    List<UserGroup> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(UserGroup userGroup);
    void deleteAll (List<Long> ids);

    List<UserGroup> findAll();

    List<UserGroup> findAll(int page, int size);

}