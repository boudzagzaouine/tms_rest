package com.bagile.tms.services;

import com.bagile.gmo.dto.GroupHabilitation;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
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