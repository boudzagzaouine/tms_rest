package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.AgencyService;
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
 * Created by Enissay on 02/01/2017.
 */
@Controller
@RequestMapping(value = "/agencies/")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;


    @PreAuthorize("hasAnyRole('AGENCY_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Agency> getAgencys() throws AttributesNotFound, ErrorType {
      
        return agencyService.findAll();
    }

    @PreAuthorize("hasAnyRole('AGENCY_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Agency> getAgencys(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Sort sort = new Sort(Sort.Direction.DESC, "usrAgencyUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return agencyService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('AGENCY_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
      
        return agencyService.size();
    }

    @PreAuthorize("hasAnyRole('AGENCY_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
      
        return agencyService.size(search );
    }

    @PreAuthorize("hasAnyRole('AGENCY_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return agencyService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('AGENCY_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Agency getAgency(@PathVariable("id") Long id) throws IdNotFound {
        return agencyService.findById(id);
    }

    @PreAuthorize("hasAnyRole('AGENCY_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Agency> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
    
        return agencyService.find(search);
    }

    @PreAuthorize("hasAnyRole('AGENCY_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Agency> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        // Pageable pageable = new PageRequest(page, size);
      
        return agencyService.find(search , page, size);
    }

    @PreAuthorize("hasAnyRole('AGENCY_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Agency add(@RequestBody Agency agency) {
        return agencyService.save(agency);
    }

    @PreAuthorize("hasAnyRole('AGENCY_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Agency set(@RequestBody Agency agency) {
        return agencyService.save(agency);
    }

    @PreAuthorize("hasRole('AGENCY_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Agency agency) {

        agencyService.delete(agency);
    }

    @PreAuthorize("hasRole('AGENCY_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        agencyService.delete(id);
    }
}
