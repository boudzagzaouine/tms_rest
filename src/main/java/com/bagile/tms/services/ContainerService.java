package com.bagile.tms.services;

import com.sinno.ems.dto.Container;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface ContainerService {

    public Container save(Container container);

    public Long size();

    public Boolean isExist(Long id);

    public Container findById(Long id) throws IdNotFound;

    public List<Container> find(String search) throws AttributesNotFound, ErrorType;

    public List<Container> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Container container);

    public List<Container> findAll();

    public List<Container> findAll(Pageable pageable);

    public BigInteger getNextVal();
}