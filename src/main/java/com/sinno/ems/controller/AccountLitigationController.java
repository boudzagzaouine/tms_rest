package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.AccountLitigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/accountLitigations/")
public class AccountLitigationController {

    @Autowired
    private AccountLitigationService accountLitigationService;

    //@PreAuthorize("hasyRole('ACCOUNT_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<AccountLitigation> getAccountLitigations() throws AttributesNotFound, ErrorType {

        return accountLitigationService.findAll();

        //  return accountLitigationService.findAll();
    }

    //@PreAuthorize("hasyRole('ACCOUNT_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<AccountLitigation> getAccountLitigations(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Pageable pageable= new PageRequest(page,size);

        return accountLitigationService.findAll(pageable);
        // return accountLitigationService.findAll(pageable);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return accountLitigationService.size();
        //return accountLitigationService.size();
    }

    //@PreAuthorize("hasyRole('ACCOUNT_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return accountLitigationService.size(search );

        // return accountLitigationService.size(search);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return accountLitigationService.isExist(id);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public AccountLitigation getAccountLitigation(@PathVariable("id") Long id) throws IdNotFound {
        return accountLitigationService.findById(id);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<AccountLitigation> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        return accountLitigationService.find(search);

        // return accountLitigationService.find(search);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<AccountLitigation> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return accountLitigationService.find(search  , page, size);

        //  return accountLitigationService.find(search, pageable);
    }

    //@PreAuthorize("hasRole('ACCOUNT_LITIGATION_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AccountLitigation add(@RequestBody AccountLitigation accountLitigation) {
        return accountLitigationService.save(accountLitigation);
    }

    //@PreAuthorize("hasRole('ACCOUNT_LITIGATION_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AccountLitigation set(@RequestBody AccountLitigation accountLitigation) {
        return accountLitigationService.save(accountLitigation);
    }

    //@PreAuthorize("hasRole('ACCOUNT_LITIGATION_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody AccountLitigation accountLitigation) {

        accountLitigationService.delete(accountLitigation);
    }

    //@PreAuthorize("hasRole('ACCOUNT_LITIGATION_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        accountLitigationService.delete(id);
    }
}