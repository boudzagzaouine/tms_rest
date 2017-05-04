package com.sinno.ems.controller;

import com.sinno.ems.dto.BankAccount;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(value = "/bankAccounts/")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PreAuthorize("hasAnyRole('BANK_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<BankAccount> getBankAccounts() throws AttributesNotFound, ErrorType {
        return bankAccountService.findAll();
    }

    @PreAuthorize("hasAnyRole('BANK_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<BankAccount> getBankAccounts(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
       return bankAccountService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('BANK_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        return bankAccountService.size();
    }

    @PreAuthorize("hasAnyRole('BANK_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        if (!search.endsWith(",")) {
            search += ",";
        }
         return bankAccountService.size(search);
    }

    @PreAuthorize("hasAnyRole('BANK_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return bankAccountService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('BANK_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public BankAccount getBankAccount(@PathVariable("id") Long id) throws IdNotFound {
        return bankAccountService.findById(id);
    }

    @PreAuthorize("hasAnyRole('BANK_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<BankAccount> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        if (!search.endsWith(",")) {
            search += ",";
        }


         return bankAccountService.find(search);
    }

    @PreAuthorize("hasAnyRole('BANK_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<BankAccount> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (!search.endsWith(",")) {
            search += ",";
        }
       return bankAccountService.find(search, page, size);
    }

    @PreAuthorize("hasRole('BANK_ACCOUNT_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BankAccount add(@RequestBody BankAccount bankAccount) {
        return bankAccountService.save(bankAccount);
    }

    @PreAuthorize("hasRole('BANK_ACCOUNT_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BankAccount set(@RequestBody BankAccount bankAccount) {
        return bankAccountService.save(bankAccount);
    }

    @PreAuthorize("hasRole('BANK_ACCOUNT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody BankAccount bankAccount) {
        bankAccountService.delete(bankAccount);
    }

    @PreAuthorize("hasRole('BANK_ACCOUNT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        bankAccountService.delete(id);
    }

}