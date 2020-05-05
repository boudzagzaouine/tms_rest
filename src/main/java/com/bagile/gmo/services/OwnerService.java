package com.bagile.tms.services;

import com.bagile.gmo.dto.Owner;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

public interface OwnerService {

    public Owner save(Owner owner);

    public Long size();

    public Boolean isExist(Long id);

    public Owner findById(Long id) throws IdNotFound;

    public List<Owner> find(String search) throws AttributesNotFound, ErrorType;

    List<Owner> findAllForHabilitation()throws AttributesNotFound, ErrorType;

    public List<Owner> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id) throws IdNotFound;

    public void delete(Owner owner);

    public List<Owner> findAll() throws AttributesNotFound, ErrorType;

    public List<Owner> findAll(int page, int size) throws AttributesNotFound, ErrorType;
}