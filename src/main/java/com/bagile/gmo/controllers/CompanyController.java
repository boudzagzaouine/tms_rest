package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Company;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.CompanyService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/companys")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Company> getCompanys() {return companyService.findAll();}
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Company> getCompany(@RequestParam int page, @RequestParam int size) {
        return companyService.findAll(page, size);

    }
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return companyService.size();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return companyService.size(search);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return companyService.isExist(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Company getCompany(@PathVariable("id") Long id) throws IdNotFound {
        return companyService.findById(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Company> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return companyService.find(search);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Company> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return companyService.find(search, page, size);

    }
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Company add(@RequestBody Company company ) throws ErrorType, AttributesNotFound {
        return companyService.save(company);}
    //@PreAuthorize("hasRole('BADGETYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Company set(@RequestBody Company company) throws ErrorType, AttributesNotFound {
        return companyService.save(company);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Company company) {

        companyService.delete(company);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        companyService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        companyService.deleteAll (Arrays.asList(ids));
    }


    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal()
    {
        return  companyService.getNextVal();
    }
}