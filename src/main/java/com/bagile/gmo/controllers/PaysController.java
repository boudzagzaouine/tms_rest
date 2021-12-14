package com.bagile.gmo.controllers;


import com.bagile.gmo.dto.Pays;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.PaysService;
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
@RequestMapping(value = "/pays/")
public class PaysController {
    @Autowired
    private PaysService paysService;

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Pays> getPayss() throws AttributesNotFound, ErrorType {
        return paysService.findAll();
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Pays> getPayss(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Sort sort =  Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable =  PageRequest.of(page, size, sort);
        return paysService.findAll(pageable);
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return paysService.size();
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return paysService.size(search);
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return paysService.isExist(id);
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Pays getPays(@PathVariable("id") Long id) throws IdNotFound {
        return paysService.findById(id);
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Pays> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return paysService.find(search);
    }

    //@PreAuthorize("hasRole('SOURCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Pays> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable =  PageRequest.of(page, size);
        return paysService.find(search, pageable);
    }

    //@PreAuthorize("hasRole('SOURCE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Pays add(@RequestBody Pays pays) {
        return paysService.save(pays);
    }

    //@PreAuthorize("hasRole('SOURCE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Pays set(@RequestBody Pays pays) {
        return paysService.save(pays);
    }

    //@PreAuthorize("hasRole('SOURCE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Pays pays) {
        paysService.delete(pays);
    }

    //@PreAuthorize("hasRole('SOURCE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        paysService.delete(id);
    }
}
