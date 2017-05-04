package com.sinno.ems.controller;

import com.sinno.ems.dto.Owner;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.OwnerService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/owners/")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Owner> getOwners() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getCodeOwners()) {
            return null;
        }
        return ownerService.find(userDetailsService.getCodeOwners().toString());


        //return ownerService.findAll();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Owner> getOwners(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        //


        if (null == userDetailsService.getCodeOwners()) {
            return null;
        }
        return ownerService.find(userDetailsService.getCodeOwners().toString(), page, size);

        //return ownerService.findAll(pageable);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getCodeOwners()) {
            return null;
        }
        return ownerService.size(userDetailsService.getCodeOwners().toString());

    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getCodeOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        search += userDetailsService.getCodeOwners();
        return ownerService.size(search);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return ownerService.isExist(id);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Owner getOwner(@PathVariable("id") Long id) throws IdNotFound {
        return ownerService.findById(id);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Owner> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getCodeOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        search += userDetailsService.getCodeOwners();
        return ownerService.find(search);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Owner> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getCodeOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        search += userDetailsService.getCodeOwners();
        return ownerService.find(search, page, size);
    }

    @PreAuthorize("hasRole('OWNER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Owner add(@RequestBody Owner owner) {
        return ownerService.save(owner);
    }

    @PreAuthorize("hasRole('OWNER_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Owner set(@RequestBody Owner owner) {
        return ownerService.save(owner);
    }

    @PreAuthorize("hasRole('OWNER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Owner owner) {

        ownerService.delete(owner);
    }

    @PreAuthorize("hasRole('OWNER_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public void delete(@PathVariable Long id) {
        ownerService.delete(id);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/listForHabilitation")
    @ResponseBody
    public List<Owner> getOwnersForHabilitation() throws AttributesNotFound, ErrorType {
        return ownerService.findAllForHabilitation();
    }

    @PreAuthorize("hasRole('OWNER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/getLastInvoiceDate",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getLastInvoiceDate(@RequestParam(value = "id") Long id) {
        return ownerService.getLastInvoiceDate(id);
    }
}