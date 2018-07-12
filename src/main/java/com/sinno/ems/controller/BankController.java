package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/banks/")
public class BankController {

    @Autowired
    private BankService bankService;

    @PreAuthorize("hasAnyRole('BANK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Bank> getBanks() throws AttributesNotFound, ErrorType {
          return bankService.findAll();
    }

    @PreAuthorize("hasAnyRole('BANK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Bank> getBanks(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return bankService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('BANK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

      return bankService.size();
    }

    @PreAuthorize("hasAnyRole('BANK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return bankService.size(search);
    }

    @PreAuthorize("hasAnyRole('BANK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return bankService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('BANK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Bank getBank(@PathVariable("id") Long id) throws IdNotFound {
        return bankService.findById(id);
    }

    @PreAuthorize("hasAnyRole('BANK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Bank> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return bankService.find(search);
    }

    @PreAuthorize("hasAnyRole('BANK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Bank> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        if (!search.endsWith(",")) {
            search += ",";
        }

        return bankService.find(search, page,size);
    }

    @PreAuthorize("hasRole('BANK_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Bank add(@RequestBody Bank bank) {
        return bankService.save(bank);
    }

    @PreAuthorize("hasRole('BANK_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Bank set(@RequestBody Bank bank) {
        return bankService.save(bank);
    }

    @PreAuthorize("hasRole('BANK_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Bank bank) {

        bankService.delete(bank);
    }

    @PreAuthorize("hasRole('BANK_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        bankService.delete(id);
    }

}