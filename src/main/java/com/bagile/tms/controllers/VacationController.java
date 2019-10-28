package com.bagile.tms.controllers;

import com.bagile.tms.dto.Vacation;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class VacationController {

    @Autowired
    private VacationService vacationService;
    //@PreAuthorize("hasAnyRole('VACATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Vacation> getVacation() {return vacationService.findAll();}
    //@PreAuthorize("hasAnyRole('VACATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Vacation> getVacation(@RequestParam int page, @RequestParam int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "prmColorUpdateDate");
        Pageable pageable = PageRequest.of(page, size,sort);
        return vacationService.findAll(pageable);

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
        Pageable pageable = PageRequest.of(page, size);
        return vacationService.find(search, pageable);

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
