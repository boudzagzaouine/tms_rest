package com.bagile.tms.services;

import com.bagile.tms.dto.ContractType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractTypeService {

    ContractType save(ContractType contractType);

    Long size();

    Boolean isExist(Long id);

    ContractType findById(Long id) throws IdNotFound;

    List<ContractType> find(String search) throws AttributesNotFound, ErrorType;

    List<ContractType> find(String search, int page,int size) throws AttributesNotFound, ErrorType;

    ContractType findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ContractType contractType);

    List<ContractType> findAll() throws AttributesNotFound, ErrorType;

    List<ContractType> findAll(int page,int size) throws AttributesNotFound, ErrorType;



}
