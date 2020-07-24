package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.ActionMaintenance;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.ActionMaintenanceService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/actionMaintenances")
public class ActionMaintenanceController {

    private final ActionMaintenanceService actionMaintenanceService;

    public ActionMaintenanceController(ActionMaintenanceService actionMaintenanceService) {
        this.actionMaintenanceService = actionMaintenanceService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<ActionMaintenance> getAll() {
        return actionMaintenanceService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ActionMaintenance> getAll(@RequestParam int page, @RequestParam int size) {
        return actionMaintenanceService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public ActionMaintenance getOne(@PathVariable("id") Long id) throws IdNotFound {
        return actionMaintenanceService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return actionMaintenanceService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return actionMaintenanceService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return actionMaintenanceService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ActionMaintenance> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return actionMaintenanceService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ActionMaintenance> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return actionMaintenanceService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ActionMaintenance add(@RequestBody ActionMaintenance action) {
        return actionMaintenanceService.save(action);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ActionMaintenance set(@RequestBody ActionMaintenance action) {
        return actionMaintenanceService.save(action);
    }

    @RequestMapping(value = "/saveALL", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ActionMaintenance> addAll(@RequestBody List<ActionMaintenance> actions) {
        return  actionMaintenanceService.saveAll(actions);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ActionMaintenance action) {
        actionMaintenanceService.delete(action);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        actionMaintenanceService.delete(id);
    }
}
