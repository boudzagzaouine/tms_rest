package com.bagile.tms.controllers;

import com.sinno.ems.dto.UserActions;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.UserActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/userActionss/")
public class UserActionsController {

    @Autowired
    private UserActionsService userActionsService;

    @PreAuthorize("hasRole('USER_ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<UserActions> getUserActionss() {
        return userActionsService.findAll();
    }

    @PreAuthorize("hasRole('USER_ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<UserActions> getUserActionss(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return userActionsService.findAll(pageable);
    }

    @PreAuthorize("hasRole('USER_ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return userActionsService.size();
    }

    @PreAuthorize("hasRole('USER_ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return userActionsService.size(search);
    }

    @PreAuthorize("hasRole('USER_ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return userActionsService.isExist(id);
    }    @PreAuthorize("hasRole('USER_ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public UserActions getUserActions(@PathVariable("id") Long id) throws IdNotFound {
        return userActionsService.findById(id);
    }

    @PreAuthorize("hasRole('USER_ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<UserActions> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return userActionsService.find(search);
    }

    @PreAuthorize("hasRole('USER_ACTIONS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<UserActions> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return userActionsService.find(search, pageable);
    }

    @PreAuthorize("hasRole('USER_ACTIONS_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserActions add(@RequestBody UserActions userActions) {
        return userActionsService.save(userActions);
    }

    @PreAuthorize("hasRole('USER_ACTIONS_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserActions set(@RequestBody UserActions userActions) {
        return userActionsService.save(userActions);
    }

    @PreAuthorize("hasRole('USER_ACTIONS_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody UserActions userActions) {

        userActionsService.delete(userActions);
    }

    @PreAuthorize("hasRole('USER_ACTIONS_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        userActionsService.delete(id);
    }
}