package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Vacation;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(value = "/vacations")
public class VacationController {

    private final VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    //@PreAuthorize("hasAnyRole('VACATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Vacation> getVacation() {return vacationService.findAll();}
    //@PreAuthorize("hasAnyRole('VACATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Vacation> getVacation(@RequestParam int page, @RequestParam int size) {
        return vacationService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('VACATI0N_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return vacationService.size();
    }
    //@PreAuthorize("hasAnyRole('VACATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return vacationService.size(search);
    }
    //@PreAuthorize("hasAnyRole('VACATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return vacationService.isExist(id);
    }
    //@PreAuthorize("hasAnyRole('VACATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Vacation getVacation(@PathVariable("id") Long id) throws IdNotFound {
        return vacationService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('VACATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Vacation> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return vacationService.find(search);
    }
    //@PreAuthorize("hasAnyRole('VACATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Vacation> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return vacationService.find(search, page, size);

    }
    //@PreAuthorize("hasRole('VACATION_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Vacation add(@RequestBody Vacation vacation ){return vacationService.save(vacation);}
    //@PreAuthorize("hasRole('VACATION_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Vacation set(@RequestBody Vacation vacation) {
        return vacationService.save(vacation);
    }
    //@PreAuthorize("hasRole('VACATION_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Vacation vacation) {

        vacationService.delete(vacation);
    }

    //@PreAuthorize("hasRole('VACATION_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        vacationService.delete(id);
    }
}
