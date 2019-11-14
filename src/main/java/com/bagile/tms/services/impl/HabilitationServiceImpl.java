package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Habilitation;
import com.bagile.tms.entities.UsrHabilitation;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.HabilitationMapper;
import com.bagile.tms.repositories.HabilitationRepository;
import com.bagile.tms.services.HabilitationService;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional

public class HabilitationServiceImpl implements HabilitationService {

    private final HabilitationRepository habilitationRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(HabilitationService.class);

    public HabilitationServiceImpl(HabilitationRepository habilitationRepository) {
        this.habilitationRepository = habilitationRepository;
    }

    @Override
    public Habilitation save(String[] codes) {
        Habilitation h = null;
        for (String code : codes) {
            Habilitation habilitation = new Habilitation();
            habilitation.setCode(code.toUpperCase());
            h = save(habilitation);
        }

        return h;
    }

    @Override
    public Habilitation save(Habilitation habilitation) {
        LOGGER.info("save Habilitation");
        habilitation.setUpdateDate(EmsDate.getDateNow());
        if (0 >= habilitation.getId()) {
            habilitation.setCreationDate(EmsDate.getDateNow());
        }
        UsrHabilitation savedHabilitation = habilitationRepository.save(HabilitationMapper.toEntity(habilitation, false));

        Habilitation view = new Habilitation();
        view.setCode(habilitation.getCode().toUpperCase() + "_VIEW");
        view.setCreationDate(habilitation.getCreationDate());
        view.setUpdateDate(habilitation.getUpdateDate());
        view.setHabilitation(HabilitationMapper.toDto(savedHabilitation, false));


        Habilitation create = new Habilitation();
        create.setCode(habilitation.getCode().toUpperCase() + "_CREATE");
        create.setCreationDate(habilitation.getCreationDate());
        create.setUpdateDate(habilitation.getUpdateDate());
        create.setHabilitation(HabilitationMapper.toDto(savedHabilitation, false));

        Habilitation edit = new Habilitation();
        edit.setCode(habilitation.getCode().toUpperCase() + "_EDIT");
        edit.setCreationDate(habilitation.getCreationDate());
        edit.setUpdateDate(habilitation.getUpdateDate());
        edit.setHabilitation(HabilitationMapper.toDto(savedHabilitation, false));

        Habilitation delete = new Habilitation();
        delete.setCode(habilitation.getCode().toUpperCase() + "_DELETE");
        delete.setCreationDate(habilitation.getCreationDate());
        delete.setUpdateDate(habilitation.getUpdateDate());
        delete.setHabilitation(HabilitationMapper.toDto(savedHabilitation, false));

        Set<Habilitation> list = new HashSet<>();
        list.add(view);
        list.add(create);
        list.add(edit);
        list.add(delete);

        habilitationRepository.saveAll(HabilitationMapper.toEntities(list, false));

        return HabilitationMapper.toDto(savedHabilitation, false);
    }

    @Override
    public Long size() {
        return habilitationRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return habilitationRepository.existsById(id);
    }

    @Override
    public Habilitation findById(Long id) throws IdNotFound {
        Habilitation habilitation = HabilitationMapper.toDto(habilitationRepository.findById(id).get(), false);
        if (null != habilitation) {
            return habilitation;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Habilitation> find(String search) throws AttributesNotFound, ErrorType {
        return HabilitationMapper.toDtos(habilitationRepository.findAll(Search.expression(search, UsrHabilitation.class)), false);
    }

    @Override
    public List<Habilitation> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return HabilitationMapper.toDtos(habilitationRepository.findAll(Search.expression(search, UsrHabilitation.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return habilitationRepository.count(Search.expression(search, UsrHabilitation.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Habilitation");
        habilitationRepository.deleteById(id);
    }

    @Override
    public void delete(Habilitation habilitation) {
        LOGGER.info("delete Habilitation");
        habilitationRepository.delete(HabilitationMapper.toEntity(habilitation, false));
    }

    @Override
    public List<Habilitation> findAll() {
        return HabilitationMapper.toDtos(habilitationRepository.findAll(), false);
    }

    @Override
    public List<Habilitation> findAll(Pageable pageable) {
        return HabilitationMapper.toDtos(habilitationRepository.findAll(pageable), false);
    }
}