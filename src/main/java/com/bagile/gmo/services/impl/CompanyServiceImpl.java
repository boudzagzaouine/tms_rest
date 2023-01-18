package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Address;
import com.bagile.gmo.dto.Company;
import com.bagile.gmo.entities.CmdCompany;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.CompanyMapper;
import com.bagile.gmo.repositories.CompanyRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.Search;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    private SettingService settingService;
    @Autowired
    private AddressService addressService;

    @Autowired
    private AccountPricingService accountPricingService;

    @Autowired
    private AccountServiceService accountServiceService;
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public Company save(Company company) throws ErrorType, AttributesNotFound {

        if(company.getAddress()!=null){
            Address address= this.addressService.save(company.getAddress());
            company.setAddress(address);
        }
        Company company1 = CompanyMapper.toDto(companyRepository.saveAndFlush(CompanyMapper.toEntity(company, false)), false);
        if(company.getId()<=0) {
            if (company.getAccountPricingList() != null) {
                company.getAccountPricingList().forEach(
                        element -> element.setCompany(company1)
                );
                this.accountPricingService.saveAll(company.getAccountPricingList());
            }

            if (company.getAccountServiceList() != null) {
                company.getAccountServiceList().forEach(
                        element -> element.setCompany(company1)
                );
                this.accountServiceService.saveAll(company.getAccountServiceList());
            }
        }
        return company1;
    }

    @Override
    public Long size() {
        return companyRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return companyRepository.existsById(id);
    }

    @Override
    public Company findById(Long id) throws IdNotFound {
        return CompanyMapper.toDto(companyRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Company> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return CompanyMapper.toDtos(companyRepository.findAll(Search.expression(search, CmdCompany.class)), false);
    }

    @Override
    public List<Company> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CompanyMapper.toDtos(companyRepository.findAll(Search.expression(search, CmdCompany.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return companyRepository.count(Search.expression(search, CmdCompany.class));
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public void delete(Company company) {
        companyRepository.delete(CompanyMapper.toEntity(company, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            companyRepository.deleteById(id);        }
    }


    @Override
    public List<Company> findAll()
    {
        return CompanyMapper.toDtos(companyRepository.findAll(), false);
    }

    @Override
    public List<Company> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CompanyMapper.toDtos(companyRepository.findAll(pageable), false);
    }

    @Override
    public String getNextVal() {
        String value="CMP" + companyRepository.getNextVal().get(0);
        return value;
    }

}

