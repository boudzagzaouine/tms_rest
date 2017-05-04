package com.sinno.ems.controller;

import com.sinno.ems.dto.ContainerArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ContainerArcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/containerArcs/")
public class ContainerArcController {

    @Autowired
    private ContainerArcService containerArcService;

    @PreAuthorize("hasRole('CONTAINER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<ContainerArc> getContainerArcs() {
        return containerArcService.findAll();
    }

    @PreAuthorize("hasRole('CONTAINER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ContainerArc> getContainerArcs(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return containerArcService.findAll(pageable);
    }

    @PreAuthorize("hasRole('CONTAINER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return containerArcService.size();
    }

    @PreAuthorize("hasRole('CONTAINER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return containerArcService.size(search);
    }

    @PreAuthorize("hasRole('CONTAINER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return containerArcService.isExist(id);
    }    @PreAuthorize("hasRole('CONTAINER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public ContainerArc getContainerArc(@PathVariable("id") Long id) throws IdNotFound {
        return containerArcService.findById(id);
    }

    @PreAuthorize("hasRole('CONTAINER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ContainerArc> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return containerArcService.find(search);
    }

    @PreAuthorize("hasRole('CONTAINER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ContainerArc> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return containerArcService.find(search, pageable);
    }

    @PreAuthorize("hasRole('CONTAINER_ARC_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ContainerArc add(@RequestBody ContainerArc containerArc) {
        return containerArcService.save(containerArc);
    }

    @PreAuthorize("hasRole('CONTAINER_ARC_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ContainerArc set(@RequestBody ContainerArc containerArc) {
        return containerArcService.save(containerArc);
    }

    @PreAuthorize("hasRole('CONTAINER_ARC_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ContainerArc containerArc) {

        containerArcService.delete(containerArc);
    }

    @PreAuthorize("hasRole('CONTAINER_ARC_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        containerArcService.delete(id);
    }
}