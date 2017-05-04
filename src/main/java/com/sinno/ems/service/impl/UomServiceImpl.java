package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Uom;
import com.sinno.ems.entities.PdtUom;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.UomMapper;
import com.sinno.ems.repositories.UomRepository;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.service.UomService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UomServiceImpl implements UomService {

    @Autowired
    private UomRepository uomRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(UomService.class);

    @Override
    public Uom save(Uom uom) {
        LOGGER.info("save UOM");
        uom.setUpdateDate(EmsDate.getDateNow());
        if (0 >= uom.getId()) {
            uom.setCreationDate(EmsDate.getDateNow());
        }
        return UomMapper.toDto(uomRepository.saveAndFlush(UomMapper.toEntity(uom, false)), false);
    }

    @Override
    public Long size() {
        return uomRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return uomRepository.exists(id);
    }

    @Override
    public Uom findById(Long id) throws IdNotFound {
        Uom uom = UomMapper.toDto(uomRepository.findOne(id), false);
        if (null != uom) {
            return uom;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Uom> find(String search) throws AttributesNotFound, ErrorType {
        return UomMapper.toDtos(uomRepository.findAll(Search.expression(search, PdtUom.class)), false);
    }

    @Override
    public List<Uom> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC,"pdtUomUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return UomMapper.toDtos(uomRepository.findAll(Search.expression(search, PdtUom.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return uomRepository.count(Search.expression(search, PdtUom.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete UOM");
        uomRepository.delete(id);
    }

    @Override
    public void delete(Uom uom) {
        LOGGER.info("delete UOM");
        uomRepository.delete(UomMapper.toEntity(uom, false));
    }

    @Override
    public List<Uom> findAll() {
        return UomMapper.toDtos(uomRepository.findAll(), false);
    }

    @Override
    public List<Uom> findAll(Pageable pageable) {
        return UomMapper.toDtos(uomRepository.findAll(pageable), false);
    }
}