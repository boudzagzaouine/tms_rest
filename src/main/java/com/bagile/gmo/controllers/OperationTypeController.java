package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.OperationType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.OperationTypeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/operationsType")
public class OperationTypeController {

    private final OperationTypeService operationTypeService;

    public OperationTypeController(OperationTypeService operationTypeService) {
        this.operationTypeService = operationTypeService;
    }

    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<OperationType> getOperationTypes() {return operationTypeService.findAll();}
   //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<OperationType> getOperationType(@RequestParam int page, @RequestParam int size) {
        return operationTypeService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return operationTypeService.size();
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return operationTypeService.size(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return operationTypeService.isExist(id);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public OperationType getOperationType(@PathVariable("id") Long id) throws IdNotFound {
        return operationTypeService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<OperationType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return operationTypeService.find(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<OperationType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return operationTypeService.find(search, page, size);

    }
    //@PreAuthorize("hasRole('BADGETYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OperationType add(@RequestBody OperationType operationType ){return operationTypeService.save(operationType);}
    //@PreAuthorize("hasRole('BADGETYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OperationType set(@RequestBody OperationType operationType) {
        return operationTypeService.save(operationType);
    }
    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody OperationType operationType) {

        operationTypeService.delete(operationType);
    }

    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        operationTypeService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        operationTypeService.deleteAll (Arrays.asList(ids));
    }
}