package com.sinno.ems.service;

import com.sinno.ems.dto.MachineProcess;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

import java.util.List;

/**
 * Created by Enissay on 28/03/2017.
 */
public interface MachineProcessService {
    MachineProcess save(MachineProcess machine);

    Long size();

    Boolean isExist(Long id);

    MachineProcess findById(Long id) throws IdNotFound;

    List<MachineProcess> find(String search) throws AttributesNotFound, ErrorType;

    List<MachineProcess> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(MachineProcess machine);

    List<MachineProcess> findAll() throws AttributesNotFound, ErrorType;

    List<MachineProcess> findAll(int page, int size) throws AttributesNotFound, ErrorType;
}
