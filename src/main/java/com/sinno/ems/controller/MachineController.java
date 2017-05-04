package com.sinno.ems.controller;

import com.sinno.ems.dto.Machine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.MachineService;
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
 * Created by Enissay on 28/03/2017.
 */
@Controller
@RequestMapping(value = "/machines/")
public class MachineController {
    @Autowired
    private MachineService MachineService;

    @PreAuthorize("hasAnyRole('MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Machine> getMachines() throws AttributesNotFound, ErrorType {
        return MachineService.findAll();
    }

    @PreAuthorize("hasAnyRole('MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Machine> getMachines(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "pdtMachineUpdateDate");
        return MachineService.findAll(page, size);
    }

    @PreAuthorize("hasAnyRole('MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return MachineService.size();
    }

    @PreAuthorize("hasAnyRole('MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return MachineService.size(search);
    }

    @PreAuthorize("hasAnyRole('MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return MachineService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Machine getMachine(@PathVariable("id") Long id) throws IdNotFound {
        return MachineService.findById(id);
    }

    @PreAuthorize("hasAnyRole('MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Machine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return MachineService.find(search);
    }

    @PreAuthorize("hasAnyRole('MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Machine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return MachineService.find(search, page, size);
    }

    @PreAuthorize("hasRole('MACHINE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Machine add(@RequestBody Machine Machine) {
        return MachineService.save(Machine);
    }

    @PreAuthorize("hasRole('MACHINE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Machine set(@RequestBody Machine Machine) {
        return MachineService.save(Machine);
    }

    @PreAuthorize("hasRole('MACHINE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Machine Machine) {

        MachineService.delete(Machine);
    }

    @PreAuthorize("hasRole('MACHINE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        MachineService.delete(id);
    }
}
