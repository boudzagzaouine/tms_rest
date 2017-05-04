package com.sinno.ems.controller;

import com.sinno.ems.dto.Actions;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/actionss/")
public class ActionsController {

    @Autowired
    private ActionsService actionsService;

    @PreAuthorize("hasRole('ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Actions> getActionss() {
        return actionsService.findAll();
    }

    @PreAuthorize("hasRole('ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Actions> getActionss(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return actionsService.findAll(pageable);
    }

    @PreAuthorize("hasRole('ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return actionsService.size();
    }

    @PreAuthorize("hasRole('ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return actionsService.size(search);
    }

    @PreAuthorize("hasRole('ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return actionsService.isExist(id);
    }    @PreAuthorize("hasRole('ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Actions getActions(@PathVariable("id") Long id) throws IdNotFound {
        return actionsService.findById(id);
    }

    @PreAuthorize("hasRole('ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Actions> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return actionsService.find(search);
    }

    @PreAuthorize("hasRole('ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Actions> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return actionsService.find(search, pageable);
    }

    @PreAuthorize("hasRole('ACTIONS_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Actions add(@RequestBody Actions actions) {
        return actionsService.save(actions);
    }

    @PreAuthorize("hasRole('ACTIONS_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Actions set(@RequestBody Actions actions) {
        return actionsService.save(actions);
    }

    @PreAuthorize("hasRole('ACTIONS_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Actions actions) {

        actionsService.delete(actions);
    }

    @PreAuthorize("hasRole('ACTIONS_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        actionsService.delete(id);
    }
}