package com.sinno.ems.service.impl;

import com.sinno.ems.dto.SupplierLitigation;
import com.sinno.ems.entities.InvSupplierLitigation;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.SupplierLitigationMapper;
import com.sinno.ems.repositories.SupplierLitigationRepository;
import com.sinno.ems.service.SupplierLitigationService;
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

/**
 * Created by Enissay on 03/12/2016.
 */
@Service
public class SupplierLitigationServiceImpl implements SupplierLitigationService {
    @Autowired
    private SupplierLitigationRepository accountLitigationRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SupplierLitigationService.class);

    @Override
    public SupplierLitigation save(SupplierLitigation paymentSupplier) {
        LOGGER.info("save SupplierLitigation");
        paymentSupplier.setUpdateDate(EmsDate.getDateNow());
        if (0 >= paymentSupplier.getId()) {
            paymentSupplier.setCreationDate(EmsDate.getDateNow());
        }
        return SupplierLitigationMapper.toDto(accountLitigationRepository.saveAndFlush(SupplierLitigationMapper.toEntity(paymentSupplier, false)), false);
    }

    @Override
    public Long size() {
        return accountLitigationRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return accountLitigationRepository.exists(id);
    }

    @Override
    public SupplierLitigation findById(Long id) throws IdNotFound {
        SupplierLitigation paymentSupplier = SupplierLitigationMapper.toDto(accountLitigationRepository.findOne(id), false);
        if (null != paymentSupplier) {
            return paymentSupplier;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<SupplierLitigation> find(String search) throws AttributesNotFound, ErrorType {
        return SupplierLitigationMapper.toDtos(accountLitigationRepository.findAll(Search.expression(search, InvSupplierLitigation.class)), false);
    }

    @Override
    public List<SupplierLitigation> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "InvSupplierLitigationUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return SupplierLitigationMapper.toDtos(accountLitigationRepository.findAll(Search.expression(search, InvSupplierLitigation.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return accountLitigationRepository.count(Search.expression(search, InvSupplierLitigation.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete SupplierLitigation");
        accountLitigationRepository.delete(id);
    }

    @Override
    public void delete(SupplierLitigation paymentSupplier) {
        LOGGER.info("delete SupplierLitigation");
        accountLitigationRepository.delete(SupplierLitigationMapper.toEntity(paymentSupplier, false));
    }

    @Override
    public List<SupplierLitigation> findAll() {
        return SupplierLitigationMapper.toDtos(accountLitigationRepository.findAll(), false);
    }

    @Override
    public List<SupplierLitigation> findAll(Pageable pageable) {
        return SupplierLitigationMapper.toDtos(accountLitigationRepository.findAll(pageable), false);
    }
}
