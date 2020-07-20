package com.bagile.gmo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.MaintenanceService;

@Controller
@RequestMapping(value = "/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Maintenance> getAll() {
        return maintenanceService.findAll();
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Maintenance> getAll(@RequestParam int page, @RequestParam int size) {
        return maintenanceService.findAll(page, size);
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Maintenance getOne(@PathVariable("id") Long id) throws IdNotFound {
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
    public List<Maintenance> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return maintenanceService.find(search);
    }

    //@PreAuthorize("hasAnyRole('INCIDENT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Maintenance> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return maintenanceService.find(search, page, size);

    }

    //@PreAuthorize("hasRole('MAINTENANCE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Maintenance add(@RequestBody Maintenance maintenancePlan) {
        return maintenanceService.save(maintenancePlan);
    }

    //@PreAuthorize("hasRole('MAINTENANCE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Maintenance set(@RequestBody Maintenance maintenance) {
        return maintenanceService.save(maintenance);
    }

    @RequestMapping(value = "/saveALL", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Maintenance> addAll(@RequestBody List<Maintenance> maintenance) {
        return  maintenanceService.saveAll(maintenance);
    }


    //@PreAuthorize("hasRole('MAINTENANCE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Maintenance maintenancePlan) {
        maintenanceService.delete(maintenancePlan);
    }


    //@PreAuthorize("hasRole('MAINTENANCEPLAN_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        maintenanceService.delete(id);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        maintenanceService.deleteAll (Arrays.asList(ids));
    }


}
