package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Printer;
import com.sinno.ems.entities.PrmPrinter;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.PrinterMapper;
import com.sinno.ems.repositories.PrinterRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.PrinterService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 03/08/2016.
 */
@Service
public class PrinterServiceImpl implements PrinterService {
    @Autowired
    private PrinterRepository printerRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PrinterService.class);

    @Override
    public Printer save(Printer printer) {
       LOGGER.info("save Printer");
        return PrinterMapper.toDto(printerRepository.saveAndFlush(PrinterMapper.toEntity(printer, false)), false);
    }

    @Override
    public Long size() {
        return printerRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return printerRepository.exists(id);
    }

    @Override
    public Printer findById(Long id) throws IdNotFound {
        Printer printer = PrinterMapper.toDto(printerRepository.findOne(id), false);
        if (null != printer) {
            return printer;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Printer> find(String search) throws AttributesNotFound, ErrorType {
        return PrinterMapper.toDtos(printerRepository.findAll(Search.expression(search, PrmPrinter.class)), false);
    }

    @Override
    public List<Printer> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return PrinterMapper.toDtos(printerRepository.findAll(Search.expression(search, PrmPrinter.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return printerRepository.count(Search.expression(search, PrmPrinter.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Printer");
        printerRepository.delete(id);
    }

    @Override
    public void delete(Printer printer) {
        LOGGER.info("delete Printer");
        printerRepository.delete(PrinterMapper.toEntity(printer, false));
    }

    @Override
    public List<Printer> findAll() {
        return PrinterMapper.toDtos(printerRepository.findAll(), false);
    }

    @Override
    public List<Printer> findAll(Pageable pageable) {
        return PrinterMapper.toDtos(printerRepository.findAll(pageable), false);
    }
}
