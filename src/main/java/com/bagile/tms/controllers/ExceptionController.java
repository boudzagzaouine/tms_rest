package com.bagile.tms.controllers;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/exceptions/")
public class ExceptionController {

    @Autowired
    private ExceptionService exceptionService;

    @PreAuthorize("hasAnyRole('EXCEPTION_VIEW','STOCK_VIEW','CONTAINER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Exception> getExceptions() throws AttributesNotFound, ErrorType {
        return exceptionService.findAll();
    }

    @PreAuthorize("hasAnyRole('EXCEPTION_VIEW','STOCK_VIEW','CONTAINER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Exception> getExceptions(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return exceptionService.findAll(page, size);
    }

    @PreAuthorize("hasAnyRole('EXCEPTION_VIEW','STOCK_VIEW','CONTAINER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        return exceptionService.size();
    }

    @PreAuthorize("hasAnyRole('EXCEPTION_VIEW','STOCK_VIEW','CONTAINER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return exceptionService.size(search);

    }

    @PreAuthorize("hasAnyRole('EXCEPTION_VIEW','STOCK_VIEW','CONTAINER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return exceptionService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('EXCEPTION_VIEW','STOCK_VIEW','CONTAINER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Exception getException(@PathVariable("id") Long id) throws IdNotFound {
        return exceptionService.findById(id);
    }

    @PreAuthorize("hasAnyRole('EXCEPTION_VIEW','STOCK_VIEW','CONTAINER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Exception> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return exceptionService.find(search);
    }

    @PreAuthorize("hasAnyRole('EXCEPTION_VIEW','STOCK_VIEW','CONTAINER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Exception> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return exceptionService.find(search, page, size);
    }

    @PreAuthorize("hasAnyRole('EXCEPTION_CREATE','STOCK_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Exception add(@RequestBody Exception exception) {
        return exceptionService.save(exception);
    }

    @PreAuthorize("hasAnyRole('EXCEPTION_EDIT','STOCK_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Exception set(@RequestBody Exception exception) {
        return exceptionService.save(exception);
    }

    @PreAuthorize("hasAnyRole('EXCEPTION_DELETE','STOCK_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Exception exception) {
        exceptionService.delete(exception);
    }

    @PreAuthorize("hasAnyRole('EXCEPTION_DELETE','STOCK_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        exceptionService.delete(id);
    }
}