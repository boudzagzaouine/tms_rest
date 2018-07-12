package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.MovementTypeService;
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
@RequestMapping(value = "/movementTypes/")
public class MovementTypeController {

    @Autowired
    private MovementTypeService movementTypeService;

    @PreAuthorize("hasAnyRole('MOVEMENT_TYPE_VIEW','INVOICE_RULES_VIEW','INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<MovementType> getMovementTypes() {
        return movementTypeService.findAll();
    }

    @PreAuthorize("hasAnyRole('MOVEMENT_TYPE_VIEW','INVOICE_RULES_VIEW','INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<MovementType> getMovementTypes(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "invMovementTypeUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return movementTypeService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('MOVEMENT_TYPE_VIEW','INVOICE_RULES_VIEW','INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return movementTypeService.size();
    }

    @PreAuthorize("hasAnyRole('MOVEMENT_TYPE_VIEW','INVOICE_RULES_VIEW','INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return movementTypeService.size(search);
    }

    @PreAuthorize("hasAnyRole('MOVEMENT_TYPE_VIEW','INVOICE_RULES_VIEW','INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return movementTypeService.isExist(id);
    }        @PreAuthorize("hasAnyRole('MOVEMENT_TYPE_VIEW','INVOICE_RULES_VIEW','INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public MovementType getMovementType(@PathVariable("id") Long id) throws IdNotFound {
        return movementTypeService.findById(id);
    }

    @PreAuthorize("hasAnyRole('MOVEMENT_TYPE_VIEW','INVOICE_RULES_VIEW','INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<MovementType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return movementTypeService.find(search);
    }

    @PreAuthorize("hasAnyRole('MOVEMENT_TYPE_VIEW','INVOICE_RULES_VIEW','INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<MovementType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return movementTypeService.find(search, pageable);
    }

    @PreAuthorize("hasRole('MOVEMENT_TYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MovementType add(@RequestBody MovementType movementType) {
        return movementTypeService.save(movementType);
    }

    @PreAuthorize("hasRole('MOVEMENT_TYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MovementType set(@RequestBody MovementType movementType) {
        return movementTypeService.save(movementType);
    }

    @PreAuthorize("hasRole('MOVEMENT_TYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody MovementType movementType) {

        movementTypeService.delete(movementType);
    }

    @PreAuthorize("hasRole('MOVEMENT_TYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        movementTypeService.delete(id);
    }
}