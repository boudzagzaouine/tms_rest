package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.BoxMapper;
import com.sinno.ems.service.BoxService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoxServiceImpl implements BoxService {
    @Autowired
    private BoxRepository boxRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(BoxService.class);

    @Override
    public Box save(Box box) {
        LOGGER.info("save Box");
        box.setUpdateDate(EmsDate.getDateNow());
        if(0<=box.getId())
        {
            box.setCreationDate(EmsDate.getDateNow());
        }
        return BoxMapper.toDto(boxRepository.saveAndFlush(BoxMapper.toEntity(box, false)), false);
    }

    @Override
    public Long size() {
        return boxRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return boxRepository.exists(id);
    }

    @Override
    public Box findById(Long id) throws IdNotFound {
        Box box = BoxMapper.toDto(boxRepository.findOne(id), false);
        if (null != box) {
            return box;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Box> find(String search) throws AttributesNotFound, ErrorType {
        return BoxMapper.toDtos(boxRepository.findAll(Search.expression(search, UsrBox.class)), false);
    }

    @Override
    public List<Box> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return BoxMapper.toDtos(boxRepository.findAll(Search.expression(search, UsrBox.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return boxRepository.count(Search.expression(search, UsrBox.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save Box");
        boxRepository.delete(id);
    }

    @Override
    public void delete(Box box) {
        LOGGER.info("delete Box");
        boxRepository.delete(BoxMapper.toEntity(box, false));
    }

    @Override
    public List<Box> findAll() {
        return BoxMapper.toDtos(boxRepository.findAll(), false);
    }

    @Override
    public List<Box> findAll(Pageable pageable) {
        return BoxMapper.toDtos(boxRepository.findAll(pageable), false);
    }
}