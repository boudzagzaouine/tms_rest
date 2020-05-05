package com.bagile.gmo.services;

import com.bagile.gmo.dto.ContractType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
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
    void deleteAll (List<Long> ids);

    List<ContractType> findAll() throws AttributesNotFound, ErrorType;

    List<ContractType> findAll(int page,int size) throws AttributesNotFound, ErrorType;



}
