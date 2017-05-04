package com.sinno.ems.controller;

import com.sinno.ems.dto.Habilitation;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.HabilitationService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/habilitations/")
public class HabilitationController {

    @Autowired
    private HabilitationService habilitationService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasRole('HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Habilitation> getHabilitations() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getHabilitations()) {
            return null;
        }
        return habilitationService.find(userDetailsService.getHabilitations().toString());
    }

    @PreAuthorize("hasRole('HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Habilitation> getHabilitations(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getHabilitations()) {
            return null;
        }
        Pageable pageable = new PageRequest(page, size);
        return habilitationService.find(userDetailsService.getHabilitations().toString(),pageable);
    }

    @PreAuthorize("hasRole('HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getHabilitations()) {
            return null;
        }
            return habilitationService.size(userDetailsService.getHabilitations().toString());
    }

    @PreAuthorize("hasRole('HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return habilitationService.size(search);
    }

    @PreAuthorize("hasRole('HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return habilitationService.isExist(id);
    }    @PreAuthorize("hasRole('HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Habilitation getHabilitation(@PathVariable("id") Long id) throws IdNotFound {
        return habilitationService.findById(id);
    }

    @PreAuthorize("hasRole('HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Habilitation> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return habilitationService.find(search);
    }

    @PreAuthorize("hasRole('HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Habilitation> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return habilitationService.find(search, pageable);
    }

    @PreAuthorize("hasRole('HABILITATION_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Habilitation add(@RequestBody Habilitation habilitation) {
        return habilitationService.save(habilitation);
    }

    @PreAuthorize("hasRole('HABILITATION_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Habilitation set(@RequestBody Habilitation habilitation) {
        return habilitationService.save(habilitation);
    }

    @PreAuthorize("hasRole('HABILITATION_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Habilitation habilitation) {

        habilitationService.delete(habilitation);
    }

    @PreAuthorize("hasRole('HABILITATION_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        habilitationService.delete(id);
    }
}