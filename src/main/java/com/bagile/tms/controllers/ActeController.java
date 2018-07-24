package com.bagile.tms.controllers;

import com.sinno.ems.dto.Acte;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ActeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by khalil on 27/03/2017.
 */
@Controller
@RequestMapping(value="/actes/")
public class ActeController {
    @Autowired
    private ActeService acteService;
    @PreAuthorize("hasAnyRole('ACTE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Acte> getActes() {return acteService.findAll();}
    @PreAuthorize("hasAnyRole('ACTE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Acte> getActes(@RequestParam int page, @RequestParam int size){
        Sort sort = new Sort(Sort.Direction.DESC,"prmActedateLastAct");
        Pageable pageable = new PageRequest(page,size,sort);
        return acteService.findAll(pageable);

    }
    @PreAuthorize("hasAnyRole('ACTE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return acteService.size();
    }
    @PreAuthorize("hasAnyRole('ACTE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return acteService.size(search);
    }
    @PreAuthorize("hasAnyRole('ACTE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return acteService.isExist(id);
    }
    @PreAuthorize("hasAnyRole('ACTE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Acte getActe(@PathVariable("id") Long id) throws IdNotFound {
        return acteService.findById(id);
    }
    @PreAuthorize("hasAnyRole('ACTE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Acte> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return acteService.find(search);
    }
    @PreAuthorize("hasAnyRole('ACTE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Acte> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
       return acteService.find(search, pageable);

    }
    @PreAuthorize("hasRole('ACTE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Acte add(@RequestBody Acte acte ){return acteService.save(acte);}
    @PreAuthorize("hasRole('ACTE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Acte set(@RequestBody Acte acte) {
        return acteService.save(acte);
    }
    @PreAuthorize("hasRole('ACTE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Acte acte) {

        acteService.delete(acte);
    }


}
