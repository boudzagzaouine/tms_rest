package com.bagile.tms.controllers;

import com.bagile.tms.dto.Vehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bouzi on 4/4/2017.
 */
@Controller
@RequestMapping(value = "/vehicles/")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Vehicle> getAll() {
        return vehicleService.findAll();
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Vehicle> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return vehicleService.findAll(pageable);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Vehicle getOne(@PathVariable("id") Long id) throws IdNotFound {
        return vehicleService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return vehicleService.size();
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return vehicleService.size(search);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return vehicleService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Vehicle> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return vehicleService.find(search);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Vehicle> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return vehicleService.find(search, pageable);
    }

    //@PreAuthorize("hasRole('VEHICLE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Vehicle add(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    //@PreAuthorize("hasRole('VEHICLE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Vehicle set(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    //@PreAuthorize("hasRole('VEHICLE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Vehicle vehicle) {

        vehicleService.delete(vehicle);
    }

    //@PreAuthorize("hasRole('VEHICLE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        vehicleService.delete(id);
    }

}
