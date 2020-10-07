package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Notification;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.NotificationService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Notification> getNotifications() {
        return notificationService.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Notification> getNotifications(@RequestParam int page, @RequestParam int size) {
        return notificationService.findAll(page, size);

    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return notificationService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return notificationService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return notificationService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Notification getNotification(@PathVariable("id") Long id) throws IdNotFound {
        return notificationService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Notification> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return notificationService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Notification> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return notificationService.find(search, page, size);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Notification add(@RequestBody Notification notification) {
        return notificationService.save(notification);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Notification set(@RequestBody Notification notification) {
        return notificationService.save(notification);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Notification notification) {
        notificationService.delete(notification);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        notificationService.delete(id);
    }


    @RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void verify() throws IdNotFound, AttributesNotFound, ErrorType {
        notificationService.verify();
    }
}
