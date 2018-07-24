package com.bagile.tms.services;

import com.sinno.ems.dto.Owner;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

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

    public void delete(Long id);

    public void delete(Owner owner);

    public List<Owner> findAll() throws AttributesNotFound, ErrorType;

    public List<Owner> findAll(int page, int size) throws AttributesNotFound, ErrorType;

    public Owner loadWmsOwner(com.sinno.wms.crud.modelbasic.owners.Owner owner);

     List<Owner> exportWmsOwner(List<Owner> owners);

    String getLastInvoiceDate(Long id);
}