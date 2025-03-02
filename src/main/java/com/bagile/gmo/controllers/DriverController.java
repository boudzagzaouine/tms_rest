package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Driver;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.DriverService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value="/drivers")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Driver> getDrivers() {return driverService.findAll();}
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Driver> getDrivers(@RequestParam int page, @RequestParam int size) {
        return driverService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return driverService.size();
    }
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return driverService.size(search);
    }
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return driverService.isExist(id);
    }
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Driver getDriver(@PathVariable("id") Long id) throws IdNotFound {
        return driverService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Driver> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return driverService.find(search);
    }
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Driver> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        List<Driver> drivers = driverService.find(search, page, size);
        return drivers;

    }
    //@PreAuthorize("hasRole('DRIVER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Driver add(@RequestBody Driver driver ){
        return driverService.save(driver);}
    //@PreAuthorize("hasRole('DRIVER_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Driver set(@RequestBody Driver driver) {

        return driverService.save(driver);
    }
   /* //@PreAuthorize("hasRole('DRIVER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Driver driver) {

        driverService.delete(driver);
    }*/

    //@PreAuthorize("hasRole('DRIVER_Archive')")
    @RequestMapping(value = "/archive", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Driver driver) throws IdNotFound {

        driverService.archive(driver.getId());
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        driverService.deleteAll (Arrays.asList(ids));
    }


    //@PreAuthorize("hasRole('DRIVER_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        driverService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal()
    {
        return  driverService.getNextVal();
    }
}
