package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Container;
import com.sinno.ems.dto.ContainerArc;
import com.sinno.ems.entities.StkContainerArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ContainerArcMapper;
import com.sinno.ems.repositories.ContainerArcRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.ContainerArcService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerArcServiceImpl implements ContainerArcService {

    @Autowired
    private ContainerArcRepository containerArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ContainerArcService.class);

    @Override
    public ContainerArc save(ContainerArc containerArc) {
        LOGGER.info("save ConatinerArc");
        containerArc.setUpdateDate(EmsDate.getDateNow());
        if (0 >= containerArc.getId()) {
            containerArc.setCreationDate(EmsDate.getDateNow());
        }
        return ContainerArcMapper.toDto(containerArcRepository.saveAndFlush(ContainerArcMapper.toEntity(containerArc, false)), false);
    }

    @Override
    public Long size() {
        return containerArcRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return containerArcRepository.exists(id);
    }

    @Override
    public ContainerArc findById(Long id) throws IdNotFound {
        ContainerArc containerArc = ContainerArcMapper.toDto(containerArcRepository.findOne(id), false);
        if (null != containerArc) {
            return containerArc;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ContainerArc> find(String search) throws AttributesNotFound, ErrorType {
        return ContainerArcMapper.toDtos(containerArcRepository.findAll(Search.expression(search, StkContainerArc.class)), false);
    }

    @Override
    public List<ContainerArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ContainerArcMapper.toDtos(containerArcRepository.findAll(Search.expression(search, StkContainerArc.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return containerArcRepository.count(Search.expression(search, StkContainerArc.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ContainerArc");
        containerArcRepository.delete(id);
    }

    @Override
    public void delete(ContainerArc containerArc) {
        LOGGER.info("delete ContainerArc");
        containerArcRepository.delete(ContainerArcMapper.toEntity(containerArc, false));
    }

    @Override
    public List<ContainerArc> findAll() {
        return ContainerArcMapper.toDtos(containerArcRepository.findAll(), false);
    }

    @Override
    public List<ContainerArc> findAll(Pageable pageable) {
        return ContainerArcMapper.toDtos(containerArcRepository.findAll(pageable), false);
    }
}