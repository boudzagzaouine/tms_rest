package com.bagile.gmo.services;

import com.bagile.gmo.dto.Location;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;


import java.util.List;

public interface LocationService {

    Location save(Location location);

    Long size();

    Boolean isExist(Long id);

    Location findById(Long id) throws IdNotFound;

    Location findOne(String search) throws AttributesNotFound, ErrorType;

    List<Location> find(String search) throws AttributesNotFound, ErrorType;

    List<Location> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Location location);

    List<Location> findAll() throws AttributesNotFound, ErrorType;

    List<Location> findAll(int page, int size) throws AttributesNotFound, ErrorType;

    List<Location> findEmtyLocation(String search) throws AttributesNotFound, ErrorType;

    Location getDefaultLocationForReception() throws AttributesNotFound, ErrorType;

    Location getDefaultLocationForDelivery() throws AttributesNotFound, ErrorType;
}