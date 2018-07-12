package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.DevisService;
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

import java.util.List;

/**
 * Created by Enissay on 06/12/2016.
 */

@Controller
@RequestMapping(value = "/deviss/")
public class DevisController {

    @Autowired
    private DevisService devisService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasAnyRole('DEVIS_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Devis> getDeviss() throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        return devisService.find( userDetailsService.getOwners().toString());
        //return devisService.findAll();
    }

    @PreAuthorize("hasAnyRole('DEVIS_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Devis> getDeviss(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }

        Sort sort = new Sort(Sort.Direction.DESC, "cmdDevisCreationDate");

        Pageable pageable = new PageRequest(page, size, sort);
        return devisService.find( userDetailsService.getOwners().toString(), pageable);
        //return devisService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('DEVIS_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        return devisService.size( userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('DEVIS_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return devisService.size(search +  userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('DEVIS_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return devisService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('DEVIS_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Devis getDevis(@PathVariable("id") Long id) throws IdNotFound {
        return devisService.findById(id);
    }

    @PreAuthorize("hasAnyRole('DEVIS_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Devis> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return devisService.find(search + userDetailsService.getWarehouses() + "," + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('DEVIS_VIEW','SALE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Devis> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "cmdDevisCreationDate");

        Pageable pageable = new PageRequest(page, size, sort);
        return devisService.find(search +  userDetailsService.getOwners().toString(), pageable);
    }

    @PreAuthorize("hasRole('DEVIS_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Devis add(@RequestBody Devis devis) {
        return devisService.save(devis);
    }

    @PreAuthorize("hasRole('DEVIS_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Devis set(@RequestBody Devis devis) {
        return devisService.save(devis);
    }

    @PreAuthorize("hasRole('DEVIS_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Devis devis) {

        devisService.delete(devis);
    }

    @PreAuthorize("hasRole('DEVIS_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        devisService.delete(id);
    }

    @PreAuthorize("hasRole('DEVIS_CREATE')")
    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal() {
        return "DVS" + devisService.getNextVal().toString();
    }
}

