package com.bagile.tms.services.impl;


import com.bagile.tms.dto.Account;
import com.bagile.tms.entities.CmdAccount;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.AccountMapper;
import com.bagile.tms.repositories.*;
import com.bagile.tms.services.AccountService;
import com.bagile.tms.services.SettingService;
import com.bagile.tms.util.AddActive;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService, AddActive {

    @Autowired
    private AccountRepository accountRepository;
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
    @Autowired
    private SettingService settingService;


    private final static Logger LOGGER = LoggerFactory
            .getLogger(AccountService.class);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");

    /**
     * create or updated account and generate file that will be imported by easyWms
     * @param account
     * @return
     */
    @Override
    public Account save(Account account) {
        LOGGER.info("saving Acount ");
        account.setUpdateDate(EmsDate.getDateNow());
        String operation = "F";
        if (0 >= account.getId()) {
            account.setCreationDate(EmsDate.getDateNow());
            operation = "A";
        }
        CmdAccount cmdAccount = accountRepository.saveAndFlush(AccountMapper.toEntity(account, false));
        account = AccountMapper.toDto(cmdAccount, false);

        return account;
    }



    /**
     * get the size of the records in account table
     *
     * @return
     */
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

    /**
     * check if id exist in database
     * @param id
     * @return
     */
    @Override
    public Boolean isExist(Long id) {
        return accountRepository.existsById(id);
    }

    /**
     * find entity by id
     * @param id
     * @return the entity if found
     * @throws IdNotFound
     */
    @Override
    public Account findById(Long id) throws IdNotFound {
        Account account = AccountMapper.toDto(accountRepository.findById(id).get(), false);
        if (null != account) {
            return account;
        } else {
            throw new IdNotFound(id);
        }
    }

    /**
     * find only one entity
     * @param search query
     * @return Account
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public Account findOne(String search) throws AttributesNotFound, ErrorType {
        List<Account> accounts = find(search);
        if (accounts != null && !accounts.isEmpty())
            return accounts.get(0);
        return null;
    }

    /**
     * find list of accounts
     * @param search query
     * @return List<Account>
     * @throws AttributesNotFound
     * @throws ErrorType
     */

    @Override
    public List<Account> find(String search) throws AttributesNotFound, ErrorType {
        search = addActiveToSearch(search);
        return AccountMapper.toDtos(accountRepository.findAll(Search.expression(search, CmdAccount.class)), false);
    }

    /**
     * find list of accounts with pagination
     * @param search query
     * @param page page number
     * @param size size of the page
     * @return List<Account>
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public List<Account> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        search = addActiveToSearch(search);
        Sort sort = new Sort(Sort.Direction.DESC, "cmdAccountUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return AccountMapper.toDtos(accountRepository.findAll(Search.expression(search, CmdAccount.class), pageable), false);
    }

    /**
     *  get the size of records for a search query
     * @param search search query
     * @return Long
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        search = addActiveToSearch(search);
        return accountRepository.count(Search.expression(search, CmdAccount.class));
    }

    /**
     * delete a record on the database
     * @param id the id that will be deleted
     */
    @Override
    public void delete(Long id) {
        LOGGER.info("delete account");
        CmdAccount cmdAccount = accountRepository.findById(id).get();
        cmdAccount.setCmdAccountIsActive(false);
        accountRepository.saveAndFlush(cmdAccount);
    }

    /**
     * delete a record on the database
     * @param account the account that will be deleted
     */
    @Override
    public void delete(Account account) {
        delete(account.getId());
    }

    /**
     * get all the records from the database
     * @return List<Account>
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public List<Account> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }
    /**
     * get all the records from the database with pagination
     * @return List<Account>
     * @param page page number
     * @param size page size
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public List<Account> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        LOGGER.info("list in account");
        return find("", page, size);
    }

}