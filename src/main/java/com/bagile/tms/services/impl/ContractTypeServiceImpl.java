package com.bagile.tms.services.impl;

import com.bagile.tms.dto.ContractType;
import com.bagile.tms.entities.TmsContractType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.ContractTypeMapper;
import com.bagile.tms.repositories.ContractTypeRepository;
import com.bagile.tms.services.ContractTypeService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContractTypeServiceImpl implements ContractTypeService {

    @Autowired
    private ContractTypeRepository contractTypeRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ContractTypeService.class);


    @Override
    public ContractType save(ContractType contractType) {
        LOGGER.info("save Contract Type");


        return ContractTypeMapper.toDto(contractTypeRepository.saveAndFlush(ContractTypeMapper.toEntity(contractType, false)), false);

    }

    @Override
    public Long size() {
        return contractTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return contractTypeRepository.existsById(id);
    }

    @Override
    public ContractType findById(Long id) throws IdNotFound {
        ContractType contractType = ContractTypeMapper.toDto(contractTypeRepository.findById(id).get(), false);
        if (null != contractType) {
            return contractType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ContractType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.isBlank ()){
            return findAll ();
        }
        return ContractTypeMapper.toDtos(contractTypeRepository.findAll(Search.expression(search, TmsContractType.class)), false);

    }

    @Override
    public List<ContractType> find(String search, int page,int size) throws AttributesNotFound, ErrorType {
        if (search.isBlank ()){
            return findAll (page, size);
        }
        Pageable pageable= PageRequest.of(page,size);
        return ContractTypeMapper.toDtos(contractTypeRepository.findAll(Search.expression(search, TmsContractType.class), pageable), false);
    }

    @Override
    public ContractType findOne(String search) throws AttributesNotFound, ErrorType {
        return ContractTypeMapper.toDto(contractTypeRepository.findOne(Search.expression(search, TmsContractType.class)).get(), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.isBlank ()){
            return size ();
        }
        return contractTypeRepository.count(Search.expression(search, TmsContractType.class));

    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Contract Type");
        contractTypeRepository.deleteById(id);
    }

    @Override
    public void delete(ContractType contractType) {
        LOGGER.info("delete Contract Type");
        contractTypeRepository.delete(ContractTypeMapper.toEntity(contractType, false));
    }

    @Override
    public List<ContractType> findAll() throws AttributesNotFound, ErrorType {
        return ContractTypeMapper.toDtos(contractTypeRepository.findAll(), false);
    }

    @Override
    public List<ContractType> findAll(int page,int size) throws AttributesNotFound, ErrorType {
        Pageable pageable=PageRequest.of(page,size);
        return ContractTypeMapper.toDtos(contractTypeRepository.findAll(pageable), false);

    }
}
