package com.sinno.ems.service;

import com.sinno.ems.dto.Location;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

import java.util.List;

public interface LocationService {

    public Location save(Location location);

    public Long size();

    public Boolean isExist(Long id);

    public Location findById(Long id) throws IdNotFound;

    public List<Location> find(String search) throws AttributesNotFound, ErrorType;

    public List<Location> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Location location);

    public List<Location> findAll() throws AttributesNotFound, ErrorType;

    public List<Location> findAll(int page, int size) throws AttributesNotFound, ErrorType;

    List<Location> findEmtyLocation(String search) throws AttributesNotFound, ErrorType;
}