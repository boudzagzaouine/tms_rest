package com.sinno.ems.controller;

import com.sinno.ems.dto.Variable;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.VariableService;
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
@RequestMapping(value = "/variables/")
public class VariableController {

    @Autowired
    private VariableService variableService;


    @PreAuthorize("hasRole('VARIABLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Variable> getVariables() throws AttributesNotFound, ErrorType {
        return variableService.findAll();
    }

    @PreAuthorize("hasRole('VARIABLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Variable> getVariables(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "prmVariableUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return variableService.findAll(pageable);
    }

    @PreAuthorize("hasRole('VARIABLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return variableService.size();
    }

    @PreAuthorize("hasRole('VARIABLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return variableService.size(search);
    }

    @PreAuthorize("hasRole('VARIABLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return variableService.isExist(id);
    }    @PreAuthorize("hasRole('VARIABLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Variable getVariable(@PathVariable("id") Long id) throws IdNotFound {
        return variableService.findById(id);
    }

    @PreAuthorize("hasRole('VARIABLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Variable> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return variableService.find(search);
    }

    @PreAuthorize("hasRole('VARIABLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Variable> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return variableService.find(search, pageable);
    }

    @PreAuthorize("hasRole('VARIABLE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Variable add(@RequestBody Variable variable) {
        return variableService.save(variable);
    }

    @PreAuthorize("hasRole('VARIABLE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Variable set(@RequestBody Variable variable) {
        return variableService.save(variable);
    }

    @PreAuthorize("hasRole('VARIABLE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Variable variable) {

        variableService.delete(variable);
    }

    @PreAuthorize("hasRole('VARIABLE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        variableService.delete(id);
    }
}