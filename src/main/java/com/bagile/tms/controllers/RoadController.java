package com.bagile.tms.controllers;

import com.bagile.tms.dto.Road;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.RoadService;
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
 * Created by bouzi on 4/4/2017.
 */
@Controller
@RequestMapping(value = "/roads/")
public class RoadController {

    @Autowired
    private RoadService roadService;

    @PreAuthorize("hasAnyRole('ROAD_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Road> getAll() {
        return roadService.findAll();
    }

    @PreAuthorize("hasAnyRole('ROAD_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Road> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return roadService.findAll(/*pageable*/);
    }

    @PreAuthorize("hasAnyRole('ROAD_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Road getOne(@PathVariable("id") Long id) throws IdNotFound {
        return roadService.findById(id);
    }

    @PreAuthorize("hasAnyRole('ROAD_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return roadService.size();
    }

    @PreAuthorize("hasAnyRole('ROAD_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return roadService.size(search);
    }

    @PreAuthorize("hasAnyRole('ROAD_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return roadService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('ROAD_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Road> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return roadService.find(search);
    }

    @PreAuthorize("hasAnyRole('ROAD_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Road> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return roadService.find(search/*, pageable*/);
    }

    @PreAuthorize("hasRole('ROAD_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Road add(@RequestBody Road road) {
        return roadService.save(road);
    }

    @PreAuthorize("hasRole('ROAD_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Road set(@RequestBody Road road) {
        return roadService.save(road);
    }

    @PreAuthorize("hasRole('ROAD_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Road road) {

        roadService.delete(road);
    }

    @PreAuthorize("hasRole('ROAD_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        roadService.delete(id);
    }
}
