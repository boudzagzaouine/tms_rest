package com.bagile.gmo.services;

import com.bagile.gmo.dto.Day;
import com.bagile.gmo.dto.MaintenancePlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface DayService {

    Day save(Day day);

    List<Day> saveAll(List<Day> days);

    Long size();

    Boolean isExist(Long id);

    Day findById(Long id) throws IdNotFound;

    List<Day> find(String search) throws AttributesNotFound, ErrorType;

    List<Day> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Day day);

    void deleteAll(List<Long> ids);

    List<Day> findAll();

    List<Day> findAll(int page, int size);

	Day findOne(String search) throws AttributesNotFound, ErrorType;

}
