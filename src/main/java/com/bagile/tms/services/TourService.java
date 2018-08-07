package com.bagile.tms.services;

import com.bagile.tms.dto.Tour;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

public interface TourService {
    Tour save(Tour tour);

    Long size();

    Boolean isExist(Long id);

    Tour findById(Long id) throws IdNotFound;

    List<Tour> find(String search) throws AttributesNotFound, ErrorType;

    List<Tour> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Tour tour);

    List<Tour> findAll();

    List<Tour> findAll(int page, int size) throws AttributesNotFound, ErrorType;
}
