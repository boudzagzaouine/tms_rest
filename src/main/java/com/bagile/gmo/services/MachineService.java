package com.bagile.gmo.services;

import com.bagile.gmo.dto.Machine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


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
    void deleteAll(List<Long> ids);
    List<Machine> findAll();

    List<Machine> findAll(int page, int size);
}
