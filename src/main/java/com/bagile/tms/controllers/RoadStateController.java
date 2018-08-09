package com.bagile.tms.controllers;

import com.bagile.tms.dto.RoadState;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.RoadStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bouzi on 4/4/2017.
 */
@Controller
@RequestMapping(value = "/RoadStates/")
public class RoadStateController {

    @Autowired
    private RoadStateService RoadStateService;

    @PreAuthorize("hasAnyRole('ROADSTATE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<RoadState> getAll() {
        return RoadStateService.findAll();
    }

    @PreAuthorize("hasAnyRole('ROADSTATE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<RoadState> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return RoadStateService.findAll(/*pageable*/);
    }

    @PreAuthorize("hasAnyRole('ROADSTATE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public RoadState getOne(@PathVariable("id") Long id) throws IdNotFound {
        return RoadStateService.findById(id);
    }

    @PreAuthorize("hasAnyRole('ROADSTATE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return RoadStateService.size();
    }

    @PreAuthorize("hasAnyRole('ROADSTATE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return RoadStateService.size(search);
    }

    @PreAuthorize("hasAnyRole('ROADSTATE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return RoadStateService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('ROADSTATE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<RoadState> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return RoadStateService.find(search);
    }

    @PreAuthorize("hasAnyRole('ROADSTATE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<RoadState> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return RoadStateService.find(search/*, pageable*/);
    }

    @PreAuthorize("hasRole('ROADSTATE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RoadState add(@RequestBody RoadState RoadState) {
        return RoadStateService.save(RoadState);
    }

    @PreAuthorize("hasRole('ROADSTATE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RoadState set(@RequestBody RoadState RoadState) {
        return RoadStateService.save(RoadState);
    }

    @PreAuthorize("hasRole('ROADSTATE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody RoadState RoadState) {

        RoadStateService.delete(RoadState);
    }

    @PreAuthorize("hasRole('ROADSTATE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        RoadStateService.delete(id);
    }
}
