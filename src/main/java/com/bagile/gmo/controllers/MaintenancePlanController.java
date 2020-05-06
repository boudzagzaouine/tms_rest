package com.bagile.gmo.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bagile.gmo.dto.MaintenancePlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.MaintenancePlanService;

@Controller
@RequestMapping(value = "/maintenancePlans")
public class MaintenancePlanController {
    private final MaintenancePlanService maintenanceService;

    public MaintenancePlanController(MaintenancePlanService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<MaintenancePlan> getAll() {
        return maintenanceService.findAll();
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<MaintenancePlan> getAll(@RequestParam int page, @RequestParam int size) {
        return maintenanceService.findAll(page, size);
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public MaintenancePlan getOne(@PathVariable("id") Long id) throws IdNotFound {
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
    public List<MaintenancePlan> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return maintenanceService.find(search);
    }

    //@PreAuthorize("hasAnyRole('INCIDENT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<MaintenancePlan> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return maintenanceService.find(search, page, size);

    }

    //@PreAuthorize("hasRole('MAINTENANCE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MaintenancePlan add(@RequestBody MaintenancePlan maintenancePlan) {
        return maintenanceService.save(maintenancePlan);
    }

    //@PreAuthorize("hasRole('MAINTENANCE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MaintenancePlan set(@RequestBody MaintenancePlan maintenancePlan) {
        return maintenanceService.save(maintenancePlan);
    }

    //@PreAuthorize("hasRole('MAINTENANCE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody MaintenancePlan maintenancePlan) {
        maintenanceService.delete(maintenancePlan);
    }


    //@PreAuthorize("hasRole('MAINTENANCEPLAN_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        maintenanceService.delete(id);
    }
}
