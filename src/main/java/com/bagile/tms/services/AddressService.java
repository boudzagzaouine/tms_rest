package com.bagile.tms.services;

import com.bagile.tms.dto.Address;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
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