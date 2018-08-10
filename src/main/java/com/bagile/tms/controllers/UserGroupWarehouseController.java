package com.bagile.tms.controllers;

import com.bagile.tms.dto.UserGroupWarehouse;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.UserGroupWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/userGroupWarehouses/")
public class UserGroupWarehouseController {

    @Autowired
    private UserGroupWarehouseService userGroupWarehouseService;

    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<UserGroupWarehouse> getUserGroupWarehouses() {
        return userGroupWarehouseService.findAll();
    }

    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<UserGroupWarehouse> getUserGroupWarehouses(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userGroupWarehouseService.findAll(pageable);
    }


    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return userGroupWarehouseService.size();
    }

    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return userGroupWarehouseService.size(search);
    }

    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return userGroupWarehouseService.isExist(id);
    }       //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public UserGroupWarehouse getUserGroupWarehouse(@PathVariable("id") Long id) throws IdNotFound {
        return userGroupWarehouseService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<UserGroupWarehouse> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return userGroupWarehouseService.find(search);
    }

    //@PreAuthorize("hasAnyRole('USER_GROUP_OWNER_VIEW','USER_GROUP_WAREHOUSE_VIEW','USER_GROUP_VIEW','HABILITATION_VIEW')")

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<UserGroupWarehouse> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return userGroupWarehouseService.find(search, pageable);
    }

    //@PreAuthorize("hasRole('USER_GROUP_WAREHOUSE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserGroupWarehouse add(@RequestBody UserGroupWarehouse userGroupWarehouse) {
        return userGroupWarehouseService.save(userGroupWarehouse);
    }

    //@PreAuthorize("hasRole('USER_GROUP_WAREHOUSE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserGroupWarehouse set(@RequestBody UserGroupWarehouse userGroupWarehouse) {
        return userGroupWarehouseService.save(userGroupWarehouse);
    }

    //@PreAuthorize("hasRole('USER_GROUP_WAREHOUSE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody UserGroupWarehouse userGroupWarehouse) {

        userGroupWarehouseService.delete(userGroupWarehouse);
    }

    //@PreAuthorize("hasRole('USER_GROUP_WAREHOUSE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        userGroupWarehouseService.delete(id);
    }
}