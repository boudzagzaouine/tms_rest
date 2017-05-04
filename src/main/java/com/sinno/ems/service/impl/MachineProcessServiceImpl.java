package com.sinno.ems.service.impl;

import com.sinno.ems.dto.MachineProcess;
import com.sinno.ems.entities.PdtMachineProcess;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.MachineProcessMapper;
import com.sinno.ems.repositories.MachineProcessRepository;
import com.sinno.ems.service.MachineProcessService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 28/03/2017.
 */
@Service
public class MachineProcessServiceImpl implements MachineProcessService {
    @Autowired
    private MachineProcessRepository machineProcessRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(MachineProcessService.class);

    @Override
    public MachineProcess save(MachineProcess machine) {
        LOGGER.info("save MachineProcess");
       
        return MachineProcessMapper.toDto(machineProcessRepository.saveAndFlush(MachineProcessMapper.toEntity(machine, false)), false);
    }

    @Override
    public Long size() {
        return machineProcessRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return machineProcessRepository.exists(id);
    }

    @Override
    public MachineProcess findById(Long id) throws IdNotFound {
        MachineProcess machine = MachineProcessMapper.toDto(machineProcessRepository.findOne(id), false);
        if (null != machine) {
            return machine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<MachineProcess> find(String search) throws AttributesNotFound, ErrorType {

        return MachineProcessMapper.toDtos(machineProcessRepository.findAll(Search.expression(search, PdtMachineProcess.class)), false);
    }

    @Override
    public List<MachineProcess> find(String search, int page, int size) throws AttributesNotFound, ErrorType {

        Pageable pageable = new PageRequest(page, size);
        return MachineProcessMapper.toDtos(machineProcessRepository.findAll(Search.expression(search, PdtMachineProcess.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {

        return machineProcessRepository.count(Search.expression(search, PdtMachineProcess.class));
    }

    @Override
    public void delete(Long id) {
        PdtMachineProcess locMachineProcess = machineProcessRepository.findOne(id);
        machineProcessRepository.delete(locMachineProcess);
    }

    @Override
    public void delete(MachineProcess machine) {
        LOGGER.info("delete MachineProcess");
        machineProcessRepository.saveAndFlush(MachineProcessMapper.toEntity(machine, false));
    }

    @Override
    public List<MachineProcess> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<MachineProcess> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        return find("", page, size);
    }
}
