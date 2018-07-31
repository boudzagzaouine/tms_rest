package com.bagile.tms.services;

import com.bagile.tms.dto.Container;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface ContainerService {

    public Container save(Container container);

    public Long size();

    public Boolean isExist(Long id);

    public Container findById(Long id) throws IdNotFound;

    Container findOne(String search) throws AttributesNotFound, ErrorType;

    Container findByCode(String code);

    public List<Container> find(String search) throws AttributesNotFound, ErrorType;

    public List<Container> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Container container);

    public List<Container> findAll();

    public List<Container> findAll(Pageable pageable);



}