package com.sinno.ems.service.impl;

import java.math.BigInteger;
import java.util.List;

import com.sinno.ems.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sinno.ems.dto.Container;
import com.sinno.ems.dto.ContainerArc;
import com.sinno.ems.entities.StkContainerView;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ContainerArcMapper;
import com.sinno.ems.mapper.ContainerMapper;
import com.sinno.ems.repositories.ContainerArcRepository;
import com.sinno.ems.repositories.ContainerRepository;
import com.sinno.ems.repositories.ContainerViewRepository;
import com.sinno.ems.service.ContainerService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;

@Service
public class ContainerServiceImpl implements ContainerService {

    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private ContainerViewRepository containerViewRepository;
    @Autowired
    private ContainerArcRepository containerArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ContainerService.class);

    @Override
    public Container save(Container container) {
        LOGGER.info("save Container");
        container.setUpdateDate(EmsDate.getDateNow());
        if (0 >= container.getId()) {
            container.setCreationDate(EmsDate.getDateNow());
        }
        return ContainerMapper.toDto(containerRepository.saveAndFlush(ContainerMapper.toEntity(container, false)), false);
    }

    @Override
    public Long size() {
        return containerViewRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return containerRepository.exists(id);
    }

    @Override
    public Container findById(Long id) throws IdNotFound {
        Container container = ContainerMapper.toDto(containerRepository.findOne(id), false);
        if (null != container) {
            return container;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Container> find(String search) throws AttributesNotFound, ErrorType {
        return ContainerMapper.toViewDtos(containerViewRepository.findAll(Search.expression(search, StkContainerView.class)), false);
    }

    @Override
    public List<Container> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ContainerMapper.toViewDtos(containerViewRepository.findAll(Search.expression(search, StkContainerView.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return containerViewRepository.count(Search.expression(search, StkContainerView.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Container");
        containerRepository.delete(id);

        if (0 > 1) {
            Container container = ContainerMapper.toDto(containerRepository.findOne(id), false);
            archiveContainer(container);
        }
    }

    @Override
    public void delete(Container container) {
        LOGGER.info("delete Container");
        containerRepository.delete(ContainerMapper.toEntity(container, false));
    }

    @Override
    public List<Container> findAll() {
        return ContainerMapper.toViewDtos(containerViewRepository.findAll(), false);
    }

    @Override
    public List<Container> findAll(Pageable pageable) {
        return ContainerMapper.toViewDtos(containerViewRepository.findAll(pageable), false);
    }

    @Override
    public BigInteger getNextVal() {
        List<BigInteger> objects = containerRepository.getNextVal();
        return objects.get(0);
    }

    private void archiveContainer(Container container) {
        ContainerArc containerArc = new ContainerArc();
        containerArc.setOwner(container.getOwner());
        containerArc.setWarehouse(container.getWarehouse());
        containerArc.setCode(container.getCode());
        containerArc.setLocation(container.getLocation());
        containerArc.setCreationDate(EmsDate.getDateNow());
        containerArc.setVariable1(container.getVariable1());
        containerArc.setVariable2(container.getVariable2());
        containerArc.setVariable3(container.getVariable3());
        containerArc.setVariable4(container.getVariable4());
        containerArc.setVariable5(container.getVariable5());
        containerArc.setVariable6(container.getVariable6());
        containerArc.setVariable7(container.getVariable7());
        containerArc.setVariable8(container.getVariable8());
        containerArc.setVariable9(container.getVariable9());
        containerArc.setVariable10(container.getVariable10());
        containerArcRepository.saveAndFlush(ContainerArcMapper.toEntity(containerArc, false));
    }
}