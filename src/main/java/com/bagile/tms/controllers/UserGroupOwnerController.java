package com.bagile.tms.controllers;

import com.bagile.tms.dto.UserGroupOwner;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.UserGroupOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/userGroupOwners/")
public class UserGroupOwnerController {

    @Autowired
    private UserGroupOwnerService userGroupOwnerService;

    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<UserGroupOwner> getUserGroupOwners() {
        return userGroupOwnerService.findAll();
    }

    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<UserGroupOwner> getUserGroupOwners(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userGroupOwnerService.findAll(pageable);
    }

    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return userGroupOwnerService.size();
    }

    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return userGroupOwnerService.size(search);
    }

    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return userGroupOwnerService.isExist(id);
    }        //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public UserGroupOwner getUserGroupOwner(@PathVariable("id") Long id) throws IdNotFound {
        return userGroupOwnerService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<UserGroupOwner> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return userGroupOwnerService.find(search);
    }

    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<UserGroupOwner> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return userGroupOwnerService.find(search, pageable);
    }

    //@PreAuthorize("hasRole('USER_GROUP_OWNER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserGroupOwner add(@RequestBody UserGroupOwner userGroupOwner) {
        return userGroupOwnerService.save(userGroupOwner);
    }

    //@PreAuthorize("hasRole('USER_GROUP_OWNER_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserGroupOwner set(@RequestBody UserGroupOwner userGroupOwner) {
        return userGroupOwnerService.save(userGroupOwner);
    }

    //@PreAuthorize("hasRole('USER_GROUP_OWNER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody UserGroupOwner userGroupOwner) {

        userGroupOwnerService.delete(userGroupOwner);
    }

    //@PreAuthorize("hasRole('USER_GROUP_OWNER_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        userGroupOwnerService.delete(id);
    }
}