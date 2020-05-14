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

import com.bagile.gmo.dto.MaintenanceLineRef;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.MaintenanceLineRefService;

@Controller
@RequestMapping(value = "/maintenanceLineRefs")
public class MaintenanceLineRefController {
    private final MaintenanceLineRefService maintenanceLineRefService;

    public MaintenanceLineRefController(MaintenanceLineRefService maintenanceService) {
        this.maintenanceLineRefService = maintenanceService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<MaintenanceLineRef> getAll() {
        return maintenanceLineRefService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<MaintenanceLineRef> getAll(@RequestParam int page, @RequestParam int size) {
        return maintenanceLineRefService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public MaintenanceLineRef getOne(@PathVariable("id") Long id) throws IdNotFound {
        return maintenanceLineRefService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return maintenanceLineRefService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return maintenanceLineRefService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return maintenanceLineRefService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('MAINTENANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<MaintenanceLineRef> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return maintenanceLineRefService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<MaintenanceLineRef> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return maintenanceLineRefService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MaintenanceLineRef add(@RequestBody MaintenanceLineRef maintenanceLineRef) {
        return maintenanceLineRefService.save(maintenanceLineRef);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MaintenanceLineRef set(@RequestBody MaintenanceLineRef maintenanceLineRef) {
        return maintenanceLineRefService.save(maintenanceLineRef);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody MaintenanceLineRef maintenanceLineRef) {
        maintenanceLineRefService.delete(maintenanceLineRef);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        maintenanceLineRefService.delete(id);
    }
}
