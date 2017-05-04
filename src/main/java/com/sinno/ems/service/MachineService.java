package com.sinno.ems.service;

import com.sinno.ems.dto.Machine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

import java.util.List;

/**
 * Created by Enissay on 28/03/2017.
 */
public interface MachineService {
    Machine save(Machine machine);

    Long size();

    Boolean isExist(Long id);

    Machine findById(Long id) throws IdNotFound;

    List<Machine> find(String search) throws AttributesNotFound, ErrorType;

    List<Machine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Machine machine);

    List<Machine> findAll() throws AttributesNotFound, ErrorType;

    List<Machine> findAll(int page, int size) throws AttributesNotFound, ErrorType;
}
