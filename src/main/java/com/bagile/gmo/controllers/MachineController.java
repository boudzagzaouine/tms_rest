package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Machine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.MachineService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping(value = "/machines/")
public class MachineController {
    private final MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @GetMapping( value = "/list")
    @ResponseBody
    public List<Machine> getAll() {
        return machineService.findAll();
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Machine> getAll(@RequestParam int page, @RequestParam int size) {
        return machineService.findAll(page, size);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Machine getOne(@PathVariable("id") Long id) throws IdNotFound {
        return machineService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return machineService.size();
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return machineService.size(search);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return machineService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Machine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return machineService.find(search);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Machine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return machineService.find(search, page, size);
    }

    //@PreAuthorize("hasRole('VEHICLE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Machine add(@RequestBody Machine machine) {
        return machineService.save(machine);
    }

    //@PreAuthorize("hasRole('VEHICLE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Machine set(@RequestBody Machine machine) {
        return machineService.save(machine);
    }

    //@PreAuthorize("hasRole('VEHICLE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Machine machine) {

        machineService.delete(machine);
    }

    //@PreAuthorize("hasRole('VEHICLE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        machineService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        machineService.deleteAll (Arrays.asList(ids));
    }
}
