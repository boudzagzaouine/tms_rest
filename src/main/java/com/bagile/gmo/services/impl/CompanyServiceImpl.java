package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Account;
import com.bagile.gmo.dto.Address;
import com.bagile.gmo.dto.Company;
import com.bagile.gmo.entities.CmdCompany;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.importModels.CompanyImport;
import com.bagile.gmo.mapper.CompanyMapper;
import com.bagile.gmo.repositories.CompanyRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private AccountPricingServiceService accountServiceService;

    @Autowired
    private PaysService paysService ;
    @Autowired
    private VilleService villeService ;

    @Autowired
    private OwnerService ownerService;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    private final static Logger LOGGER = LoggerFactory
            .getLogger(Address.class);

    //@Transactional()
    @Override
    public Company save(Company company) throws ErrorType, AttributesNotFound {

        //if(!(company.getAddress().getId()>0)) {
        if((company.getAddress().getLine1())!=null) {

            Address address= addressService.save(company.getAddress());
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
    public List<Company> saveAll(List<Company> companies) throws AttributesNotFound, ErrorType {

        List<Company> companyList = new ArrayList<>();

        for (Company company : companies) {
            companyList.add(save(company));
        }

        return companyList;

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
    public void delete(Long id) throws IdNotFound, ErrorType, AttributesNotFound {


        Company company=  find("id:"+id).stream().findFirst().orElse(null);
        companyRepository.deleteById(id);
        if(company!=null) {
            if (company.getAddress() != null) {
                addressService.delete(company.getAddress().getId());
            }
        }

    }

    @Override
    public void delete(Company company) {
        companyRepository.delete(CompanyMapper.toEntity(company, false));
    }


    @Override
    public void deleteAll(List<Long> ids) throws IdNotFound, ErrorType, AttributesNotFound {

        for (Long id : ids) {
            delete(id);        }
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


    @Override
    public List<Company> loadingDataImport(List<CompanyImport> companyImports) throws ErrorType, AttributesNotFound, IdNotFound {
        List<Company> companyList = new ArrayList<>();
        List<Company> companyAdd = new ArrayList<>();
        Company company = new Company();

        for (CompanyImport companyImport : companyImports) {

                company =(find("code:" + companyImport.getCompany_code())).stream().findFirst().orElse(new Company());

                Address  address = new Address();
                address.setLine1(companyImport.getCompany_line1_address());
                address.setLine2(companyImport.getCompany_line2_address());
                address.setName(companyImport.getCompany_name());
                address.setCode(companyImport.getCompany_name());
                address.setZip(companyImport.getCompany_zip_address());
                address.setPays((paysService.find("code~" + companyImport.getCompany_country_address())).stream().findFirst().orElse(null));
                address.setVille((villeService.find("code~" + companyImport.getCompany_city_address())).stream().findFirst().orElse(null));
                address.setAddressType(2L);
                Address address1 = addressService.save(address);

                company.setCode(companyImport.getCompany_code());
                company.setName(companyImport.getCompany_name());

                company.setAddress(address1);
                company.setFiscalIdentifier(companyImport.getCompany_fiscalIdentifier());
                company.setTelephone(companyImport.getCompany_telephone());
                company.setTradeRegister(companyImport.getCompany_tradeRegister());
                company.setCommonIdentifierOfCompany(companyImport.getCompany_commonIdentifierOfCompany());
                company.setOwner(ownerService.findById(1L));


                companyList.add(save(company));


        }
           companyAdd = saveAll(companyList);


        return     companyAdd;


    }

}

