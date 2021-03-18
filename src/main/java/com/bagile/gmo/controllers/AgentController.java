package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Agent;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.AgentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value="/agents")
public class AgentController {
    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Agent> getAgents() {return agentService.findAll();}
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Agent> getAgents(@RequestParam int page, @RequestParam int size) {
        return agentService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return agentService.size();
    }
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return agentService.size(search);
    }
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return agentService.isExist(id);
    }
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Agent getAgent(@PathVariable("id") Long id) throws IdNotFound {
        return agentService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Agent> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return agentService.find(search);
    }
    //@PreAuthorize("hasAnyRole('DRIVER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Agent> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        List<Agent> agents = agentService.find(search, page, size);
        return agents;

    }
    //@PreAuthorize("hasRole('DRIVER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Agent add(@RequestBody Agent agent ){
        return agentService.save(agent);}
    //@PreAuthorize("hasRole('DRIVER_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Agent set(@RequestBody Agent agent) {

        return agentService.save(agent);
    }
   /* //@PreAuthorize("hasRole('DRIVER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Agent agent) {

        agentService.delete(agent);
    }*/

    //@PreAuthorize("hasRole('DRIVER_Archive')")
    @RequestMapping(value = "/archive", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Agent agent) throws IdNotFound {

        agentService.archive(agent.getId());
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        agentService.deleteAll (Arrays.asList(ids));
    }


    //@PreAuthorize("hasRole('DRIVER_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        agentService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal()
    {
        return  agentService.getNextVal();
    }
}
