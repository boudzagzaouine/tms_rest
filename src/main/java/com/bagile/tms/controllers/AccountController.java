package com.bagile.tms.controllers;

import com.bagile.tms.dto.Account;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.AccountService;
import com.bagile.tms.services.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/accounts/")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Account> getAccounts() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return accountService.find(userDetailsService.getOwners().toString());

        //  return accountService.findAll();
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Account> getAccounts(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }

        return accountService.find(userDetailsService.getOwners().toString(), page, size);
        // return accountService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return accountService.size(userDetailsService.getOwners().toString());
        //return accountService.size();
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return accountService.size(search + userDetailsService.getOwners().toString());

        // return accountService.size(search);
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return accountService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Account getAccount(@PathVariable("id") Long id) throws IdNotFound {
        return accountService.findById(id);
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Account> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return accountService.find(search + userDetailsService.getOwners().toString());

        // return accountService.find(search);
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_VIEW','DELIVERY_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Account> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return accountService.find(search + userDetailsService.getOwners().toString(), page, size);

        //  return accountService.find(search, pageable);
    }

    @PreAuthorize("hasRole('ACCOUNT_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Account add(@RequestBody Account account) {
        return accountService.save(account);
    }

    @PreAuthorize("hasRole('ACCOUNT_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Account set(@RequestBody Account account) {
        return accountService.save(account);
    }

    @PreAuthorize("hasRole('ACCOUNT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Account account) {

        accountService.delete(account);
    }

    @PreAuthorize("hasRole('ACCOUNT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        accountService.delete(id);
    }



}