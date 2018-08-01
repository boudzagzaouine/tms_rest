package com.bagile.tms.controllers;


import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.VehicleTypeService;
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
@RequestMapping(value = "/vehicleTypes/")
public class VehicleTypeController {
    @Autowired
    private VehicleTypeService vehicleTypeService;

    @PreAuthorize("hasAnyRole('VEHICLETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<VehiculeType> getVehicleTypes() {
        return vehicleTypeService.findAll();
    }

    @PreAuthorize("hasAnyRole('VEHICLETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<VehiculeType> getVehicleTypes(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC/*, "prmColorUpdateDate"*/);
        Pageable pageable = PageRequest.of(page, size,sort);
        return vehicleTypeService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('VEHICLETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return vehicleTypeService.size();
    }

    @PreAuthorize("hasAnyRole('VEHICLETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return vehicleTypeService.size(search);
    }

    @PreAuthorize("hasAnyRole('VEHICLETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return vehicleTypeService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('VEHICLETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public VehiculeType getVehicleType(@PathVariable("id") Long id) throws IdNotFound {
        return vehicleTypeService.findById(id);
    }

    @PreAuthorize("hasAnyRole('VEHICLETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<VehiculeType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return vehicleTypeService.find(search);
    }

    @PreAuthorize("hasAnyRole('VEHICLETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<VehiculeType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return vehicleTypeService.find(search, pageable);
    }

    @PreAuthorize("hasRole('VEHICLETYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public VehiculeType add(@RequestBody VehiculeType vehiculeType) {
        return vehicleTypeService.save(vehiculeType);
    }

    @PreAuthorize("hasRole('VEHICLETYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public VehiculeType set(@RequestBody VehiculeType vehiculeType) {
        return vehicleTypeService.save(vehiculeType);
    }

    @PreAuthorize("hasRole('VEHICLETYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody VehiculeType vehiculeType) {

        vehicleTypeService.delete(vehiculeType);
    }

    @PreAuthorize("hasRole('VEHICLETYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        vehicleTypeService.delete(id);
    }
}
