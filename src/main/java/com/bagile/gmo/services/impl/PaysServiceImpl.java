package com.bagile.gmo.services.impl;


import com.bagile.gmo.dto.Pays;
import com.bagile.gmo.entities.PrmPays;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.PaysMapper;
import com.bagile.gmo.repositories.PaysRepository;
import com.bagile.gmo.services.PaysService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ffamm on 07/06/2017.
 */
@Service
public class PaysServiceImpl implements PaysService {
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PaysService.class);
    @Autowired
    private PaysRepository paysRepository;

    @Override
    public Pays save(Pays pays) {
        LOGGER.info("Save Pays");
        pays.setUpdateDate(EmsDate.getDateNow());
        if (0 >= pays.getId()) {
            pays.setCreationDate(EmsDate.getDateNow());
        }
        return PaysMapper.toDto(paysRepository.saveAndFlush(PaysMapper.toEntity(pays, false)), false);
    }

    @Override
    public Long size() {
        return paysRepository.count();
    }

    @Override
    public Boolean isExist(Long paysId) {
        return paysRepository.existsById(paysId);
    }

    @Override
    public Pays findById(Long paysId) throws IdNotFound {
        Pays pays = PaysMapper.toDto(paysRepository.findById(paysId).orElseThrow(() -> new IdNotFound(paysId)), false);
        if (null != pays) {
            return pays;
        } else {
            throw new IdNotFound(paysId);
        }
    }

    @Override
    public List<Pays> find(String search) throws AttributesNotFound, ErrorType {
        return PaysMapper.toDtos(paysRepository.findAll(Search.expression(search, PrmPays.class)), false);
    }

    @Override
    public List<Pays> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return PaysMapper.toDtos(paysRepository.findAll(Search.expression(search, PrmPays.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return paysRepository.count(Search.expression(search, PrmPays.class));
    }

    @Override
    public void delete(Long paysId) {
        LOGGER.info("delete Pays");
        paysRepository.deleteById(paysId);
    }

    @Override
    public void delete(Pays pays) {
        LOGGER.info("delete Pays");
        paysRepository.delete(PaysMapper.toEntity(pays, false));

    }

    @Override
    public List<Pays> findAll() throws AttributesNotFound, ErrorType {
        return PaysMapper.toDtos(paysRepository.findAll(), false);

    }

    @Override
    public List<Pays> findAll(Pageable pageable) throws AttributesNotFound, ErrorType {
        return PaysMapper.toDtos(paysRepository.findAll(pageable), false);
    }
}
