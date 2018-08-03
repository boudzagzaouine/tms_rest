package com.bagile.tms.controllers;

import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.DriverBadgeService;
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
 * Created by khalil on 26/04/2017.
 */
@Controller
@RequestMapping(value="/driverbadges/")

public class DriverBadgeController {
    @Autowired
    private DriverBadgeService driverBadgeService;
    @PreAuthorize("hasAnyRole('DRIVERBADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<DriverBadge> getNatureIncidents() {
        return driverBadgeService.findAll();
    }
    @PreAuthorize("hasAnyRole('DRIVERBADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<DriverBadge> getNatureIncidents(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC,"drvDriverBadge");
        Pageable pageable = PageRequest.of(page, size,sort);
        return driverBadgeService.findAll(pageable);
    }
    @PreAuthorize("hasAnyRole('DRIVERBADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return driverBadgeService.size();
    }

    @PreAuthorize("hasAnyRole('DRIVERBADGE_VIEW_')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return driverBadgeService.size(search);
    }
    @PreAuthorize("hasAnyRole('DRIVERBADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return driverBadgeService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('DRIVERBADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public DriverBadge getNatureIncidents(@PathVariable("id") Long id) throws IdNotFound {
        return driverBadgeService.findById(id);
    }

    @PreAuthorize("hasAnyRole('DRIVERBADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<DriverBadge> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return driverBadgeService.find(search);
    }
    @PreAuthorize("hasAnyRole('DRIVERBADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<DriverBadge> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return driverBadgeService.find(search, pageable);
    }

    @PreAuthorize("hasRole('DRIVERBADGE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DriverBadge add(@RequestBody DriverBadge driverBadge) {
        return driverBadgeService.save(driverBadge);
    }

    @PreAuthorize("hasRole('DRIVERBADGE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DriverBadge set(@RequestBody DriverBadge driverBadge) {
        return driverBadgeService.save(driverBadge);
    }
    @PreAuthorize("hasRole('DRIVERBADGE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody DriverBadge natureIncident) {

        driverBadgeService.delete(natureIncident);
    }

    @PreAuthorize("hasRole('DRIVERBADGE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        driverBadgeService.delete(id);
    }
}


