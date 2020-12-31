package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.DieselDeclaration;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.DieselDeclarationService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/dieselDeclarations")
public class DieselDeclarationController {


    private final DieselDeclarationService dieselDeclarationService;
    public DieselDeclarationController(DieselDeclarationService dieselDeclarationService) {
        this.dieselDeclarationService = dieselDeclarationService;
    }

    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<DieselDeclaration> getDieselDeclarations() {return dieselDeclarationService.findAll();}
   //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<DieselDeclaration> getDieselDeclaration(@RequestParam int page, @RequestParam int size) {
        return dieselDeclarationService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return dieselDeclarationService.size();
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return dieselDeclarationService.size(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return dieselDeclarationService.isExist(id);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public DieselDeclaration getDieselDeclaration(@PathVariable("id") Long id) throws IdNotFound {
        return dieselDeclarationService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<DieselDeclaration> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return dieselDeclarationService.find(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<DieselDeclaration> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return dieselDeclarationService.find(search, page, size);

    }
    //@PreAuthorize("hasRole('BADGETYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DieselDeclaration add(@RequestBody DieselDeclaration dieselDeclaration ) throws AttributesNotFound, ErrorType, IdNotFound, IOException {return dieselDeclarationService.save(dieselDeclaration);}
    //@PreAuthorize("hasRole('BADGETYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DieselDeclaration set(@RequestBody DieselDeclaration dieselDeclaration) throws AttributesNotFound, ErrorType, IdNotFound, IOException {
        return dieselDeclarationService.save(dieselDeclaration);
    }
    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody DieselDeclaration dieselDeclaration) {

        dieselDeclarationService.delete(dieselDeclaration);
    }

    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        dieselDeclarationService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        dieselDeclarationService.deleteAll (Arrays.asList(ids));
    }


    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal()
    {
        return  dieselDeclarationService.getNextVal();
    }

}