package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ReceptionArcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/receptionArcs/")
public class ReceptionArcController {

    @Autowired
    private ReceptionArcService receptionArcService;

    @PreAuthorize("hasRole('RECEPTION_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<ReceptionArc> getReceptionArcs() {
        return receptionArcService.findAll();
    }

    @PreAuthorize("hasRole('RECEPTION_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ReceptionArc> getReceptionArcs(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return receptionArcService.findAll(pageable);
    }

    @PreAuthorize("hasRole('RECEPTION_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return receptionArcService.size();
    }

    @PreAuthorize("hasRole('RECEPTION_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return receptionArcService.size(search);
    }

    @PreAuthorize("hasRole('RECEPTION_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return receptionArcService.isExist(id);
    }    @PreAuthorize("hasRole('RECEPTION_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public ReceptionArc getReceptionArc(@PathVariable("id") Long id) throws IdNotFound {
        return receptionArcService.findById(id);
    }

    @PreAuthorize("hasRole('RECEPTION_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ReceptionArc> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return receptionArcService.find(search);
    }

    @PreAuthorize("hasRole('RECEPTION_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ReceptionArc> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return receptionArcService.find(search, pageable);
    }

    @PreAuthorize("hasRole('RECEPTION_ARC_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ReceptionArc add(@RequestBody ReceptionArc receptionArc) {
        return receptionArcService.save(receptionArc);
    }

    @PreAuthorize("hasRole('RECEPTION_ARC_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ReceptionArc set(@RequestBody ReceptionArc receptionArc) {
        return receptionArcService.save(receptionArc);
    }

    @PreAuthorize("hasRole('RECEPTION_ARC_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ReceptionArc receptionArc) {

        receptionArcService.delete(receptionArc);
    }

    @PreAuthorize("hasRole('RECEPTION_ARC_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        receptionArcService.delete(id);
    }
}