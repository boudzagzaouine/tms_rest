package com.sinno.ems.controller;

/**
 * Created by Enissay on 06/12/2016.
 */

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.DevisLineService;
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
@RequestMapping(value = "/devisLines/")
public class DevisLineController {

    @Autowired
    private DevisLineService devisService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasAnyRole('DEVIS_LINE_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<DevisLine> getDevisLines() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        return devisService.find(userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString());
        //return devisService.findAll();
    }

    @PreAuthorize("hasAnyRole('DEVIS_LINE_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<DevisLine> getDevisLines(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }

        Sort sort = new Sort(Sort.Direction.DESC, "cmdDevisLineCreationDate");

        Pageable pageable = new PageRequest(page, size,sort);
        return devisService.find(userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString(),pageable);
        //return devisService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('DEVIS_LINE_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        return devisService.size(userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('DEVIS_LINE_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return devisService.size(search + userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('DEVIS_LINE_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return devisService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('DEVIS_LINE_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public DevisLine getDevisLine(@PathVariable("id") Long id) throws IdNotFound {
        return devisService.findById(id);
    }

    @PreAuthorize("hasAnyRole('DEVIS_LINE_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<DevisLine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return devisService.find(search + userDetailsService.getWarehouses() + "," + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('DEVIS_LINE_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<DevisLine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "cmdDevisLineCreationDate");

        Pageable pageable = new PageRequest(page, size,sort);
        return devisService.find(search + userDetailsService.getWarehouses().toString() + "," + userDetailsService.getOwners().toString(), pageable);
    }

    @PreAuthorize("hasRole('DEVIS_LINE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DevisLine add(@RequestBody DevisLine devis) {
        return devisService.save(devis);
    }

    @PreAuthorize("hasRole('DEVIS_LINE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DevisLine set(@RequestBody DevisLine devis) {
        return devisService.save(devis);
    }

    @PreAuthorize("hasRole('DEVIS_LINE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody DevisLine devis) {

        devisService.delete(devis);
    }

    @PreAuthorize("hasRole('DEVIS_LINE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        devisService.delete(id);
    }

}

