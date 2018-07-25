package com.bagile.tms.controllers;

import com.bagile.tms.dto.GroupHabilitation;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.GroupHabilitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/groupHabilitations/")
public class GroupHabilitationController {

    @Autowired
    private GroupHabilitationService groupHabilitationService;

    @PreAuthorize("hasRole('GROUP_HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<GroupHabilitation> getGroupHabilitations() {
        return groupHabilitationService.findAll();
    }

    @PreAuthorize("hasRole('GROUP_HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<GroupHabilitation> getGroupHabilitations(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return groupHabilitationService.findAll(pageable);
    }

    @PreAuthorize("hasRole('GROUP_HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return groupHabilitationService.size();
    }

    @PreAuthorize("hasRole('GROUP_HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return groupHabilitationService.size(search);
    }

    @PreAuthorize("hasRole('GROUP_HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return groupHabilitationService.isExist(id);
    }    @PreAuthorize("hasRole('GROUP_HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public GroupHabilitation getGroupHabilitation(@PathVariable("id") Long id) throws IdNotFound {
        return groupHabilitationService.findById(id);
    }

    @PreAuthorize("hasRole('GROUP_HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<GroupHabilitation> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return groupHabilitationService.find(search);
    }

    @PreAuthorize("hasRole('GROUP_HABILITATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<GroupHabilitation> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return groupHabilitationService.find(search, pageable);
    }

    @PreAuthorize("hasRole('GROUP_HABILITATION_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GroupHabilitation add(@RequestBody GroupHabilitation groupHabilitation) {
        return groupHabilitationService.save(groupHabilitation);
    }

    @PreAuthorize("hasRole('GROUP_HABILITATION_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GroupHabilitation set(@RequestBody GroupHabilitation groupHabilitation) {
        return groupHabilitationService.save(groupHabilitation);
    }

    @PreAuthorize("hasRole('GROUP_HABILITATION_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody GroupHabilitation groupHabilitation) {

        groupHabilitationService.delete(groupHabilitation);
    }

    @PreAuthorize("hasRole('GROUP_HABILITATION_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        groupHabilitationService.delete(id);
    }
}