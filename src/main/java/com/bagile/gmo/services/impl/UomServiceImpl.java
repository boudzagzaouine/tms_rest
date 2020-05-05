package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Uom;
import com.bagile.gmo.entities.PdtUom;
import com.bagile.gmo.mapper.UomMapper;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.repositories.UomRepository;
import com.bagile.gmo.services.UomService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
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
    private final static Logger LOGGER = LoggerFactory.getLogger(UomService.class);

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
        return uomRepository.existsById (id);
    }

    @Override
    public Uom findById(Long id) throws IdNotFound {
        Uom uom = UomMapper.toDto(uomRepository.findById (id).orElse (null), false);
        if (null != uom) {
            return uom;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public Uom findOne(String search) throws AttributesNotFound, ErrorType {
        return UomMapper.toDto(uomRepository.findOne(Search.expression(search, PdtUom.class)).orElse (null), false);
    }

    @Override
    public List<Uom> find(String search) throws AttributesNotFound, ErrorType {
        return UomMapper.toDtos(uomRepository.findAll(Search.expression(search, PdtUom.class)), false);
    }

    @Override
    public List<Uom> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by (Sort.Direction.DESC,"pdtUomUpdateDate");
        Pageable pageable = PageRequest.of (page, size, sort);
        return UomMapper.toDtos(uomRepository.findAll(Search.expression(search, PdtUom.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return uomRepository.count(Search.expression(search, PdtUom.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete UOM");
        uomRepository.deleteById (id);
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

    @Override
    public Uom findFirstByCode(String code) {
        return UomMapper.toDto(uomRepository.findFirstByPdtUomCode(code),false);
    }
}