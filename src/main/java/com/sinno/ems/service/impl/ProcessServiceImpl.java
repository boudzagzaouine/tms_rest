package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Process;
import com.sinno.ems.entities.PdtProcess;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ProcessMapper;
import com.sinno.ems.repositories.ProcessRepository;
import com.sinno.ems.service.ProcessService;
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
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    private ProcessRepository processRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProcessService.class);

    @Override
    public Process save(Process machine) {
        LOGGER.info("save Process");
        machine.setUpdateDate(EmsDate.getDateNow());
        if (0 >= machine.getId()) {
            machine.setCreationDate(EmsDate.getDateNow());
        }
        return ProcessMapper.toDto(processRepository.saveAndFlush(ProcessMapper.toEntity(machine, false)), false);
    }

    @Override
    public Long size() {
        return processRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return processRepository.exists(id);
    }

    @Override
    public Process findById(Long id) throws IdNotFound {
        Process machine = ProcessMapper.toDto(processRepository.findOne(id), false);
        if (null != machine) {
            return machine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Process> find(String search) throws AttributesNotFound, ErrorType {

        return ProcessMapper.toDtos(processRepository.findAll(Search.expression(search, PdtProcess.class)), false);
    }

    @Override
    public List<Process> find(String search, int page, int size) throws AttributesNotFound, ErrorType {

        Sort sort = new Sort(Sort.Direction.DESC, "pdtProcessUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return ProcessMapper.toDtos(processRepository.findAll(Search.expression(search, PdtProcess.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {

        return processRepository.count(Search.expression(search, PdtProcess.class));
    }

    @Override
    public void delete(Long id) {
        PdtProcess locProcess = processRepository.findOne(id);
        processRepository.delete(locProcess);
    }

    @Override
    public void delete(Process machine) {
        LOGGER.info("delete Process");
        processRepository.saveAndFlush(ProcessMapper.toEntity(machine, false));
    }

    @Override
    public List<Process> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<Process> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "pdtProcessUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return ProcessMapper.toDtos(processRepository.findAll(pageable), false);
    }


}
