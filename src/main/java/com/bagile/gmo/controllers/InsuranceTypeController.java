package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.InsuranceType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.InsuranceTypeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/insurancetypes")
public class InsuranceTypeController {

    private final InsuranceTypeService insuranceTypeService;

    public InsuranceTypeController(InsuranceTypeService insuranceTypeService) {
        this.insuranceTypeService = insuranceTypeService;
    }


   // @Qualifier("userDetailsService")
    //private UserDetailsServiceWarehouse userDetailsService;


    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<InsuranceType> getInsuranceTypes() throws AttributesNotFound, ErrorType {

        return insuranceTypeService.findAll();
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<InsuranceType> getInsuranceTypes(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
               return insuranceTypeService.findAll( page, size);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return insuranceTypeService.size();
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {


       /* if (!search.endsWith(",")) {
            search += ",";
        }*/
        return insuranceTypeService.size();
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return insuranceTypeService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public InsuranceType getCommissionType(@PathVariable("id") Long id) throws IdNotFound {
        return insuranceTypeService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<InsuranceType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

       /* if (!search.endsWith(",")) {
            search += ",";
        }*/

        return insuranceTypeService.find(search);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<InsuranceType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        /*if (!search.endsWith(",")) {
            search += ",";
        }*/
        return insuranceTypeService.find(search, page, size);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_CREATE','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InsuranceType add(@RequestBody InsuranceType contact) {
        return insuranceTypeService.save(contact);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_EDIT','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InsuranceType set(@RequestBody InsuranceType contact) {
        return insuranceTypeService.save(contact);
    }

    //@PreAuthorize("hasRole('CONTACT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody InsuranceType contact) {

        insuranceTypeService.delete(contact);
    }

    //@PreAuthorize("hasRole('CONTACT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) throws IdNotFound {
        insuranceTypeService.delete(id);
    }
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        insuranceTypeService.deleteAll (Arrays.asList(ids));
    }
}