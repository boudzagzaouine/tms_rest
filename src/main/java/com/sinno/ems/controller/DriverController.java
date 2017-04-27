package com.sinno.ems.controller;

import com.sinno.ems.dto.Driver;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.DriverService;
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
 * Created by khalil on 03/04/2017.
 */
@Controller
@RequestMapping(value="/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Driver> getDrivers() {return driverService.findAll();}
    @PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Driver> getDrivers(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "prmColorUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return driverService.findAll(pageable);

    }
    @PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return driverService.size();
    }
    @PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return driverService.size(search);
    }
    @PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return driverService.isExist(id);
    }
    @PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Driver getDriver(@PathVariable("id") Long id) throws IdNotFound {
        return driverService.findById(id);
    }
    @PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Driver> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return driverService.find(search);
    }
    @PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Driver> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return driverService.find(search, pageable);

    }
    @PreAuthorize("hasRole('DRIVER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Driver add(@RequestBody Driver driver ){return driverService.save(driver);}
    @PreAuthorize("hasRole('DRIVER_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Driver set(@RequestBody Driver driver) {
        return driverService.save(driver);
    }
    @PreAuthorize("hasRole('DRIVER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Driver driver) {

        driverService.delete(driver);
    }



}
