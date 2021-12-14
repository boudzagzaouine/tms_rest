package com.bagile.gmo.controllers;


import com.bagile.gmo.dto.ContainerType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.ContainerTypeService;
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
@RequestMapping(value = "/containerTypes/")
public class ContainerTypeController {

    @Autowired
    private ContainerTypeService containerTypeTypeService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<ContainerType> getContainerTypes() {
        return containerTypeTypeService.findAll();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ContainerType> getContainerTypes(@RequestParam int page, @RequestParam int size) {
        Sort sort =  Sort.by(Sort.Direction.DESC, "prmContainerTypeUpdateDate");
        Pageable pageable =  PageRequest.of(page, size, sort);
        return containerTypeTypeService.findAll(pageable);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return containerTypeTypeService.size();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return containerTypeTypeService.size(search);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return containerTypeTypeService.isExist(id);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public ContainerType getContainerType(@PathVariable("id") Long id) throws IdNotFound {
        return containerTypeTypeService.findById(id);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/GetCode/{code}")
    @ResponseBody
    public ContainerType getContainerType(@PathVariable("code") String code) {
        return containerTypeTypeService.findByCode(code);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ContainerType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return containerTypeTypeService.find(search);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ContainerType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return containerTypeTypeService.find(search, page, size);
    }

    @PreAuthorize("hasRole('CONTAINER_TYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ContainerType add(@RequestBody ContainerType containerTypeType) {
        return containerTypeTypeService.save(containerTypeType);
    }

    @PreAuthorize("hasRole('CONTAINER_TYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ContainerType set(@RequestBody ContainerType containerTypeType) {
        return containerTypeTypeService.save(containerTypeType);
    }

    @PreAuthorize("hasRole('CONTAINER_TYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ContainerType containerTypeType) {

        containerTypeTypeService.delete(containerTypeType);
    }

    @PreAuthorize("hasRole('CONTAINER_TYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        containerTypeTypeService.delete(id);
    }
}