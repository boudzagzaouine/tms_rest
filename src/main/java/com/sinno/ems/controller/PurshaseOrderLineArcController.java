package com.sinno.ems.controller;

import com.sinno.ems.dto.PurshaseOrderLineArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.PurshaseOrderLineArcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/purshaseOrderLineArcs/")
public class PurshaseOrderLineArcController {

    @Autowired
    private PurshaseOrderLineArcService purshaseOrderLineArcService;

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<PurshaseOrderLineArc> getPurshaseOrderLineArcs() {
        return purshaseOrderLineArcService.findAll();
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<PurshaseOrderLineArc> getPurshaseOrderLineArcs(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return purshaseOrderLineArcService.findAll(pageable);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return purshaseOrderLineArcService.size();
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return purshaseOrderLineArcService.size(search);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return purshaseOrderLineArcService.isExist(id);
    }    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public PurshaseOrderLineArc getPurshaseOrderLineArc(@PathVariable("id") Long id) throws IdNotFound {
        return purshaseOrderLineArcService.findById(id);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<PurshaseOrderLineArc> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return purshaseOrderLineArcService.find(search);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<PurshaseOrderLineArc> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return purshaseOrderLineArcService.find(search, pageable);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_ARC_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PurshaseOrderLineArc add(@RequestBody PurshaseOrderLineArc purshaseOrderLineArc) {
        return purshaseOrderLineArcService.save(purshaseOrderLineArc);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_ARC_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PurshaseOrderLineArc set(@RequestBody PurshaseOrderLineArc purshaseOrderLineArc) {
        return purshaseOrderLineArcService.save(purshaseOrderLineArc);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_ARC_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody PurshaseOrderLineArc purshaseOrderLineArc) {

        purshaseOrderLineArcService.delete(purshaseOrderLineArc);
    }

    @PreAuthorize("hasRole('PURSHASE_ORDER_LINE_ARC_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        purshaseOrderLineArcService.delete(id);
    }
}