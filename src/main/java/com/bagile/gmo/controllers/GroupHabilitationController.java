package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.GroupHabilitation;
import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.GroupHabilitationService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/groupHabilitations")
public class GroupHabilitationController {

    private final GroupHabilitationService groupHabilitationService;

    public GroupHabilitationController(GroupHabilitationService groupHabilitationService) {
        this.groupHabilitationService = groupHabilitationService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<GroupHabilitation> getAll() {
        return groupHabilitationService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<GroupHabilitation> getAll(@RequestParam int page, @RequestParam int size) {
        return groupHabilitationService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public GroupHabilitation getOne(@PathVariable("id") Long id) throws IdNotFound {
        return groupHabilitationService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return groupHabilitationService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return groupHabilitationService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return groupHabilitationService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<GroupHabilitation> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return groupHabilitationService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<GroupHabilitation> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return groupHabilitationService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GroupHabilitation add(@RequestBody GroupHabilitation groupHabilitation) {
        return groupHabilitationService.save(groupHabilitation);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GroupHabilitation set(@RequestBody GroupHabilitation groupHabilitation) {
        return groupHabilitationService.save(groupHabilitation);
    }


    @RequestMapping(value = "/saveALL", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<GroupHabilitation> addAll(@RequestBody List<GroupHabilitation> groupHabilitations) throws AttributesNotFound, ErrorType {
        return  groupHabilitationService.saveAll(groupHabilitations);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody GroupHabilitation groupHabilitation) {
        groupHabilitationService.delete(groupHabilitation);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        groupHabilitationService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        groupHabilitationService.deleteAll (Arrays.asList(ids));
    }

}
