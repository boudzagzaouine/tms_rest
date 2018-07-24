package com.bagile.tms.controllers;

import com.sinno.ems.dto.Kit;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.KitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/kits/")
public class KitController {

    @Autowired
    private KitService kitService;

    @PreAuthorize("hasRole('KIT_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Kit> getKits() {
        return kitService.findAll();
    }

    @PreAuthorize("hasRole('KIT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Kit> getKits(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return kitService.findAll(pageable);
    }

    @PreAuthorize("hasRole('KIT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return kitService.size();
    }

    @PreAuthorize("hasRole('KIT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return kitService.size(search);
    }

    @PreAuthorize("hasRole('KIT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return kitService.isExist(id);
    }    @PreAuthorize("hasRole('KIT_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Kit getKit(@PathVariable("id") Long id) throws IdNotFound {
        return kitService.findById(id);
    }

    @PreAuthorize("hasRole('KIT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Kit> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return kitService.find(search);
    }

    @PreAuthorize("hasRole('KIT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Kit> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return kitService.find(search, pageable);
    }

    @PreAuthorize("hasRole('KIT_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Kit add(@RequestBody Kit kit) {
        return kitService.save(kit);
    }

    @PreAuthorize("hasRole('KIT_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Kit set(@RequestBody Kit kit) {
        return kitService.save(kit);
    }

    @PreAuthorize("hasRole('KIT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Kit kit) {

        kitService.delete(kit);
    }

    @PreAuthorize("hasRole('KIT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        kitService.delete(id);
    }
}