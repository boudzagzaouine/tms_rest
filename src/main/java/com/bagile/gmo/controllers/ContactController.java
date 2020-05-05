package com.bagile.tms.controllers;

import com.bagile.gmo.dto.Contact;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/contacts")
public class ContactController {

    private final ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


   // @Qualifier("userDetailsService")
    //private UserDetailsServiceWarehouse userDetailsService;


    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Contact> getContacts() throws AttributesNotFound, ErrorType {

        return contactService.findAll();
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Contact> getContacts(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
               return contactService.findAll( page, size);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return contactService.size();
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {


        if (!search.endsWith(",")) {
            search += ",";
        }
        return contactService.size();
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return contactService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Contact getContact(@PathVariable("id") Long id) throws IdNotFound {
        return contactService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Contact> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        if (!search.endsWith(",")) {
            search += ",";
        }

        return contactService.find(search);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Contact> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        if (!search.endsWith(",")) {
            search += ",";
        }
        return contactService.find(search, page, size);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_CREATE','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Contact add(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    //@PreAuthorize("hasAnyRole('CONTACT_EDIT','SUPPLIER_VIEW','ACCOUNT_VIEW','TRANSPORT_VIEW','INVOICE_VIEW')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Contact set(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    //@PreAuthorize("hasRole('CONTACT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Contact contact) {

        contactService.delete(contact);
    }

    //@PreAuthorize("hasRole('CONTACT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) throws IdNotFound {
        contactService.delete(id);
    }

}