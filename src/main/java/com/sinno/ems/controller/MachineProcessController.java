package com.sinno.ems.controller;

import com.sinno.ems.dto.MachineProcess;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/machineProcesses/")
public class MachineProcessController {
    @Autowired
    private com.sinno.ems.service.MachineProcessService MachineProcessService;

    @PreAuthorize("hasAnyRole('PROCESS_VIEW','MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<MachineProcess> getMachineProcesss() throws AttributesNotFound, ErrorType {
        return MachineProcessService.findAll();
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW','MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<MachineProcess> getMachineProcesss(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "pdtMachineProcessUpdateDate");
        return MachineProcessService.findAll(page, size);
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW','MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return MachineProcessService.size();
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW','MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return MachineProcessService.size(search);
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW','MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return MachineProcessService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW','MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public MachineProcess getMachineProcess(@PathVariable("id") Long id) throws IdNotFound {
        return MachineProcessService.findById(id);
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW','MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<MachineProcess> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return MachineProcessService.find(search);
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW','MACHINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<MachineProcess> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return MachineProcessService.find(search, page, size);
    }

    @PreAuthorize("hasAnyRole('PROCESS_CREATE','MACHINE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MachineProcess add(@RequestBody MachineProcess machineProcess) {
        return MachineProcessService.save(machineProcess);
    }

    @PreAuthorize("hasAnyRole('PROCESS_EDIT','MACHINE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MachineProcess set(@RequestBody MachineProcess machineProcess) {
        return MachineProcessService.save(machineProcess);
    }

    @PreAuthorize("hasAnyRole('PROCESS_DELETE','MACHINE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody MachineProcess machineProcess) {

        MachineProcessService.delete(machineProcess);
    }

    @PreAuthorize("hasAnyRole('PROCESS_DELETE','MACHINE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        MachineProcessService.delete(id);
    }
}
