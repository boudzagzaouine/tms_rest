package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.PurshaseOrderArcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/purshaseOrderArcs/")
public class PurshaseOrderArcController {

    @Autowired
    private PurshaseOrderArcService purshaseOrderArcService;

    @PreAuthorize("hasRole('PURSHASE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<PurshaseOrderArc> getPurshaseOrderArcs() {
        return purshaseOrderArcService.findAll();
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<PurshaseOrderArc> getPurshaseOrderArcs(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return purshaseOrderArcService.findAll(pageable);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return purshaseOrderArcService.size();
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return purshaseOrderArcService.size(search);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return purshaseOrderArcService.isExist(id);
    }    @PreAuthorize("hasRole('PURSHASE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public PurshaseOrderArc getPurshaseOrderArc(@PathVariable("id") Long id) throws IdNotFound {
        return purshaseOrderArcService.findById(id);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<PurshaseOrderArc> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return purshaseOrderArcService.find(search);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<PurshaseOrderArc> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return purshaseOrderArcService.find(search, pageable);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_ARC_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PurshaseOrderArc add(@RequestBody PurshaseOrderArc purshaseOrderArc) {
        return purshaseOrderArcService.save(purshaseOrderArc);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_ARC_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PurshaseOrderArc set(@RequestBody PurshaseOrderArc purshaseOrderArc) {
        return purshaseOrderArcService.save(purshaseOrderArc);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_ARC_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody PurshaseOrderArc purshaseOrderArc) {

        purshaseOrderArcService.delete(purshaseOrderArc);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_ARC_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        purshaseOrderArcService.delete(id);
    }
}