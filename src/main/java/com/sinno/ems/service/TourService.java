package com.sinno.ems.service;

import com.sinno.ems.dto.Tour;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

import java.util.List;

/**
 * Created by Enissay on 18/04/2017.
 */
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
