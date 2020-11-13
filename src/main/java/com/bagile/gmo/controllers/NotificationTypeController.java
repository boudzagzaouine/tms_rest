package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.NotificationType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.NotificationTypeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/notificationTypes")
public class NotificationTypeController {

    private final NotificationTypeService notificationTypeService;


    public NotificationTypeController(NotificationTypeService notificationTypeService) {
        this.notificationTypeService = notificationTypeService;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<NotificationType> getNotificationTypes() {
        return notificationTypeService.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<NotificationType> getNotificationTypes(@RequestParam int page, @RequestParam int size) {
        return notificationTypeService.findAll(page, size);

    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return notificationTypeService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return notificationTypeService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return notificationTypeService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public NotificationType getNotificationType(@PathVariable("id") Long id) throws IdNotFound {
        return notificationTypeService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<NotificationType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return notificationTypeService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<NotificationType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return notificationTypeService.find(search, page, size);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public NotificationType add(@RequestBody NotificationType notification) {
        return notificationTypeService.save(notification);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public NotificationType set(@RequestBody NotificationType notification) {
        return notificationTypeService.save(notification);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody NotificationType notification) {
        notificationTypeService.delete(notification);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        notificationTypeService.delete(id);
    }

}
