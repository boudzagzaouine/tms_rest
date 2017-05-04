package com.sinno.ems.controller;

import com.sinno.ems.dto.LocationStatus;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.LocationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 04/05/2016.
 */
@Controller
@RequestMapping(value = "/locationStatuss/")
public class LocationStatusController {
    @Autowired
    private LocationStatusService locationStatusService;


    @PreAuthorize("hasAnyRole('LOCATION_STATUS_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<LocationStatus> getLocationStatuss() throws AttributesNotFound, ErrorType {
        return locationStatusService.findAll();
    }

    @PreAuthorize("hasAnyRole('LOCATION_STATUS_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<LocationStatus> getLocationStatuss(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);

        return locationStatusService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('LOCATION_STATUS_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return locationStatusService.size();
    }

    @PreAuthorize("hasAnyRole('LOCATION_STATUS_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return locationStatusService.size();
    }

    @PreAuthorize("hasAnyRole('LOCATION_STATUS_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return locationStatusService.isExist(id);
    }


    @PreAuthorize("hasAnyRole('LOCATION_STATUS_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public LocationStatus getLocationStatus(@PathVariable("id") Long id) throws IdNotFound {
        return locationStatusService.findById(id);
    }

    @PreAuthorize("hasAnyRole('LOCATION_STATUS_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<LocationStatus> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return locationStatusService.find(search);
    }

    @PreAuthorize("hasAnyRole('LOCATION_STATUS_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<LocationStatus> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return locationStatusService.find(search,pageable);
    }


    @PreAuthorize("hasAnyRole('LOCATION_STATUS_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LocationStatus add(@RequestBody LocationStatus location) {
        return locationStatusService.save(location);
    }

    @PreAuthorize("hasAnyRole('LOCATION_STATUS_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LocationStatus set(@RequestBody LocationStatus location) {
        return locationStatusService.save(location);
    }

    @PreAuthorize("hasRole('LOCATION_STATUS_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody LocationStatus location) {

        locationStatusService.delete(location);
    }

    @PreAuthorize("hasRole('LOCATION_STATUS_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        locationStatusService.delete(id);
    }
}
