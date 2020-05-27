package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Patrimony;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.PatrimonyService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping(value = "/patrimonies/")
public class PatrimonyController {
    private final PatrimonyService patrimonyService;

    public PatrimonyController(PatrimonyService patrimonyService) {
        this.patrimonyService = patrimonyService;
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @GetMapping( value = "/list")
    @ResponseBody
    public List<Patrimony> getAll() {
        return patrimonyService.findAll();
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Patrimony> getAll(@RequestParam int page, @RequestParam int size) {
        return patrimonyService.findAll(page, size);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Patrimony getOne(@PathVariable("id") Long id) throws IdNotFound {
        return patrimonyService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return patrimonyService.size();
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return patrimonyService.size(search);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return patrimonyService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Patrimony> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return patrimonyService.find(search);
    }

    //@PreAuthorize("hasAnyRole('VEHICLE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Patrimony> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return patrimonyService.find(search, page, size);
    }

    //@PreAuthorize("hasRole('VEHICLE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Patrimony add(@RequestBody Patrimony patrimony) {
        return patrimonyService.save(patrimony);
    }

    //@PreAuthorize("hasRole('VEHICLE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Patrimony set(@RequestBody Patrimony patrimony) {
        return patrimonyService.save(patrimony);
    }

    //@PreAuthorize("hasRole('VEHICLE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Patrimony patrimony) {

        patrimonyService.delete(patrimony);
    }

    //@PreAuthorize("hasRole('VEHICLE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        patrimonyService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        patrimonyService.deleteAll (Arrays.asList(ids));
    }
}
