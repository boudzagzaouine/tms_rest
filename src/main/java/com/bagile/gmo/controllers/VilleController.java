package com.bagile.gmo.controllers;


import com.bagile.gmo.dto.Ville;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by SOUKA on 12/08/2016.
 */
@Controller
@RequestMapping(value = "/villes/")
public class VilleController {
    @Autowired
    private VilleService villeService;

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Ville> getVilles() throws AttributesNotFound, ErrorType {
        return villeService.findAll();
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Ville> getVilles(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by (Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return villeService.findAll(pageable);
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return villeService.size();
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return villeService.size(search);
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return villeService.isExist(id);
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Ville getVille(@PathVariable("id") Long id) throws IdNotFound {
        return villeService.findById(id);
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Ville> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return villeService.find(search);
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Ville> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return villeService.find(search, pageable);
    }

    //@PreAuthorize("hasRole('SOURCE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Ville add(@RequestBody Ville ville) {
        return villeService.save(ville);
    }

    //@PreAuthorize("hasRole('SOURCE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Ville set(@RequestBody Ville ville) {
        return villeService.save(ville);
    }

    //@PreAuthorize("hasRole('SOURCE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Ville ville) {
        villeService.delete(ville);
    }

    //@PreAuthorize("hasRole('SOURCE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        villeService.delete(id);
    }
}
