package com.bagile.tms.services;

import com.sinno.ems.dto.Address;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressService {

    public Address save(Address address);

    public Long size();

    public Boolean isExist(Long id);

    public Address findById(Long id) throws IdNotFound;

    public List<Address> find(String search) throws AttributesNotFound, ErrorType;

    public List<Address> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Address address);

    public List<Address> findAll();

    public List<Address> findAll(Pageable pageable);
}