package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Machine;
import com.sinno.ems.entities.PdtMachine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.MachineMapper;
import com.sinno.ems.repositories.MachineRepository;
import com.sinno.ems.service.MachineService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 28/03/2017.
 */
@Service
public class MachineServiceImpl implements MachineService {
    @Autowired
    private MachineRepository machineRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(MachineService.class);

    @Override
    public Machine save(Machine machine) {
        LOGGER.info("save Machine");
        machine.setUpdateDate(EmsDate.getDateNow());
        if (0 >= machine.getId()) {
            machine.setCreationDate(EmsDate.getDateNow());
        }
        return MachineMapper.toDto(machineRepository.saveAndFlush(MachineMapper.toEntity(machine, false)), false);
    }

    @Override
    public Long size() {
        return machineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return machineRepository.exists(id);
    }

    @Override
    public Machine findById(Long id) throws IdNotFound {
        Machine machine = MachineMapper.toDto(machineRepository.findOne(id), false);
        if (null != machine) {
            return machine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Machine> find(String search) throws AttributesNotFound, ErrorType {

        return MachineMapper.toDtos(machineRepository.findAll(Search.expression(search, PdtMachine.class)), false);
    }

    @Override
    public List<Machine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {

        Sort sort = new Sort(Sort.Direction.DESC, "pdtMachineUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return MachineMapper.toDtos(machineRepository.findAll(Search.expression(search, PdtMachine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {

        return machineRepository.count(Search.expression(search, PdtMachine.class));
    }

    @Override
    public void delete(Long id) {
        PdtMachine locMachine = machineRepository.findOne(id);
        machineRepository.delete(locMachine);
    }

    @Override
    public void delete(Machine machine) {
        LOGGER.info("delete Machine");
        machineRepository.saveAndFlush(MachineMapper.toEntity(machine, false));
    }

    @Override
    public List<Machine> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<Machine> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "pdtMachineUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return MachineMapper.toDtos(machineRepository.findAll(pageable), false);
    }


}
