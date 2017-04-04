package com.sinno.ems.controller;

import com.sinno.ems.dto.Vehicule;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.VehicleService;
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
@RequestMapping(value = "/vehicles/")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Vehicule> getVehicles() {
        return vehicleService.findAll();
    }

    @PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Vehicule> getVehicles(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC/*, "prmColorUpdateDate"*/);
        Pageable pageable = new PageRequest(page, size,sort);
        return vehicleService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return vehicleService.size();
    }

    @PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return vehicleService.size(search);
    }

    @PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return vehicleService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Vehicule getVehicle(@PathVariable("id") Long id) throws IdNotFound {
        return vehicleService.findById(id);
    }

    @PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Vehicule> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return vehicleService.find(search);
    }

    @PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Vehicule> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return vehicleService.find(search, pageable);
    }

    @PreAuthorize("hasRole('VEHICLE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Vehicule add(@RequestBody Vehicule vehicule) {
        return vehicleService.save(vehicule);
    }

    @PreAuthorize("hasRole('VEHICLE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Vehicule set(@RequestBody Vehicule vehicule) {
        return vehicleService.save(vehicule);
    }

    @PreAuthorize("hasRole('VEHICLE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Vehicule vehicule) {

        vehicleService.delete(vehicule);
    }

    @PreAuthorize("hasRole('VEHICLE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        vehicleService.delete(id);
    }
}
