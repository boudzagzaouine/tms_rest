package com.sinno.ems.service;

import com.sinno.ems.dto.Container;
import com.sinno.ems.exception.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReceptionStockService {

    public ReceptionStock save(ReceptionStock receptionStock) throws AttributesNotFound, ErrorType, ContainerException, ProductControls;

    public Long size();

    public Boolean isExist(Long id);

    public ReceptionStock findById(Long id) throws IdNotFound;

    public List<ReceptionStock> find(String search) throws AttributesNotFound, ErrorType;

    public List<ReceptionStock> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(ReceptionStock receptionStock);

    public List<ReceptionStock> findAll();

    public List<ReceptionStock> findAll(Pageable pageable);

    Container checkContainer(ReceptionStock receptionStock);
}