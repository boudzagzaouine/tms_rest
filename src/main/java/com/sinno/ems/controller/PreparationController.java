package com.sinno.ems.controller;

import com.sinno.ems.dto.SaleOrder;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.PreparationService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 02/12/2016.
 */
@Controller
@RequestMapping(value = "/preparations/")

public class PreparationController  {
    @Autowired
    private PreparationService preparationService;

 
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Preparation> getLocations() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()){
            return null;
        }
        return preparationService.find(userDetailsService.getOwners().toString());
    }

    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Preparation> getLocations(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()){
            return null;
        }
        Sort sort = new Sort(Sort.Direction.DESC, "cmdPreparationUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);

        return preparationService.find(userDetailsService.getOwners().toString(), pageable);
    }

    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return preparationService.size(userDetailsService.getOwners().toString());
    }

    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return preparationService.size(search+userDetailsService.getOwners().toString());
    }

    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return preparationService.isExist(id);
    }


    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Preparation getLocation(@PathVariable("id") Long id) throws IdNotFound {
        return preparationService.findById(id);
    }

    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Preparation> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return preparationService.find(search+userDetailsService.getOwners().toString());
    }

    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Preparation> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        //Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "cmdPreparationUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return preparationService.find(search+userDetailsService.getOwners().toString(),pageable);
    }


    //@PreAuthorize("hasRole('PREPARATION_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Preparation add(@RequestBody Preparation preparaion) {
        return preparationService.save(preparaion);
    }


    @RequestMapping(value = "/generatePreparation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Preparation generatePreparation(@RequestBody SaleOrder saleOrder) {
        return preparationService.generatePreparation(saleOrder);
    }

    //@PreAuthorize("hasRole('PREPARATION_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Preparation set(@RequestBody Preparation preparaion) {
        return preparationService.save(preparaion);
    }

    //@PreAuthorize("hasRole('PREPARATION_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Preparation preparaion) {

        preparationService.delete(preparaion);
    }

    //@PreAuthorize("hasRole('PREPARATION_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        preparationService.delete(id);
    }
    //@PreAuthorize("hasRole('PREPARATION_CREATE')")
    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal() {
        return "PRE" + preparationService.getNextVal().toString();
    }




}
