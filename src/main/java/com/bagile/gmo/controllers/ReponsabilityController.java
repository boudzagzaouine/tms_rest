package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Responsability;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.ResponsabilityService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/responsabilities")
public class ReponsabilityController {

    private final ResponsabilityService responsabilityService;

    public ReponsabilityController(ResponsabilityService responsabilityService) {
        this.responsabilityService = responsabilityService;
    }

    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Responsability> getResponsabilitys() {return responsabilityService.findAll();}
   //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Responsability> getResponsability(@RequestParam int page, @RequestParam int size) {
        return responsabilityService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return responsabilityService.size();
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return responsabilityService.size(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return responsabilityService.isExist(id);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Responsability getResponsability(@PathVariable("id") Long id) throws IdNotFound {
        return responsabilityService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Responsability> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return responsabilityService.find(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Responsability> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return responsabilityService.find(search, page, size);

    }
    //@PreAuthorize("hasRole('BADGETYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Responsability add(@RequestBody Responsability responsability ){return responsabilityService.save(responsability);}
    //@PreAuthorize("hasRole('BADGETYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Responsability set(@RequestBody Responsability responsability) {
        return responsabilityService.save(responsability);
    }
    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Responsability responsability) {

        responsabilityService.delete(responsability);
    }

    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        responsabilityService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        responsabilityService.deleteAll (Arrays.asList(ids));
    }
}