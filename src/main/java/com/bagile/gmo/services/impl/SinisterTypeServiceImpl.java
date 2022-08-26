package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.SinisterType;
import com.bagile.gmo.entities.GmoSinisterType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.SinisterTypeMapper;
import com.bagile.gmo.repositories.SinisterTypeRepository;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.services.SinisterTypeService;
import com.bagile.gmo.util.GmaoSearch;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SinisterTypeServiceImpl implements SinisterTypeService {
    private final SinisterTypeRepository sinisterTypeRepository;

    @Autowired
    private SettingService settingService;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(SinisterTypeService.class);

    public SinisterTypeServiceImpl(SinisterTypeRepository sinisterTypeRepository) {
        this.sinisterTypeRepository = sinisterTypeRepository;
    }

    @Override
    public SinisterType save(@NonNull SinisterType sinisterType) {
        LOGGER.info("save SinisterType");
    
        return SinisterTypeMapper.toDto(sinisterTypeRepository.saveAndFlush(SinisterTypeMapper.toEntity(sinisterType, false)), false);
    }

    @Override
    public Long size() throws AttributesNotFound, ErrorType {
        return sinisterTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return sinisterTypeRepository.existsById(id);
    }

    @Override
    public SinisterType findById(Long id) throws IdNotFound {
        return SinisterTypeMapper.toDto(sinisterTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<SinisterType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return SinisterTypeMapper.toDtos(sinisterTypeRepository.findAll(Search.expression(search, GmoSinisterType.class)), false);
    }

    @Override
    public List<SinisterType> find(String search,int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }

        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SinisterTypeMapper.toDtos(sinisterTypeRepository.findAll(Search.expression(search, GmoSinisterType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return sinisterTypeRepository.count(Search.expression(search, GmoSinisterType.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save SinisterType");
        sinisterTypeRepository.deleteById(id);
    }

    @Override
    public void delete(SinisterType sinisterType) {
        LOGGER.info("delete SinisterType");
        sinisterTypeRepository.delete(SinisterTypeMapper.toEntity(sinisterType, false));
    }

    @Override
    public List<SinisterType> findAll() {

        return SinisterTypeMapper.toDtos(sinisterTypeRepository.findAll(), false);
    }

    @Override
    public List<SinisterType> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SinisterTypeMapper.toDtos(sinisterTypeRepository.findAll( pageable), false);
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            sinisterTypeRepository.deleteById(id);        }
    }



}

