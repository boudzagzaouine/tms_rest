package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.PreparationLineService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */

@Controller
@RequestMapping(value = "/preparationLines/")
public class PreparationLineController {
    @Autowired
    private PreparationLineService preparationLineService;


    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<PreparationLine> getLocations() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()){
            return null;
        }
        return preparationLineService.find(userDetailsService.getOwners().toString());
    }

    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<PreparationLine> getLocations(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()){
            return null;
        }
        Pageable pageable = new PageRequest(page, size);

        return preparationLineService.find(userDetailsService.getOwners().toString(), pageable);
    }

    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return preparationLineService.size(userDetailsService.getOwners().toString());
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
        return preparationLineService.size(search+userDetailsService.getOwners().toString());
    }

    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return preparationLineService.isExist(id);
    }


    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public PreparationLine getLocation(@PathVariable("id") Long id) throws IdNotFound {
        return preparationLineService.findById(id);
    }

    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<PreparationLine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return preparationLineService.find(search+userDetailsService.getOwners().toString());
    }

    //@PreAuthorize("hasRole('PREPARATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<PreparationLine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        //Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        Pageable pageable = new PageRequest(page, size);
        return preparationLineService.find(search+userDetailsService.getOwners().toString(),pageable);
    }


    //@PreAuthorize("hasRole('LOCATION_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PreparationLine add(@RequestBody PreparationLine location) {
        return preparationLineService.save(location);
    }

    //@PreAuthorize("hasRole('LOCATION_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PreparationLine set(@RequestBody PreparationLine location) {
        return preparationLineService.save(location);
    }

    //@PreAuthorize("hasRole('LOCATION_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody PreparationLine location) {

        preparationLineService.delete(location);
    }

    //@PreAuthorize("hasRole('LOCATION_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        preparationLineService.delete(id);
    }
}
