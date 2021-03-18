package com.bagile.gmo.services;

import com.bagile.gmo.dto.Agent;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface AgentService {

    Agent save(Agent driver);

    Long size();

    Boolean isExist(Long id);

    Agent findById(Long id) throws IdNotFound;

    List<Agent> find(String search) throws AttributesNotFound, ErrorType;

    List<Agent> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Agent driver);
    void deleteAll(List<Long> ids);

    List<Agent> findAll();

    List<Agent> findAll(int page, int size);

    String getNextVal();
    void archive(Long id) throws IdNotFound;
}
