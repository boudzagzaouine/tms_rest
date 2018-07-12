package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.AisleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/aisles/")
public class AisleController {

    @Autowired
    private AisleService aisleService;


    @PreAuthorize("hasRole('AISLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Aisle> getAisles() throws AttributesNotFound, ErrorType {
        return aisleService.findAll();
    }

    @PreAuthorize("hasRole('AISLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Aisle> getAisles(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "locAisleUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return aisleService.findAll(pageable);
    }

    @PreAuthorize("hasRole('AISLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return aisleService.size();
    }

    @PreAuthorize("hasRole('AISLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return aisleService.size(search);
    }

    @PreAuthorize("hasRole('AISLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return aisleService.isExist(id);
    }    @PreAuthorize("hasRole('AISLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Aisle getAisle(@PathVariable("id") Long id) throws IdNotFound {
        return aisleService.findById(id);
    }

    @PreAuthorize("hasRole('AISLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Aisle> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return aisleService.find(search);
    }

    @PreAuthorize("hasRole('AISLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Aisle> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return aisleService.find(search, pageable);
    }

    @PreAuthorize("hasRole('AISLE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Aisle add(@RequestBody Aisle aisle) {
        return aisleService.save(aisle);
    }

    @PreAuthorize("hasRole('AISLE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Aisle set(@RequestBody Aisle aisle) {
        return aisleService.save(aisle);
    }

    @PreAuthorize("hasRole('AISLE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Aisle aisle) {

        aisleService.delete(aisle);
    }

    @PreAuthorize("hasRole('AISLE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        aisleService.delete(id);
    }
}