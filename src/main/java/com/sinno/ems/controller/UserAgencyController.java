package com.sinno.ems.controller;

import com.sinno.ems.dto.UserAgency;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.UserAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 03/01/2017.
 */
@Controller
@RequestMapping(value = "/userAgencies/")
public class UserAgencyController {
    @Autowired
    private UserAgencyService userAgencyService;


    @PreAuthorize("hasRole('USER_AGENCY_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<UserAgency> getUserAgencys() throws AttributesNotFound, ErrorType {

        return userAgencyService.findAll();
    }

    @PreAuthorize("hasRole('USER_AGENCY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<UserAgency> getUserAgencys(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);

        return userAgencyService.findAll(pageable);    }

    @PreAuthorize("hasRole('USER_AGENCY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return userAgencyService.size();
    }

    @PreAuthorize("hasRole('USER_AGENCY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return userAgencyService.size(search);
    }

    @PreAuthorize("hasRole('USER_AGENCY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return userAgencyService.isExist(id);
    }    @PreAuthorize("hasRole('USER_AGENCY_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public UserAgency getUserAgency(@PathVariable("id") Long id) throws IdNotFound {
        return userAgencyService.findById(id);
    }

    @PreAuthorize("hasRole('USER_AGENCY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<UserAgency> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        return userAgencyService.find(search);
    }

    @PreAuthorize("hasRole('USER_AGENCY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<UserAgency> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);

        return userAgencyService.find(search, pageable);
    }

    @PreAuthorize("hasRole('USER_AGENCY_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserAgency add(@RequestBody UserAgency userAgency) {
        return userAgencyService.save(userAgency);
    }

    @PreAuthorize("hasRole('USER_AGENCY_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserAgency set(@RequestBody UserAgency userAgency) {
        return userAgencyService.save(userAgency);
    }

    @PreAuthorize("hasRole('USER_AGENCY_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody UserAgency userAgency) {

        userAgencyService.delete(userAgency);
    }

    @PreAuthorize("hasRole('USER_AGENCY_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        userAgencyService.delete(id);
    }


}
