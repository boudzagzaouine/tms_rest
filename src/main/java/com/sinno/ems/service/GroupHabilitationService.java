package com.sinno.ems.service;

import com.sinno.ems.dto.GroupHabilitation;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GroupHabilitationService {

    public GroupHabilitation save(GroupHabilitation groupHabilitation);

    public Long size();

    public Boolean isExist(Long id);

    public GroupHabilitation findById(Long id) throws IdNotFound;

    public List<GroupHabilitation> find(String search) throws AttributesNotFound, ErrorType;

    public List<GroupHabilitation> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(GroupHabilitation groupHabilitation);

    public List<GroupHabilitation> findAll();

    public List<GroupHabilitation> findAll(Pageable pageable);
}