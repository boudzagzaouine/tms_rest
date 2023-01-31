package com.bagile.gmo.services;

import com.bagile.gmo.dto.GroupHabilitation;
import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GroupHabilitationService {

    public GroupHabilitation save(GroupHabilitation groupHabilitation);
    List<GroupHabilitation> saveAll(List<GroupHabilitation> groupHabilitations) throws AttributesNotFound, ErrorType;

    public Long size();

    public Boolean isExist(Long id);

    public GroupHabilitation findById(Long id) throws IdNotFound;

    public List<GroupHabilitation> find(String search) throws AttributesNotFound, ErrorType;

    public List<GroupHabilitation> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(GroupHabilitation groupHabilitation);

    public List<GroupHabilitation> findAll();

    public List<GroupHabilitation> findAll(int page, int size);

    void deleteAll (List<Long> ids);
}