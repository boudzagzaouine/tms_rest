package com.bagile.tms.controllers;

import com.bagile.tms.dto.VehiculeStatus;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.VehicleStatusService;
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
@RequestMapping(value = "/vehicleStatus/")
public class VehicleStatusController  {
    @Autowired
    private VehicleStatusService vehicleStatusService;

    @PreAuthorize("hasAnyRole('VEHICLESTATUS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<VehiculeStatus> getVehicleStatus() {
        return vehicleStatusService.findAll();
    }

    @PreAuthorize("hasAnyRole('VEHICLESTATUS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<VehiculeStatus> getVehicleStatus(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC/*, "prmColorUpdateDate"*/);
        Pageable pageable = PageRequest.of(page, size,sort);
        return vehicleStatusService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('VEHICLESTATUS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return vehicleStatusService.size();
    }

    @PreAuthorize("hasAnyRole('VEHICLESTATUS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return vehicleStatusService.size(search);
    }

    @PreAuthorize("hasAnyRole('VEHICLESTATUS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return vehicleStatusService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('VEHICLESTATUS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public VehiculeStatus getVehicleStatus(@PathVariable("id") Long id) throws IdNotFound {
        return vehicleStatusService.findById(id);
    }

    @PreAuthorize("hasAnyRole('VEHICLESTATUS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<VehiculeStatus> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return vehicleStatusService.find(search);
    }

    @PreAuthorize("hasAnyRole('VEHICLESTATUS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<VehiculeStatus> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return vehicleStatusService.find(search, pageable);
    }

    @PreAuthorize("hasRole('VEHICLESTATUS_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public VehiculeStatus add(@RequestBody VehiculeStatus vehiculeStatus) {
        return vehicleStatusService.save(vehiculeStatus);
    }

    @PreAuthorize("hasRole('VEHICLESTATUS_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public VehiculeStatus set(@RequestBody VehiculeStatus vehiculeStatus) {
        return vehicleStatusService.save(vehiculeStatus);
    }

    @PreAuthorize("hasRole('VEHICLESTATUS_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody VehiculeStatus vehiculeStatus) {

        vehicleStatusService.delete(vehiculeStatus);
    }

    @PreAuthorize("hasRole('VEHICLESTATUS_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        vehicleStatusService.delete(id);
    }
}
