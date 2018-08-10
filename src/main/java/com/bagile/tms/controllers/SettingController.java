package com.bagile.tms.controllers;

import com.bagile.tms.dto.Setting;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 08/06/2016.
 */
@Controller
@RequestMapping("/settings")
public class SettingController {
    @Autowired
    private SettingService settingService;

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Setting> getSettings() {
        return settingService.findAll();
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Setting> getSettings(@RequestParam int page, @RequestParam int size) {
        return settingService.findAll(page, size);
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return settingService.size();
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return settingService.size(search);
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return settingService.isExist(id);
    }    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Setting getSetting(@PathVariable("id") Long id) throws IdNotFound {
        return settingService.findById(id);
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Setting> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return settingService.find(search);
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Setting> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return settingService.find(search,page, size);
    }

    //@PreAuthorize("hasRole('SETTING_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Setting add(@RequestBody Setting setting) {
        return settingService.save(setting);
    }

    //@PreAuthorize("hasRole('SETTING_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Setting set(@RequestBody Setting setting) {
        return settingService.save(setting);
    }

    //@PreAuthorize("hasRole('SETTING_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Setting setting) {

        settingService.delete(setting);
    }

    //@PreAuthorize("hasRole('SETTING_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        settingService.delete(id);
    }

}
