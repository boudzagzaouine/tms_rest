package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.EdiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/edis/")
public class EdiController {

    @Autowired
    private EdiService ediService;

    @PreAuthorize("hasRole('EDI_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Edi> getEdis() {
        return ediService.findAll();
    }

    @PreAuthorize("hasRole('EDI_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Edi> getEdis(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return ediService.findAll(pageable);
    }

    @PreAuthorize("hasRole('EDI_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return ediService.size();
    }

    @PreAuthorize("hasRole('EDI_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return ediService.size(search);
    }

    @PreAuthorize("hasRole('EDI_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return ediService.isExist(id);
    }    @PreAuthorize("hasRole('EDI_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Edi getEdi(@PathVariable("id") Long id) throws IdNotFound {
        return ediService.findById(id);
    }

    @PreAuthorize("hasRole('EDI_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Edi> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return ediService.find(search);
    }

    @PreAuthorize("hasRole('EDI_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Edi> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return ediService.find(search, pageable);
    }

    @PreAuthorize("hasRole('EDI_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Edi add(@RequestBody Edi edi) {
        return ediService.save(edi);
    }

    @PreAuthorize("hasRole('EDI_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Edi set(@RequestBody Edi edi) {
        return ediService.save(edi);
    }

    @PreAuthorize("hasRole('EDI_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Edi edi) {

        ediService.delete(edi);
    }

    @PreAuthorize("hasRole('EDI_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        ediService.delete(id);
    }
}