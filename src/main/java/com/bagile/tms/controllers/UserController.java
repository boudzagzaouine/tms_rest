package com.bagile.tms.controllers;

import com.bagile.tms.dto.User;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<User> getUsers() throws AttributesNotFound, ErrorType {
        return userService.findAll();
    }

    @PreAuthorize("hasRole('USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<User> getUsers(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "usrUserUpdateDate");
        Pageable pageable = PageRequest.of(page, size,sort);
        return userService.findAll(pageable);
    }

    @PreAuthorize("hasRole('USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return userService.size();
    }

    @PreAuthorize("hasRole('USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return userService.size(search);
    }

    @PreAuthorize("hasRole('USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return userService.isExist(id);
    }    @PreAuthorize("hasRole('USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") Long id) throws IdNotFound {
        return userService.findById(id);
    }

    @PreAuthorize("hasRole('USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<User> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return userService.find(search);
    }

    @PreAuthorize("hasRole('USER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<User> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return userService.find(search, pageable);
    }

    @PreAuthorize("hasRole('USER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User add(@RequestBody User user) {
        return userService.save(user);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User set(@RequestBody User user) {
        return userService.save(user);
    }

    @PreAuthorize("hasRole('USER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody User user) {

        userService.delete(user);
    }

    @PreAuthorize("hasRole('USER_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}