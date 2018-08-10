package com.bagile.tms.controllers;

import com.bagile.tms.dto.TypeMaintenance;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.TypeMaintenanceService;
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
 * Created by khalil on 04/04/2017.
 */
@Controller
@RequestMapping(value = "/maintenanceTypes")

public class TypeMaintenanceController {
    @Autowired
    private TypeMaintenanceService maintenanceService;

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<TypeMaintenance> getAll() {
        return maintenanceService.findAll();
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<TypeMaintenance> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return maintenanceService.findAll(pageable);
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public TypeMaintenance getOne(@PathVariable("id") Long id) throws IdNotFound {
        return maintenanceService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return maintenanceService.size();
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return maintenanceService.size(search);
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return maintenanceService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<TypeMaintenance> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return maintenanceService.find(search);
    }

    //@PreAuthorize("hasAnyRole('INCIDENT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<TypeMaintenance> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return maintenanceService.find(search, pageable);

    }

    //@PreAuthorize("hasRole('MAINTENANCE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TypeMaintenance add(@RequestBody TypeMaintenance maintenancePlan) {
        return maintenanceService.save(maintenancePlan);
    }

    //@PreAuthorize("hasRole('MAINTENANCE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TypeMaintenance set(@RequestBody TypeMaintenance maintenancePlan) {
        return maintenanceService.save(maintenancePlan);
    }

    //@PreAuthorize("hasRole('MAINTENANCE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody TypeMaintenance maintenancePlan) {
        maintenanceService.delete(maintenancePlan);
    }

}
