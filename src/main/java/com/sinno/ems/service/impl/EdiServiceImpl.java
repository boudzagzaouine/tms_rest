package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Edi;
import com.sinno.ems.entities.PrmEdi;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.EdiMapper;
import com.sinno.ems.repositories.EdiRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.EdiService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdiServiceImpl implements EdiService {

    @Autowired
    private EdiRepository ediRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(EdiService.class);

    @Override
    public Edi save(Edi edi) {
        LOGGER.info("save EDI");
        return EdiMapper.toDto(ediRepository.saveAndFlush(EdiMapper.toEntity(edi, false)), false);
    }

    @Override
    public Long size() {
        return ediRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return ediRepository.exists(id);
    }

    @Override
    public Edi findById(Long id) throws IdNotFound {
        Edi edi = EdiMapper.toDto(ediRepository.findOne(id), false);
        if (null != edi) {
            return edi;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Edi> find(String search) throws AttributesNotFound, ErrorType {
        return EdiMapper.toDtos(ediRepository.findAll(Search.expression(search, PrmEdi.class)), false);
    }

    @Override
    public List<Edi> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return EdiMapper.toDtos(ediRepository.findAll(Search.expression(search, PrmEdi.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return ediRepository.count(Search.expression(search, PrmEdi.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete EDI");
        ediRepository.delete(id);
    }

    @Override
    public void delete(Edi edi) {
        LOGGER.info("delete EDI");
        ediRepository.delete(EdiMapper.toEntity(edi, false));
    }

    @Override
    public List<Edi> findAll() {
        return EdiMapper.toDtos(ediRepository.findAll(), false);
    }

    @Override
    public List<Edi> findAll(Pageable pageable) {
        return EdiMapper.toDtos(ediRepository.findAll(pageable), false);
    }
}