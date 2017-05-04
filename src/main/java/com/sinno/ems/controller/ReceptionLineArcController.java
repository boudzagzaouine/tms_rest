package com.sinno.ems.controller;

import com.sinno.ems.dto.ReceptionLineArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ReceptionLineArcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/receptionLineArcs/")
public class ReceptionLineArcController {

    @Autowired
    private ReceptionLineArcService receptionLineArcService;

    @PreAuthorize("hasRole('RECEPTION_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<ReceptionLineArc> getReceptionLineArcs() {
        return receptionLineArcService.findAll();
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ReceptionLineArc> getReceptionLineArcs(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return receptionLineArcService.findAll(pageable);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return receptionLineArcService.size();
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return receptionLineArcService.size(search);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return receptionLineArcService.isExist(id);
    }    @PreAuthorize("hasRole('RECEPTION_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public ReceptionLineArc getReceptionLineArc(@PathVariable("id") Long id) throws IdNotFound {
        return receptionLineArcService.findById(id);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ReceptionLineArc> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return receptionLineArcService.find(search);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ReceptionLineArc> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return receptionLineArcService.find(search, pageable);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_ARC_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ReceptionLineArc add(@RequestBody ReceptionLineArc receptionLineArc) {
        return receptionLineArcService.save(receptionLineArc);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_ARC_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ReceptionLineArc set(@RequestBody ReceptionLineArc receptionLineArc) {
        return receptionLineArcService.save(receptionLineArc);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_ARC_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ReceptionLineArc receptionLineArc) {

        receptionLineArcService.delete(receptionLineArc);
    }

    @PreAuthorize("hasRole('RECEPTION_LINE_ARC_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        receptionLineArcService.delete(id);
    }
}