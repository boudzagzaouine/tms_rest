package com.sinno.ems.service.impl;

import com.sinno.ems.dto.BarCode;
import com.sinno.ems.entities.PrmBarCode;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.BarCodeMapper;
import com.sinno.ems.repositories.BarCodeRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.BarCodeService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASMAE on 29/04/2016.
 */

@Service
public class BarCodeServiceImpl implements BarCodeService{
    @Autowired
    private BarCodeRepository barCodeRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(BarCodeService.class);

    @Override
    public BarCode save(BarCode barCode) {
        LOGGER.info("save Barcode");
        barCode.setUpdateDate(EmsDate.getDateNow());
        if (0 >= barCode.getId()) {
            barCode.setCreationDate(EmsDate.getDateNow());
        }
        return BarCodeMapper.toDto(barCodeRepository.saveAndFlush(BarCodeMapper.toEntity(barCode, false)), false);
    }

    @Override
    public Long size() {
        return barCodeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return barCodeRepository.exists(id);
    }

    @Override
    public BarCode findById(Long id) throws IdNotFound {
        BarCode stock = BarCodeMapper.toDto(barCodeRepository.findOne(id), false);
        if (null != stock) {
            return stock;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<BarCode> find(String search) throws AttributesNotFound, ErrorType {
        return BarCodeMapper.toDtos(barCodeRepository.findAll(Search.expression(search, PrmBarCode.class)), false);
    }

    @Override
    public List<BarCode> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return BarCodeMapper.toDtos(barCodeRepository.findAll(Search.expression(search, PrmBarCode.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {

        return barCodeRepository.count(Search.expression(search, PrmBarCode.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Barcode");
        barCodeRepository.delete(id);
    }

    @Override
    public void delete(BarCode stock)
    {
        LOGGER.info("delete Barcode");
        barCodeRepository.delete(BarCodeMapper.toEntity(stock, false));
    }

    @Override
    public List<BarCode> findAll() {
        return BarCodeMapper.toDtos(barCodeRepository.findAll(), false);
    }

    @Override
    public List<BarCode> findAll(Pageable pageable) {
        return BarCodeMapper.toDtos(barCodeRepository.findAll(pageable), false);
    }
}
