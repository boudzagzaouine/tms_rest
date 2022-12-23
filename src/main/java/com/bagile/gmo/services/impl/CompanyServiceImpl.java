package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Company;
import com.bagile.gmo.entities.CmdCompany;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.CompanyMapper;
import com.bagile.gmo.repositories.CompanyRepository;
import com.bagile.gmo.services.CompanyService;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    private SettingService settingService;
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company save(Company company) {
        return CompanyMapper.toDto(companyRepository.saveAndFlush(CompanyMapper.toEntity(company, false)), false);
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

