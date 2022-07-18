package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.ContractAccount;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.ContractAccountService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/contractaccounts")
public class ContractAccountController {

    private final ContractAccountService contractAccountService;

    public ContractAccountController(ContractAccountService contractAccountService) {
        this.contractAccountService = contractAccountService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<ContractAccount> getAll() {
        return contractAccountService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ContractAccount> getAll(@RequestParam int page, @RequestParam int size) {
        return contractAccountService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public ContractAccount getOne(@PathVariable("id") Long id) throws IdNotFound {
        return contractAccountService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return contractAccountService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return contractAccountService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return contractAccountService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ContractAccount> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return contractAccountService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ContractAccount> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return contractAccountService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ContractAccount add(@RequestBody ContractAccount contractAccount) {
        return contractAccountService.save(contractAccount);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ContractAccount set(@RequestBody ContractAccount contractAccount) {
        return contractAccountService.save(contractAccount);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ContractAccount contractAccount) {
        contractAccountService.delete(contractAccount);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        contractAccountService.delete(id);
    }




}
