package com.sinno.ems.controller;

import com.sinno.ems.dto.NatureIncident;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.NatureIncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by bouzi on 4/4/2017.
 */
@Controller
@RequestMapping(value = "/natureIncidents/")
public class NatureIncidentController {

    @Autowired
    private NatureIncidentService natureIncidentService;

    @PreAuthorize("hasAnyRole('NATUREINCIDENT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<NatureIncident> getNatureIncidents() {
        return natureIncidentService.findAll();
    }

    @PreAuthorize("hasAnyRole('NATUREINCIDENT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<NatureIncident> getNatureIncidents(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC/*, "prmColorUpdateDate"*/);
        Pageable pageable = new PageRequest(page, size,sort);
        return natureIncidentService.findAll(pageable);

    }

    @PreAuthorize("hasAnyRole('NATUREINCIDENT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return natureIncidentService.size();
    }

    @PreAuthorize("hasAnyRole('NATUREINCIDENT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return natureIncidentService.size(search);
    }

    @PreAuthorize("hasAnyRole('NATUREINCIDENT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return natureIncidentService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('NATUREINCIDENT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public NatureIncident getNatureIncidents(@PathVariable("id") Long id) throws IdNotFound {
        return natureIncidentService.findById(id);
    }

    @PreAuthorize("hasAnyRole('NATUREINCIDENT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<NatureIncident> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return natureIncidentService.find(search);
    }

    @PreAuthorize("hasAnyRole('NATUREINCIDENT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<NatureIncident> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return natureIncidentService.find(search, pageable);
    }

    @PreAuthorize("hasRole('NATUREINCIDENT_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public NatureIncident add(@RequestBody NatureIncident natureIncident) {
        return natureIncidentService.save(natureIncident);
    }

    @PreAuthorize("hasRole('NATUREINCIDENT_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public NatureIncident set(@RequestBody NatureIncident natureIncident) {
        return natureIncidentService.save(natureIncident);
    }

    @PreAuthorize("hasRole('NATUREINCIDENT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody NatureIncident natureIncident) {

        natureIncidentService.delete(natureIncident);
    }

    @PreAuthorize("hasRole('NATUREINCIDENT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        natureIncidentService.delete(id);
    }
}
