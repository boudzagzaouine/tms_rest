package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Color;
import com.sinno.ems.entities.TmsColor;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ColorMapper;
import com.sinno.ems.repositories.ColorRepository;
import com.sinno.ems.service.ColorService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ColorService.class);



    @Override
    public Color save(Color color) {
        LOGGER.info("save Color");
        color.setUpdateDate(EmsDate.getDateNow());
        if(0<=color.getId())
        {
            color.setCreationDate(EmsDate.getDateNow());
        }
        return ColorMapper.toDto(colorRepository.saveAndFlush(ColorMapper.toEntity(color, false)), false);
    }

    @Override
    public Long size() {
        return colorRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return colorRepository.exists(id);
    }

    @Override
    public Color findById(Long id) throws IdNotFound {
        Color color = ColorMapper.toDto(colorRepository.findOne(id), false);
        if (null != color) {
            return color;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Color> find(String search) throws AttributesNotFound, ErrorType {
        return ColorMapper.toDtos(colorRepository.findAll(Search.expression(search, TmsColor.class)), false);
    }

    @Override
    public List<Color> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ColorMapper.toDtos(colorRepository.findAll(Search.expression(search, TmsColor.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return colorRepository.count(Search.expression(search, TmsColor.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save Color");
        colorRepository.delete(id);
    }

    @Override
    public void delete(Color color) {
        LOGGER.info("delete Color");
        colorRepository.delete(ColorMapper.toEntity(color, false));
    }

    @Override
    public List<Color> findAll() {
        return ColorMapper.toDtos(colorRepository.findAll(), false);
    }

    @Override
    public List<Color> findAll(Pageable pageable) {
        return ColorMapper.toDtos(colorRepository.findAll(pageable), false);
    }
}