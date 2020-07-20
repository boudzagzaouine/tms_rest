package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Day;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.DayService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/days")
public class DayController {

    private final DayService monthService;

    public DayController(DayService monthService) {
        this.monthService = monthService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Day> getAll() {
        return monthService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Day> getAll(@RequestParam int page, @RequestParam int size) {
        return monthService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Day getOne(@PathVariable("id") Long id) throws IdNotFound {
        return monthService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return monthService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return monthService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return monthService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Day> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return monthService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Day> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return monthService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Day add(@RequestBody Day month) {
        return monthService.save(month);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Day set(@RequestBody Day month) {
        return monthService.save(month);
    }

    @RequestMapping(value = "/saveALL", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Day> addAll(@RequestBody List<Day> months) {
        return  monthService.saveAll(months);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Day month) {
        monthService.delete(month);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        monthService.delete(id);
    }
}
