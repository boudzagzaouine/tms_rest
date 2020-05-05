package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.InsuranceTermLigne;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.InsuranceTermLigneService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/insurancetermlignes")
public class InsuranceTermLigneController {

    private final InsuranceTermLigneService insuranceTermLigneService;


    public InsuranceTermLigneController(InsuranceTermLigneService insuranceTermLigneService) {
        this.insuranceTermLigneService = insuranceTermLigneService;
    }


   // @Qualifier("userDetailsService")
    //private UserDetailsServiceWarehouse userDetailsService;


    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<InsuranceTermLigne> getInsuranceTermInsurances() throws AttributesNotFound, ErrorType {

        return insuranceTermLigneService.findAll();
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<InsuranceTermLigne> getInsuranceTermInsurances(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
               return insuranceTermLigneService.findAll( page, size);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return insuranceTermLigneService.size();
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {


        if (!search.endsWith(",")) {
            search += ",";
        }
        return insuranceTermLigneService.size();
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return insuranceTermLigneService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public InsuranceTermLigne getInsuranceTermInsurance(@PathVariable("id") Long id) throws IdNotFound {
        return insuranceTermLigneService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<InsuranceTermLigne> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        if (!search.endsWith(",")) {
            search += ",";
        }

        return insuranceTermLigneService.find(search);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<InsuranceTermLigne> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        if (!search.endsWith(",")) {
            search += ",";
        }
        return insuranceTermLigneService.find(search, page, size);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_CREATE','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InsuranceTermLigne add(@RequestBody InsuranceTermLigne contact) {
        return insuranceTermLigneService.save(contact);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_EDIT','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InsuranceTermLigne set(@RequestBody InsuranceTermLigne contact) {
        return insuranceTermLigneService.save(contact);
    }

    //@PreAuthorize("hasRole('CONTACT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody InsuranceTermLigne contact) {

        insuranceTermLigneService.delete(contact);
    }

    //@PreAuthorize("hasRole('CONTACT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) throws IdNotFound {
        insuranceTermLigneService.delete(id);
    }

}