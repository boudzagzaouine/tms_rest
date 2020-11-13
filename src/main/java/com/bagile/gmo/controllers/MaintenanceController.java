package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.MaintenanceService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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
    public Maintenance add(@RequestBody Maintenance maintenancePlan) throws AttributesNotFound, ErrorType {
        return maintenanceService.save(maintenancePlan);
    }

    //@PreAuthorize("hasRole('MAINTENANCE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Maintenance set(@RequestBody Maintenance maintenance) throws AttributesNotFound, ErrorType {
        return maintenanceService.save(maintenance);
    }

    @RequestMapping(value = "/saveALL", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Maintenance> addAll(@RequestBody List<Maintenance> maintenance) throws AttributesNotFound, ErrorType {
        return  maintenanceService.saveAll(maintenance);
    }


    //@PreAuthorize("hasRole('MAINTENANCE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Maintenance maintenancePlan) throws AttributesNotFound, ErrorType {
        maintenanceService.delete(maintenancePlan);
    }


    //@PreAuthorize("hasRole('MAINTENANCEPLAN_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) throws AttributesNotFound, ErrorType {
        maintenanceService.delete(id);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) throws AttributesNotFound, ErrorType {
        maintenanceService.deleteAll (Arrays.asList(ids));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal()
    {
        return  maintenanceService.getNextVal();
    }

    @RequestMapping(value = "/close", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Maintenance close(@RequestBody Maintenance maintenance) throws AttributesNotFound, ErrorType, IdNotFound {
        return maintenanceService.closeMaintenance(maintenance);
    }

}
