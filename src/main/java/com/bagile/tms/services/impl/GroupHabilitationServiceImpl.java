package com.bagile.tms.services.impl;

import com.bagile.tms.dto.GroupHabilitation;
import com.bagile.tms.entities.UsrGroupHabilitation;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.GroupHabilitationMapper;
import com.bagile.tms.repositories.GroupHabilitationRepository;
import com.bagile.tms.services.GroupHabilitationService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupHabilitationServiceImpl implements GroupHabilitationService {

    @Autowired
    private GroupHabilitationRepository groupHabilitationRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(GroupHabilitationService.class);

    @Override
    public GroupHabilitation save(GroupHabilitation groupHabilitation) {
        LOGGER.info("save GroupHabilitaion");
        return GroupHabilitationMapper.toDto(groupHabilitationRepository.saveAndFlush(GroupHabilitationMapper.toEntity(groupHabilitation, false)), false);
    }

    @Override
    public Long size() {
        return groupHabilitationRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return groupHabilitationRepository.existsById(id);
    }

    @Override
    public GroupHabilitation findById(Long id) throws IdNotFound {
        GroupHabilitation groupHabilitation = GroupHabilitationMapper.toDto(groupHabilitationRepository.findById(id).get(), false);
        if (null != groupHabilitation) {
            return groupHabilitation;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<GroupHabilitation> find(String search) throws AttributesNotFound, ErrorType {
        return GroupHabilitationMapper.toDtos(groupHabilitationRepository.findAll(Search.expression(search, UsrGroupHabilitation.class)), false);
    }

    @Override
    public List<GroupHabilitation> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return GroupHabilitationMapper.toDtos(groupHabilitationRepository.findAll(Search.expression(search, UsrGroupHabilitation.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return groupHabilitationRepository.count(Search.expression(search, UsrGroupHabilitation.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete GroupHabilitation");
        groupHabilitationRepository.deleteById(id);
    }

    @Override
    public void delete(GroupHabilitation groupHabilitation) {
        LOGGER.info("delete GroupHabilitation");
        groupHabilitationRepository.delete(GroupHabilitationMapper.toEntity(groupHabilitation, false));
    }

    @Override
    public List<GroupHabilitation> findAll() {
        return GroupHabilitationMapper.toDtos(groupHabilitationRepository.findAll(), false);
    }

    @Override
    public List<GroupHabilitation> findAll(Pageable pageable) {
        return GroupHabilitationMapper.toDtos(groupHabilitationRepository.findAll(pageable), false);
    }
}