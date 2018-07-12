package com.sinno.ems.service.impl;

import com.sinno.ems.dto.*;
import com.sinno.ems.entities.CmdAccount;
import com.sinno.ems.entities.PrmContact;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.export.AccountExport;
import com.sinno.ems.mapper.*;
import com.sinno.ems.mapperWms.MapperAccount;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.AccountService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import com.sinno.wms.crud.convertbasic.ConvertManagerAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.io.File;
import java.lang.Exception;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MsgSendRepository msgSendRepository;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private AddressRepository addressRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AccountService.class);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
    @Autowired
    private SettingRepository settingRepository;

    @Override
    public Account save(Account account) {
        LOGGER.info("saving Acount ");
        account.setUpdateDate(EmsDate.getDateNow());
        if (0 >= account.getId()) {
            account.setCreationDate(EmsDate.getDateNow());
        }
        boolean syncWms = settingRepository.findOne(2L).getPrmSettingValue().equals("1") ? true : false;


        CmdAccount cmdAccount = accountRepository.saveAndFlush(AccountMapper.toEntity(account, false));
        account = AccountMapper.toDto(cmdAccount, false);
        //  Account account1= AccountMapper.toDto(accountRepository.saveAndFlush(AccountMapper.toEntity(account, false)), false);
        if (syncWms) {
            PrmMsgSend msgSend = getPrmMsgSend();
            if (null != msgSend && msgSend.isPrmMsgSendActive()) {

                try {
                    AccountExport.export(msgSend.getPrmMsgSendPath(), cmdAccount, "F", servletContext);
                } catch (Exception e) {
                    LOGGER.error(e.getMessage());

                    //e.printStackTrace();
                }

            }
            if (null != msgSend && msgSend.isPrmMsgSendActive() && "xls".equals(msgSend.getPrmMsgSendFormat().trim())) {
                writeFileAccount(msgSend.getPrmMsgSendPath(), account);
                writeFileAccount(msgSend.getPrmMsgSendArcPath(), account);
            }
        }
        return account;
    }

    private PrmMsgSend getPrmMsgSend() {
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:ACC", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator() && msgSends.iterator().hasNext()) {
                return msgSends.iterator().next();
            }
        } catch (AttributesNotFound attributesNotFound) {
            LOGGER.error(attributesNotFound.getMessage());
            ////attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            LOGGER.error(errorType.getMessage());
            // //e.printStackTrace();
        }
        return null;
    }

    private void writeFileAccount(String path, Account ac) {

        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "fr";
            com.sinno.wms.crud.modelbasic.accounts.Account account = com.sinno.ems.mapperWms.MapperAccount.convertToWmsDto(ac);
            ConvertManagerAccount.writeFileAccount(path + File.separator + "IAC01" + dateFormat.format(new Date()) + ".xls", langue, account);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private void writeFileAccount(String path, List<Account> accounts) {

        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "fr";
            List<com.sinno.wms.crud.modelbasic.accounts.Account> accountList = new ArrayList<>();
            for (Account ac : accounts) {
                accountList.add(com.sinno.ems.mapperWms.MapperAccount.convertToWmsDto(ac));
            }

            ConvertManagerAccount.writeFileAccount(path + File.separator + "IAC01" + dateFormat.format(new Date()) + ".xls", langue, accountList);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }

  /*  public void ReadFileAccount(com.sinno.wms.crud.modelbasic.accounts.Account acc) {
        try {
            acc = ConvertManagerAccount.readFileAccount("IAC01.xls"+ Calendar.getInstance().getTime()).get(0);
            Account account = new Account();
            account = MapperAccount.convertToEmsDto(acc);
            accountRepository.saveAndFlush(AccountMapper.toEntity(account, false));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }   */


    @Override
    public Long size() {
        try {
            return size("");
        } catch (AttributesNotFound attributesNotFound) {
            ////attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public Boolean isExist(Long id) {
        return accountRepository.exists(id);
    }

    @Override
    public Account findById(Long id) throws IdNotFound {
        Account account = AccountMapper.toDto(accountRepository.findOne(id), false);
        if (null != account) {
            return account;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Account> find(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return AccountMapper.toDtos(accountRepository.findAll(Search.expression(search, CmdAccount.class)), false);
    }

    @Override
    public List<Account> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "cmdAccountUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return AccountMapper.toDtos(accountRepository.findAll(Search.expression(search, CmdAccount.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return accountRepository.count(Search.expression(search, CmdAccount.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete account");
        CmdAccount cmdAccount = accountRepository.findOne(id);
        cmdAccount.setCmdAccountIsActive(false);
        accountRepository.saveAndFlush(cmdAccount);
    }

    @Override
    public void delete(Account account) {
        LOGGER.info("delete account");
        CmdAccount cmdAccount = accountRepository.findOne(account.getId());
        cmdAccount.setCmdAccountIsActive(false);
        accountRepository.saveAndFlush(cmdAccount);
        //accountRepository.delete(AccountMapper.toEntity(account, false));
        PrmMsgSend msgSend = null;
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search.expression("fileType:ACC", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator() && msgSends.iterator().hasNext()) {
                msgSend = msgSends.iterator().next();
            }
        } catch (AttributesNotFound attributesNotFound) {
            ////attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        if (null != msgSend && msgSend.isPrmMsgSendActive()) {
            try {
                AccountExport.export(msgSend.getPrmMsgSendPath(), cmdAccount, "M", servletContext);
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                //e.printStackTrace();
            }
        }
    }

    @Override
    public List<Account> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<Account> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        LOGGER.info("list in account");
        return find("", page, size);
    }

    @Override
    @Transactional
    public Account loadWmsAccount(com.sinno.wms.crud.modelbasic.accounts.Account account) {

        Contact contact = null;
        Company company = CompanyMapper.toDto(companyRepository.findByCmdCompanyCode(account.getCustomer_company()), false);
        Transport transport = TransportMapper.toDto(transportRepository.findByTrpTransportCode(account.getCarrier_code()), false);
        Address address = AddressMapper.toDto(addressRepository.findByAdrAddressCode(account.getAddress()), false);
        Owner owner = OwnerMapper.toDto(ownerRepository.findByOwnOwnerCode(account.getOwner_code()), false);
        CmdAccount cmdAccount = accountRepository.findByCmdAccountCode(account.getAccount_code());
        String s = "name:" + account.getContact_name() + ",surName:" + account.getContact_surname() + ",email:" + account.getEmail() + ",owner.code:" + owner.getCode();
        try {
            contact = ContactMapper.toDto(contactRepository.findOne(Search.expression(s, PrmContact.class)), false);
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }

        Account acc = null;
        if (null != cmdAccount) {
            acc = AccountMapper.toDto(cmdAccount, false);
        } else {
            acc = new Account();
            acc.setCreationDate(EmsDate.getDateNow());
        }
        if (null == contact) {
            contact = new Contact();
            contact.setName(account.getContact_name());
            contact.setTel1(account.getTelephone());
            contact.setFax(account.getFax());
            contact.setContactType(3L);
            contact.setOwner(owner);
            contact.setSurName(account.getContact_surname());
            contact.setCreationDate(EmsDate.getDateNow());
            contact.setActive(true);
            contact = ContactMapper.toDto(contactRepository.saveAndFlush(ContactMapper.toEntity(contact, false)), false);
        }
        if (null == address) {
            address = new Address();
            address.setCode(account.getAddress());
            address.setCreationDate(EmsDate.getDateNow());
            address.setUpdateDate(EmsDate.getDateNow());
            address.setZip(account.getPostal_code());
            address.setLine1(account.getAddress_line1());
            address.setLine2(account.getAddress_line2());
            address.setCity(account.getCity());
            address.setCountry(account.getCountry());
            address.setOwner(owner);
            address = AddressMapper.toDto(addressRepository.saveAndFlush(AddressMapper.toEntity(address, false)), false);
        }

        if (null != acc) {
            acc = MapperAccount.convertToEmsDto(acc, account);
            acc.setUpdateDate(EmsDate.getDateNow());
            acc.setTransport(transport);
            acc.setContact(contact);
            acc.setCompany(company);
            acc.setActive(true);
            acc.setOwner(owner);
            acc.setAddressByAccountDeliveryAddress(address);
            acc = AccountMapper.toDto(accountRepository.saveAndFlush(AccountMapper.toEntity(acc, false)), false);
            return acc;
        }
        return null;
    }

    @Override
    public List<Account> exportWmsAccount(List<Account> accounts) {
        writeFileAccount(null != getPrmMsgSend() ? getPrmMsgSend().getPrmMsgSendPath() : System.getenv("APPDATA"), accounts);
        return accounts;
    }
    @Override
    public Account login(String code,String password){
        return AccountMapper.toDto(accountRepository.findByCmdAccountCodeAndCmdAccountPassword(code,password),false);
    }
}