package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.CommissionType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.CommissionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/commissiontypes")
public class CommissiontypeController {

    private final CommissionTypeService commissionTypeService;
    public CommissiontypeController(CommissionTypeService commissionTypeService) {
        this.commissionTypeService = commissionTypeService;
    }


   // @Qualifier("userDetailsService")
    //private UserDetailsServiceWarehouse userDetailsService;


    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<CommissionType> getCommissionTypes() throws AttributesNotFound, ErrorType {

        return commissionTypeService.findAll();
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<CommissionType> getCommissionTypes(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
               return commissionTypeService.findAll( page, size);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return commissionTypeService.size();
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {


        if (!search.endsWith(",")) {
            search += ",";
        }
        return commissionTypeService.size();
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return commissionTypeService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public CommissionType getCommissionType(@PathVariable("id") Long id) throws IdNotFound {
        return commissionTypeService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<CommissionType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

     /*   if (!search.endsWith(",")) {
            search += ",";
        }*/

        return commissionTypeService.find(search);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<CommissionType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        /*if (!search.endsWith(",")) {
            search += ",";
        }*/
        return commissionTypeService.find(search, page, size);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_CREATE','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CommissionType add(@RequestBody CommissionType contact) {
        return commissionTypeService.save(contact);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_EDIT','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CommissionType set(@RequestBody CommissionType contact) {
        return commissionTypeService.save(contact);
    }

    //@PreAuthorize("hasRole('CONTACT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody CommissionType contact) {

        commissionTypeService.delete(contact);
    }

    //@PreAuthorize("hasRole('CONTACT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) throws IdNotFound {
        commissionTypeService.delete(id);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        commissionTypeService.deleteAll (Arrays.asList(ids));
    }


}