package com.bagile.tms.controllers;

import com.sinno.ems.dto.Alias;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.AliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/aliass/")
public class AliasController {

    @Autowired
    private AliasService aliasService;

    @PreAuthorize("hasRole('ALIAS_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Alias> getAliass() {
        return aliasService.findAll();
    }

    @PreAuthorize("hasRole('ALIAS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Alias> getAliass(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return aliasService.findAll(pageable);
    }

    @PreAuthorize("hasRole('ALIAS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return aliasService.size();
    }

    @PreAuthorize("hasRole('ALIAS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return aliasService.size(search);
    }

    @PreAuthorize("hasRole('ALIAS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return aliasService.isExist(id);
    }    @PreAuthorize("hasRole('ALIAS_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Alias getAlias(@PathVariable("id") Long id) throws IdNotFound {
        return aliasService.findById(id);
    }

    @PreAuthorize("hasRole('ALIAS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Alias> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return aliasService.find(search);
    }

    @PreAuthorize("hasRole('ALIAS_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Alias> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return aliasService.find(search, pageable);
    }

    @PreAuthorize("hasRole('ALIAS_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Alias add(@RequestBody Alias alias) {
        return aliasService.save(alias);
    }

    @PreAuthorize("hasRole('ALIAS_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Alias set(@RequestBody Alias alias) {
        return aliasService.save(alias);
    }

    @PreAuthorize("hasRole('ALIAS_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Alias alias) {

        aliasService.delete(alias);
    }

    @PreAuthorize("hasRole('ALIAS_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        aliasService.delete(id);
    }
}