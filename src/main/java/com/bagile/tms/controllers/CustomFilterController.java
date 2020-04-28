package com.bagile.tms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bagile.tms.dto.CustomFilter;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.CustomFilterService;

@Controller
@RequestMapping(value = "/customFilters")
public class CustomFilterController {

    private final CustomFilterService customFilterService;

    @Autowired
    public CustomFilterController(CustomFilterService customFilterService) {
        this.customFilterService = customFilterService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<CustomFilter> getCustomFilters() throws AttributesNotFound, ErrorType {

        return customFilterService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<CustomFilter> getCustomFilters(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
               return customFilterService.findAll( page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return customFilterService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {


        if (!search.endsWith(",")) {
            search += ",";
        }
        return customFilterService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return customFilterService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public CustomFilter getCustomFilter(@PathVariable("id") Long id) throws IdNotFound {
        return customFilterService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<CustomFilter> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        if (!search.endsWith(",")) {
            search += ",";
        }

        return customFilterService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<CustomFilter> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        if (!search.endsWith(",")) {
            search += ",";
        }
        return customFilterService.find(search, page, size);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CustomFilter add(@RequestBody CustomFilter customFilter) {
        return customFilterService.save(customFilter);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CustomFilter set(@RequestBody CustomFilter customFilter) {
        return customFilterService.save(customFilter);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody CustomFilter customFilter) {

        customFilterService.delete(customFilter);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) throws IdNotFound {
        customFilterService.delete(id);
    }

}