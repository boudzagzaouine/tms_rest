package com.bagile.tms.services;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

import java.util.List;

/**
 * Created by Enissay on 28/03/2017.
 */
public interface ProcessService {
    Process save(Process machine);

    Long size();

    Boolean isExist(Long id);

    Process findById(Long id) throws IdNotFound;

    List<Process> find(String search) throws AttributesNotFound, ErrorType;

    List<Process> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Process machine);

    List<Process> findAll() throws AttributesNotFound, ErrorType;

    List<Process> findAll(int page, int size) throws AttributesNotFound, ErrorType;
}
