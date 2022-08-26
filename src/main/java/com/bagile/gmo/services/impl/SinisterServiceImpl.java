package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Sinister;
import com.bagile.gmo.entities.GmoSinister;
import com.bagile.gmo.exceptions.AttributesNotFound;

import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.SinisterMapper;
import com.bagile.gmo.repositories.SinisterRepository;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.services.SinisterService;
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
public class SinisterServiceImpl implements SinisterService {
    private final SinisterRepository sinisterRepository;

    @Autowired
    private SettingService settingService;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(SinisterService.class);

    public SinisterServiceImpl(SinisterRepository sinisterRepository) {
        this.sinisterRepository = sinisterRepository;
    }

    @Override
    public Sinister save(@NonNull Sinister sinister) {
        LOGGER.info("save Sinister");
    
        return SinisterMapper.toDto(sinisterRepository.saveAndFlush(SinisterMapper.toEntity(sinister, false)), false);
    }

    @Override
    public Long size() throws AttributesNotFound, Error {
        return sinisterRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return sinisterRepository.existsById(id);
    }

    @Override
    public Sinister findById(Long id) throws IdNotFound {
        return SinisterMapper.toDto(sinisterRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Sinister> find(String search) throws AttributesNotFound, Error, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return SinisterMapper.toDtos(sinisterRepository.findAll(Search.expression(search, GmoSinister.class)), false);
    }

    @Override
    public List<Sinister> find(String search,int page, int size) throws AttributesNotFound, Error, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }

        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SinisterMapper.toDtos(sinisterRepository.findAll(Search.expression(search, GmoSinister.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, Error, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return sinisterRepository.count(Search.expression(search, GmoSinister.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save Sinister");
        sinisterRepository.deleteById(id);
    }

    @Override
    public void delete(Sinister sinister) {
        LOGGER.info("delete Sinister");
        sinisterRepository.delete(SinisterMapper.toEntity(sinister, false));
    }

    @Override
    public List<Sinister> findAll() {

        return SinisterMapper.toDtos(sinisterRepository.findAll(), false);
    }

    @Override
    public List<Sinister> findAll(int page, int size) throws AttributesNotFound, Error {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SinisterMapper.toDtos(sinisterRepository.findAll( pageable), false);
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            sinisterRepository.deleteById(id);        }
    }

  


}

