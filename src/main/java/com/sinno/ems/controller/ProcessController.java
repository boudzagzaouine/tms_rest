package com.sinno.ems.controller;

import com.sinno.ems.dto.Process;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ProcessService;
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
@RequestMapping(value = "/processes/")
public class ProcessController {
    @Autowired
    private com.sinno.ems.service.ProcessService ProcessService;

    @PreAuthorize("hasAnyRole('PROCESS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Process> getProcesss() throws AttributesNotFound, ErrorType {
        return ProcessService.findAll();
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Process> getProcesss(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return ProcessService.findAll(page, size);
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return ProcessService.size();
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return ProcessService.size(search);
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return ProcessService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Process getProcess(@PathVariable("id") Long id) throws IdNotFound {
        return ProcessService.findById(id);
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Process> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return ProcessService.find(search);
    }

    @PreAuthorize("hasAnyRole('PROCESS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Process> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return ProcessService.find(search, page, size);
    }

    @PreAuthorize("hasRole('PROCESS_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Process add(@RequestBody Process Process) {
        return ProcessService.save(Process);
    }

    @PreAuthorize("hasRole('PROCESS_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Process set(@RequestBody Process Process) {
        return ProcessService.save(Process);
    }

    @PreAuthorize("hasRole('PROCESS_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Process Process) {

        ProcessService.delete(Process);
    }

    @PreAuthorize("hasRole('PROCESS_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        ProcessService.delete(id);
    }
}
