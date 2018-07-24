package com.bagile.tms.controllers;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ProductionService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 03/04/2017.
 */
@Controller
@RequestMapping(value = "/productions/")
public class ProductionController {

    @Autowired
    private ProductionService productionService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasAnyRole('PRODUCTION_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Production> getProductions() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()||null==userDetailsService.getOwners()){
            return null;
        }
        return productionService.find(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('PRODUCTION_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Production> getProductions(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()||null==userDetailsService.getOwners()){
            return null;
        }

        return productionService.find(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString(),page, size);
    }

    @PreAuthorize("hasAnyRole('PRODUCTION_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        if (null == userDetailsService.getWarehouses()||null==userDetailsService.getOwners()){
            return null;
        }

        return productionService.size(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('PRODUCTION_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()||null==userDetailsService.getOwners()){
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return productionService.size(search+userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('PRODUCTION_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return productionService.isExist(id);
    }        @PreAuthorize("hasAnyRole('PRODUCTION_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Production getProduction(@PathVariable("id") Long id) throws IdNotFound {
        return productionService.findById(id);
    }

    @PreAuthorize("hasAnyRole('PRODUCTION_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Production> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()||null==userDetailsService.getOwners()){
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }

        return productionService.find(search+userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('PRODUCTION_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Production> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        //Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getWarehouses()||null==userDetailsService.getOwners()){
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return productionService.find(search+userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString(), page, size);
    }

    @PreAuthorize("hasRole('PRODUCTION_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Production add(@RequestBody Production production) {
        return productionService.save(production);
    }

    @PreAuthorize("hasRole('PRODUCTION_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Production set(@RequestBody Production production) {
        return productionService.save(production);
    }

    @PreAuthorize("hasRole('PRODUCTION_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Production production) {

        productionService.delete(production);
    }

    @PreAuthorize("hasRole('PRODUCTION_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        productionService.delete(id);
    }

}