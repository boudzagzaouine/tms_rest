package com.sinno.ems.controller;

import com.sinno.ems.dto.Column;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/columns/")
public class ColumnController {

    @Autowired
    private ColumnService columnService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Column> getColumns() {
        return columnService.findAll();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Column> getColumns(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return columnService.findAll(pageable);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return columnService.size();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return columnService.size(search);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return columnService.isExist(id);
    }    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Column getColumn(@PathVariable("id") Long id) throws IdNotFound {
        return columnService.findById(id);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Column> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return columnService.find(search);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Column> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return columnService.find(search, pageable);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Column add(@RequestBody Column column) {
        return columnService.save(column);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Column set(@RequestBody Column column) {
        return columnService.save(column);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Column column) {

        columnService.delete(column);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        columnService.delete(id);
    }
}