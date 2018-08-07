package com.bagile.tms.controllers;

import com.bagile.tms.dto.Category;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by khalil on 04/04/2017.
 */
@Controller
@RequestMapping(value = "/doorTypes")

public class CategoryController {
    @Autowired
    private CategoryService service;

    @PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Category> getAll() {
        return service.findAll();
    }

    @PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Category> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Category getOne(@PathVariable("id") Long id) throws IdNotFound {
        return service.findById(id);
    }

    @PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return service.size();
    }

    @PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return service.size(search);
    }

    @PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return service.isExist(id);
    }

    @PreAuthorize("hasAnyRole('CATEGORY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Category> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return service.find(search);
    }

    @PreAuthorize("hasAnyRole('INCIDENT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Category> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return service.find(search, pageable);

    }

    @PreAuthorize("hasRole('CATEGORY_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Category add(@RequestBody Category maintenancePlan) {
        return service.save(maintenancePlan);
    }

    @PreAuthorize("hasRole('CATEGORY_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Category set(@RequestBody Category maintenancePlan) {
        return service.save(maintenancePlan);
    }

    @PreAuthorize("hasRole('CATEGORY_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Category maintenancePlan) {
        service.delete(maintenancePlan);
    }

}
