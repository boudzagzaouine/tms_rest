package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ContractAccount;
import com.bagile.gmo.entities.TmsContractAccount;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ContractAccountMapper;
import com.bagile.gmo.repositories.ContractAccountRepository;
import com.bagile.gmo.services.ContractAccountService;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContractAccountServiceImpl implements ContractAccountService {

    private final ContractAccountRepository contractAccountRepository;
    @Autowired
    private SettingService settingService;
    public ContractAccountServiceImpl(ContractAccountRepository contractAccountRepository) {
        this.contractAccountRepository = contractAccountRepository;
    }

    @Override
    public ContractAccount save(ContractAccount contractAccount) {
        return ContractAccountMapper.toDto(contractAccountRepository.saveAndFlush(ContractAccountMapper.toEntity(contractAccount, false)), false);
    }

    @Override
    public Long size() {
        return contractAccountRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return contractAccountRepository.existsById(id);
    }

    @Override
    public ContractAccount findById(Long id) throws IdNotFound {
        return ContractAccountMapper.toDto(contractAccountRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public ContractAccount findByCode(String code) {
        return null;
    }

    @Override
    public List<ContractAccount> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ContractAccountMapper.toDtos(contractAccountRepository.findAll(Search.expression(search, TmsContractAccount.class)), false);
    }

    @Override
    public List<ContractAccount> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size);
        return ContractAccountMapper.toDtos(contractAccountRepository.findAll(Search.expression(search, TmsContractAccount.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return contractAccountRepository.count(Search.expression(search, TmsContractAccount.class));
    }

    @Override
    public void delete(Long id) {
        contractAccountRepository.deleteById(id);
    }

    @Override
    public void delete(ContractAccount contractAccount) {
        contractAccountRepository.delete(ContractAccountMapper.toEntity(contractAccount, false));
    }

    @Override
    public ContractAccount findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public List<ContractAccount> findAll() {
        return ContractAccountMapper.toDtos(contractAccountRepository.findAll(), false);
    }

    @Override
    public List<ContractAccount> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ContractAccountMapper.toDtos(contractAccountRepository.findAll(pageable), false);
    }

    @Override
    public String getNextVal() {
        String value="CC" + contractAccountRepository.getNextVal().get(0);
        return value;
    }

}

