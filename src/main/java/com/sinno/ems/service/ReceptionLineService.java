package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReceptionLineService {

    public ReceptionLine save(ReceptionLine receptionLine) throws ProductControls;

    public Long size();

    public Boolean isExist(Long id);

    public ReceptionLine findById(Long id) throws IdNotFound;

    public List<ReceptionLine> find(String search) throws AttributesNotFound, ErrorType;

    public List<ReceptionLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(ReceptionLine receptionLine);

    public List<ReceptionLine> findAll();

    public List<ReceptionLine> findAll(Pageable pageable);

    ReceptionLine loadWmsReceptionLine(com.sinno.wms.crud.modelbasic.receptions.ReceptionLine receptionLine);
}