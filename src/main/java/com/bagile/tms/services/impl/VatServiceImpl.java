package com.bagile.tms.services.impl;

import com.sinno.ems.dto.Vat;
import com.sinno.ems.entities.PrmVat;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.VatMapper;
import com.sinno.ems.repositories.VatRepository;
import com.sinno.ems.service.VatService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 22/12/2016.
 */
@Service
public class VatServiceImpl implements VatService{
    @Autowired
    private VatRepository vatRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VatService.class);

    @Override
    public Vat save(Vat vat) {
        LOGGER.info("save Vat");
        return VatMapper.toDto(vatRepository.saveAndFlush(VatMapper.toEntity(vat, false)), false);
    }

    @Override
    public Long size() {
        return vatRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vatRepository.exists(id);
    }

    @Override
    public Vat findById(Long id) throws IdNotFound {
        Vat vat = VatMapper.toDto(vatRepository.findOne(id), false);
        if (null != vat) {
            return vat;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Vat> find(String search) throws AttributesNotFound, ErrorType {
        return VatMapper.toDtos(vatRepository.findAll(Search.expression(search, PrmVat.class)), false);
    }

    @Override
    public List<Vat> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return VatMapper.toDtos(vatRepository.findAll(Search.expression(search, PrmVat.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return vatRepository.count(Search.expression(search, PrmVat.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete vat");
        vatRepository.delete(id);
    }

    @Override
    public void delete(Vat vat) {
        LOGGER.info("delete Vat");
        vatRepository.delete(VatMapper.toEntity(vat, false));
    }

    @Override
    public List<Vat> findAll() {
        return VatMapper.toDtos(vatRepository.findAll(), false);
    }

    @Override
    public List<Vat> findAll(Pageable pageable) {
        return VatMapper.toDtos(vatRepository.findAll(pageable), false);
    }
}
