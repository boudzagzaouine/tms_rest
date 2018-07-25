package com.bagile.tms.controllers;

import com.bagile.tms.dto.Company;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.CompanyService;
import com.bagile.tms.services.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/companys/")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @Qualifier("userDetailsService")
    @Autowired
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasAnyRole('COMPANY_VIEW','ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Company> getCompanys() throws AttributesNotFound, ErrorType {

        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return companyService.find(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('COMPANY_VIEW','ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Company> getCompanys(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "cmdCompanyUpdateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return companyService.find(userDetailsService.getOwners().toString(), pageable);
    }

    @PreAuthorize("hasAnyRole('COMPANY_VIEW','ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return companyService.size(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('COMPANY_VIEW','ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return companyService.size(search + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('COMPANY_VIEW','ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return companyService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('COMPANY_VIEW','ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Company getCompany(@PathVariable("id") Long id) throws IdNotFound {
        return companyService.findById(id);
    }

    @PreAuthorize("hasAnyRole('COMPANY_VIEW','ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Company> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return companyService.find(search+ userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('COMPANY_VIEW','ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Company> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return companyService.find(search+ userDetailsService.getOwners().toString(), pageable);
    }

    @PreAuthorize("hasRole('COMPANY_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Company add(@RequestBody Company company) {
        return companyService.save(company);
    }

    @PreAuthorize("hasRole('COMPANY_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Company set(@RequestBody Company company) {
        return companyService.save(company);
    }

    @PreAuthorize("hasRole('COMPANY_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Company company) {

        companyService.delete(company);
    }

    @PreAuthorize("hasRole('COMPANY_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        companyService.delete(id);
    }
}