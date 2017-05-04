package com.sinno.ems.controller;

import com.sinno.ems.dto.MsgSend;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.MsgSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ASMAE on 04/05/2016.
 */

@Controller
@RequestMapping(value = "/msgsSends/")
public class MsgSendController {
    @Autowired
    private MsgSendService msgSendService;


    @PreAuthorize("hasRole('MESSAGE_SEND_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<MsgSend> getMsgSends() throws AttributesNotFound, ErrorType {

        return msgSendService.findAll();
    }

    @PreAuthorize("hasRole('MESSAGE_SEND_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<MsgSend> getMsgSends(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Pageable pageable = new PageRequest(page, size);
        return msgSendService.findAll( pageable);
    }

    @PreAuthorize("hasRole('MESSAGE_SEND_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return msgSendService.size();
    }

    @PreAuthorize("hasRole('MESSAGE_SEND_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return msgSendService.size();
    }

    @PreAuthorize("hasRole('MESSAGE_SEND_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return msgSendService.isExist(id);
    }

    @PreAuthorize("hasRole('MESSAGE_SEND_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public MsgSend getMsgSend(@PathVariable("id") Long id) throws IdNotFound {
        return msgSendService.findById(id);
    }

    @PreAuthorize("hasRole('MESSAGE_SEND_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<MsgSend> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return msgSendService.find(search);
    }

    @PreAuthorize("hasRole('MESSAGE_SEND_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<MsgSend> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Pageable pageable = new PageRequest(page, size);
        return msgSendService.find(search, pageable);
    }

    @PreAuthorize("hasRole('MESSAGE_SEND_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MsgSend add(@RequestBody MsgSend msgSend) {
        return msgSendService.save(msgSend);
    }

    @PreAuthorize("hasRole('MESSAGE_SEND_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MsgSend set(@RequestBody MsgSend msgSend) {
        return msgSendService.save(msgSend);
    }

    @PreAuthorize("hasRole('MESSAGE_SEND_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody MsgSend msgSend) {

        msgSendService.delete(msgSend);
    }

    @PreAuthorize("hasRole('MESSAGE_SEND_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        msgSendService.delete(id);
    }

}
