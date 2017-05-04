package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Address;
import com.sinno.ems.dto.Company;
import com.sinno.ems.dto.Owner;
import com.sinno.ems.entities.CmdCompany;
import com.sinno.ems.entities.PrmMsgSend;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.AddressMapper;
import com.sinno.ems.mapper.CompanyMapper;
import com.sinno.ems.mapper.OwnerMapper;
import com.sinno.ems.mapperWms.MapperCompany;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.CompanyService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import com.sinno.wms.crud.convertbasic.ConvertManagerCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private MsgSendRepository msgSendRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private AddressRepository addressRepository;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(CompanyService.class);
    @Autowired
    private SettingRepository settingRepository;


    @Override
    public Company save(Company company) {
        LOGGER.info("save Company");
        company.setUpdateDate(EmsDate.getDateNow());
        boolean syncWms = settingRepository.findOne(2L).getPrmSettingValue().equals("1") ? true : false;


        if (0 >= company.getId()) {
            company.setCreationDate(EmsDate.getDateNow());
        }

        company = CompanyMapper.toDto(companyRepository.saveAndFlush(CompanyMapper.toEntity(company, false)), false);
        if (syncWms) {
            PrmMsgSend msgSend = getPrmMsgSend();
            if (null != msgSend && msgSend.isPrmMsgSendActive() && "xls".equals(msgSend.getPrmMsgSendFormat().trim())) {

                writeFileCompany(msgSend.getPrmMsgSendPath(), company);
                writeFileCompany(msgSend.getPrmMsgSendArcPath(), company);
            }
        }
        return company;
    }

    private PrmMsgSend getPrmMsgSend() {
        PrmMsgSend msgSend;
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:CMP", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator()) {
                if (msgSends.iterator().hasNext()) {
                    msgSend = msgSends.iterator().next();
                    return msgSend;
                }
            }
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        return null;
    }

    private void writeFileCompany(String path, Company cm) {

        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";
            com.sinno.wms.crud.modelbasic.companies.Company company = com.sinno.ems.mapperWms.MapperCompany.convertToWmsDto(cm);
            ConvertManagerCompany.writeFileCompany(path + File.separator + "ICP01" + dateFormat.format(new Date()) + ".xls", langue, company);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void writeFileCompany(String path, List<Company> companies) {

        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";
            List<com.sinno.wms.crud.modelbasic.companies.Company> companyList = new ArrayList<>();
            for (Company cm : companies) {
                companyList.add(com.sinno.ems.mapperWms.MapperCompany.convertToWmsDto(cm));
            }
            ConvertManagerCompany.writeFileCompany(path + File.separator + "ICP01" + dateFormat.format(new Date()) + ".xls", langue, companyList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void readFileCompany(com.sinno.wms.crud.modelbasic.companies.Company comp) {
        try {
            comp = ConvertManagerCompany.readFileCompany("ICP01.xls").get(0);
            Company company = new Company();
            company = MapperCompany.convertToEmsDto(company, comp);
            companyRepository.saveAndFlush(CompanyMapper.toEntity(company, false));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Long size() {
        return companyRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return companyRepository.exists(id);
    }

    @Override
    public Company findById(Long id) throws IdNotFound {
        Company company = CompanyMapper.toDto(companyRepository.findOne(id), false);
        if (null != company) {
            return company;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Company> find(String search) throws AttributesNotFound, ErrorType {
        return CompanyMapper.toDtos(companyRepository.findAll(Search.expression(search, CmdCompany.class)), false);
    }

    @Override
    public List<Company> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return CompanyMapper.toDtos(companyRepository.findAll(Search.expression(search, CmdCompany.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return companyRepository.count(Search.expression(search, CmdCompany.class));
    }

    @Override
    public void delete(Long id) {
        companyRepository.delete(id);
    }

    @Override
    public void delete(Company company) {
        LOGGER.info("delete Company");
        companyRepository.delete(CompanyMapper.toEntity(company, false));
    }

    @Override
    public List<Company> findAll() {
        LOGGER.info("delete Company");
        return CompanyMapper.toDtos(companyRepository.findAll(), false);
    }

    @Override
    public List<Company> findAll(Pageable pageable) {
        return CompanyMapper.toDtos(companyRepository.findAll(pageable), false);
    }

    @Override
    @Transactional
    public Company loadWmsCompany(com.sinno.wms.crud.modelbasic.companies.Company company) {
        Company emsCompany = CompanyMapper.toDto(companyRepository.findByCmdCompanyCode(company.getCompany_code()), false);
        Owner owner = OwnerMapper.toDto(ownerRepository.findByOwnOwnerCode(company.getOwner_code()), false);
        Address address = AddressMapper.toDto(addressRepository.findByAdrAddressCode(company.getBilling_address_code()), false);
        if (null == emsCompany) {
            emsCompany = new Company();
            emsCompany.setCreationDate(EmsDate.getDateNow());

        }
        if (null == address) {
            address = new Address();
            address.setCode(company.getBilling_address_code());
            address.setLine1(company.getBilling_address_line1());
            address.setLine1(company.getBilling_address_line2());
            address.setCity(company.getBilling_city());
            address.setCountry(company.getBilling_country());
            address.setOwner(owner);
            address = AddressMapper.toDto(addressRepository.saveAndFlush(AddressMapper.toEntity(address, false)), false);
        }
        if (null != emsCompany) {
            emsCompany = MapperCompany.convertToEmsDto(emsCompany, company);
            emsCompany.setUpdateDate(EmsDate.getDateNow());
            emsCompany.setOwner(owner);
            emsCompany.setAddress(address);
            emsCompany = CompanyMapper.toDto(companyRepository.saveAndFlush(CompanyMapper.toEntity(emsCompany, false)), false);
            return emsCompany;
        }
        return null;

    }

    @Override
    public List<Company> exportWmsCompany(List<Company> companies) {
        writeFileCompany(null != getPrmMsgSend() ? getPrmMsgSend().getPrmMsgSendPath() : System.getenv("APPDATA"), companies);
        return companies;
    }

}