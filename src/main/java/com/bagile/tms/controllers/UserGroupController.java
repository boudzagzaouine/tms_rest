package com.bagile.tms.controllers;

import com.sinno.ems.dto.UserGroup;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/userGroups/")
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;

    @PreAuthorize("hasAnyRole('USER_GROUP_VIEW','USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<UserGroup> getUserGroups() {
        return userGroupService.findAll();
    }

    @PreAuthorize("hasAnyRole('USER_GROUP_VIEW','USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<UserGroup> getUserGroups(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return userGroupService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('USER_GROUP_VIEW','USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return userGroupService.size();
    }

    @PreAuthorize("hasAnyRole('USER_GROUP_VIEW','USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return userGroupService.size(search);
    }

    @PreAuthorize("hasAnyRole('USER_GROUP_VIEW','USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return userGroupService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('USER_GROUP_VIEW','USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public UserGroup getUserGroup(@PathVariable("id") Long id) throws IdNotFound {
        return userGroupService.findById(id);
    }

    @PreAuthorize("hasAnyRole('USER_GROUP_VIEW','USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<UserGroup> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return userGroupService.find(search);
    }

    @PreAuthorize("hasAnyRole('USER_GROUP_VIEW','USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<UserGroup> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return userGroupService.find(search, pageable);
    }

    @PreAuthorize("hasRole('USER_GROUP_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserGroup add(@RequestBody UserGroup userGroup) {
        return userGroupService.save(userGroup);
    }

    @PreAuthorize("hasRole('USER_GROUP_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserGroup set(@RequestBody UserGroup userGroup) {
        return userGroupService.save(userGroup);
    }

    @PreAuthorize("hasRole('USER_GROUP_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody UserGroup userGroup) {

        userGroupService.delete(userGroup);
    }

    @PreAuthorize("hasRole('USER_GROUP_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        userGroupService.delete(id);
    }
}