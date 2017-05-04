package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Currency;
import com.sinno.ems.entities.PrmCurrency;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.CurrencyMapper;
import com.sinno.ems.repositories.CurrencyRepository;
import com.sinno.ems.service.CurrencyService;
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
 * Created by Enissay on 22/12/2016.
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(CurrencyService.class);

    @Override
    public Currency save(Currency currency) {
        LOGGER.info("save Currency");
        currency.setUpdateDate(EmsDate.getDateNow());
        if (0 >= currency.getId()) {
            currency.setCreationDate(EmsDate.getDateNow());
        }
        return CurrencyMapper.toDto(currencyRepository.saveAndFlush(CurrencyMapper.toEntity(currency, false)), false);
    }

    @Override
    public Long size() {
        return currencyRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return currencyRepository.exists(id);
    }

    @Override
    public Currency findById(Long id) throws IdNotFound {
        Currency currency = CurrencyMapper.toDto(currencyRepository.findOne(id), false);
        if (null != currency) {
            return currency;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Currency> find(String search) throws AttributesNotFound, ErrorType {
        return CurrencyMapper.toDtos(currencyRepository.findAll(Search.expression(search, PrmCurrency.class)), false);
    }

    @Override
    public List<Currency> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "prmCurrencyUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return CurrencyMapper.toDtos(currencyRepository.findAll(Search.expression(search, PrmCurrency.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return currencyRepository.count(Search.expression(search, PrmCurrency.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Currency");
        currencyRepository.delete(id);
    }

    @Override
    public void delete(Currency currency) {
        LOGGER.info("delete Currency");
        currencyRepository.delete(CurrencyMapper.toEntity(currency, false));
    }

    @Override
    public List<Currency> findAll() {
        return CurrencyMapper.toDtos(currencyRepository.findAll(), false);
    }

    @Override
    public List<Currency> findAll(Pageable pageable) {
        return CurrencyMapper.toDtos(currencyRepository.findAll(pageable), false);
    }
}
