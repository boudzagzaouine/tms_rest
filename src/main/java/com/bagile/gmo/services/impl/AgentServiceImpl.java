package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Agent;
import com.bagile.gmo.entities.GmoAgent;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.AgentMapper;
import com.bagile.gmo.repositories.AgentRepository;
import com.bagile.gmo.services.AgentService;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {
    private final AgentRepository agentRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AgentService.class);
    @Autowired
    private SettingService settingService;

    public AgentServiceImpl(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
      
    }

    @Override
    public Agent save(Agent agent) {
        LOGGER.info("save Agent");
        agent.setUpdateDate(EmsDate.getDateNow());
        if (0 <= agent.getId()) {
            agent.setCreationDate(EmsDate.getDateNow());
        }

        return AgentMapper.toDto(agentRepository.saveAndFlush(AgentMapper.toEntity(agent, false)), false);
    }

    @Override
    public Long size() {
        long count = agentRepository.count();
        return count;
    }

    @Override
    public Boolean isExist(Long id) {
        return agentRepository.existsById(id);
    }

    @Override
    public Agent findById(Long id) throws IdNotFound {
        return AgentMapper.toDto(agentRepository.findById(id).orElseThrow(() -> new IdNotFound(id)),false);
    }

    @Override
    public List<Agent> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals ("")){
            return findAll ();
        }
        return AgentMapper.toDtos(agentRepository.findAll(Search.expression(search, GmoAgent.class)), false);
    }

    @Override
    public List<Agent> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        //Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size);
        List<Agent> agents = AgentMapper.toDtos(agentRepository.findAll(Search.expression(search, GmoAgent.class), pageable), false);
        return agents;
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if ("".equals(search)) {
            return size();
        }
        return agentRepository.count(Search.expression(search, GmoAgent.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save Agent");
        agentRepository.deleteById(id);
    }

    @Override
    public void delete(Agent agent) {
        LOGGER.info("delete Agent");
        agentRepository.delete(AgentMapper.toEntity(agent, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            agentRepository.deleteById(id);        }
    }


    @Override
    public List<Agent> findAll() {
        return AgentMapper.toDtos(agentRepository.findAll(), false);
    }

    @Override
    public List<Agent> findAll(int page, int size) {
        //Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size);
        return AgentMapper.toDtos(agentRepository.findAll(pageable), false);
    }

    @Override
    public void archive(Long id) throws IdNotFound {
        LOGGER.info("archive Agent");
        Agent agent = AgentMapper.toDto(agentRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
        agent.setWorking(false);
        AgentMapper.toDto(agentRepository.saveAndFlush(AgentMapper.toEntity(agent, false)), false);

    }
    @Override
    public String getNextVal() {
        String value=settingService.generateAgent() + agentRepository.getNextVal().get(0);
        return value;


    }

}
