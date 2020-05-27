package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Machine;
import com.bagile.gmo.entities.GmoMachine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.MachineMapper;
import com.bagile.gmo.repositories.MachineRepository;
import com.bagile.gmo.services.MachineService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MachineServiceImpl implements MachineService {

    private final MachineRepository machineRepository;

    public MachineServiceImpl(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public Machine save(Machine machine) {
        return MachineMapper.toDto
                (machineRepository.saveAndFlush(MachineMapper.toEntity(machine, false)), false);
    }

    @Override
    public Long size() {
        return machineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return machineRepository.existsById(id);
    }

    @Override
    public Machine findById(Long id) throws IdNotFound {
        return MachineMapper.toDto(machineRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Machine> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return MachineMapper.toDtos(machineRepository.findAll(Search.expression(search, GmoMachine.class)), false);
    }

    @Override
    public List<Machine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Pageable pageable = PageRequest.of(page, size);
        return MachineMapper.toDtos(machineRepository.findAll(Search.expression(search, GmoMachine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return machineRepository.count(Search.expression(search, GmoMachine.class));
    }

    @Override
    public void delete(Long id) {
        machineRepository.deleteById(id);
    }

    @Override
    public void delete(Machine machine) {
        machineRepository.delete(MachineMapper.toEntity(machine, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            machineRepository.deleteById(id);        }
    }
    @Override
    public List<Machine> findAll() {
        return MachineMapper.toDtos(machineRepository.findAll(), false);
    }

    @Override
    public List<Machine> findAll(int page, int size) {
        Sort sort = Sort.by (Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);

        return MachineMapper.toDtos(machineRepository.findAll(pageable), false);
    }
}
