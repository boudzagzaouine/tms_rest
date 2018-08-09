package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Container;
import com.bagile.tms.entities.StkContainer;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.ContainerMapper;
import com.bagile.tms.services.ContainerRepository;
import com.bagile.tms.services.ContainerService;
import com.bagile.tms.services.SettingService;
import com.bagile.tms.util.AddActive;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service
@Transactional
public class ContainerServiceImpl implements ContainerService,AddActive {

    @Autowired
    private ContainerRepository containerRepository;

    @Autowired
    private SettingService settingService;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(ContainerService.class);

    /**
     * create or update container
     * @param container
     * @return
     */
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
        return containerRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return containerRepository.existsById(id);
    }

    @Override
    public Container findById(Long id) throws IdNotFound {
        Container container = ContainerMapper.toDto(containerRepository.findById(id).get(), false);
        if (null != container) {
            return container;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public Container findOne(String search) throws AttributesNotFound, ErrorType {
        return ContainerMapper.toDto(containerRepository.findOne(Search.expression(addActiveToSearch(search), StkContainer.class)).get(), false);

    }

    @Override
    public Container findByCode(String code) {
        return ContainerMapper.toDto(containerRepository.findByStkContainerCode(code), false);
    }

    @Override
    public List<Container> find(String search) throws AttributesNotFound, ErrorType {
        return ContainerMapper.toDtos(containerRepository.findAll(Search.expression(addActiveToSearch(search), StkContainer.class)), false);
    }

    @Override
    public List<Container> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ContainerMapper.toDtos(containerRepository.findAll(Search.expression(addActiveToSearch(search), StkContainer.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return containerRepository.count(Search.expression(addActiveToSearch(search), StkContainer.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Container");

        if (0 > 1) {
            //archiveContainer(container);
        }
        Container container = ContainerMapper.toDto(containerRepository.findById(id).get(), false);
        container.setOutBoundDate(EmsDate.getDateNow());
        containerRepository.saveAndFlush(ContainerMapper.toEntity(container, false));
        // containerRepository.delete(id);

    }

    @Override
    public void delete(Container container) {
        delete(container.getId());
    }


    @Override
    public List<Container> findAll() {
        return ContainerMapper.toDtos(containerRepository.findAll(), false);
    }

    @Override
    public List<Container> findAll(Pageable pageable) {
        return ContainerMapper.toDtos(containerRepository.findAll(pageable), false);
    }

    /**
     * generate container code and write it  on 18 numeric's number
     * @return
     */
    @Override
    public String getNextVal() {
        List<BigInteger> objects = containerRepository.getNextVal();
        return String.format("%1$018d", objects.get(0));
    }

}