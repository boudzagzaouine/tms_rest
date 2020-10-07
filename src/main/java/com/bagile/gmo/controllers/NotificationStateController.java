package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.NotificationState;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.NotificationStateService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/notificationStates")
public class NotificationStateController {
    
    private final NotificationStateService notificationStateService;

    
    public NotificationStateController(NotificationStateService notificationStateService) {
        this.notificationStateService = notificationStateService;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<NotificationState> getNotificationStates() {
        return notificationStateService.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<NotificationState> getNotificationStates(@RequestParam int page, @RequestParam int size) {
        return notificationStateService.findAll(page, size);

    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return notificationStateService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return notificationStateService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return notificationStateService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public NotificationState getNotificationState(@PathVariable("id") Long id) throws IdNotFound {
        return notificationStateService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<NotificationState> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return notificationStateService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<NotificationState> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return notificationStateService.find(search, page, size);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public NotificationState add(@RequestBody NotificationState notification) {
        return notificationStateService.save(notification);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public NotificationState set(@RequestBody NotificationState notification) {
        return notificationStateService.save(notification);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody NotificationState notification) {
        notificationStateService.delete(notification);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        notificationStateService.delete(id);
    }

}
