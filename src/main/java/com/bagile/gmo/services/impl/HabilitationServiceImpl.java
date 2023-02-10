package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Habilitation;
import com.bagile.gmo.dto.Habilitation;
import com.bagile.gmo.entities.UsrHabilitation;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.HabilitationMapper;
import com.bagile.gmo.mapper.HabilitationMapper;
import com.bagile.gmo.repositories.HabilitationRepository;
import com.bagile.gmo.services.HabilitationService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

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
        UsrHabilitation savedHabilitation;
        LOGGER.info("save Habilitation");
        habilitation.setUpdateDate(EmsDate.getDateNow());
        if (0 >= habilitation.getId()) {
            habilitation.setCreationDate(EmsDate.getDateNow());
             savedHabilitation = habilitationRepository.save(HabilitationMapper.toEntity(habilitation, false));

//            Habilitation view = new Habilitation();
//            view.setCode(habilitation.getCode().toUpperCase() + "_VIEW");
//            view.setDescription(view.getCode());
//            view.setCreationDate(habilitation.getCreationDate());
//            view.setActive(true);
//            view.setId(-1);
//            view.setHabilitation(HabilitationMapper.toDto(savedHabilitation, false));


//            Habilitation create = new Habilitation();
//            create.setCode(habilitation.getCode().toUpperCase() + "_CREATE");
//            create.setDescription(create.getCode());
//            create.setActive(true);
//            create.setId(-2);
//            create.setCreationDate(habilitation.getCreationDate());
//            create.setHabilitation(HabilitationMapper.toDto(savedHabilitation, false));
//
//            Habilitation edit = new Habilitation();
//            edit.setCode(habilitation.getCode().toUpperCase() + "_EDIT");
//            edit.setDescription(edit.getCode());
//            edit.setActive(true);
//            edit.setId(-3);
//            edit.setCreationDate(habilitation.getCreationDate());
//            edit.setHabilitation(HabilitationMapper.toDto(savedHabilitation, false));
//
//            Habilitation delete = new Habilitation();
//            delete.setCode(habilitation.getCode().toUpperCase() + "_DELETE");
//            delete.setDescription(delete.getCode());
//
//            delete.setActive(true);
//            delete.setId(-4);
//            delete.setCreationDate(habilitation.getCreationDate());
//            delete.setHabilitation(HabilitationMapper.toDto(savedHabilitation, false));
//
//            Set<Habilitation> list = new HashSet<>();
//            list.add(view);
//            list.add(create);
//            list.add(edit);
//            list.add(delete);

           // habilitationRepository.saveAll(HabilitationMapper.toEntities(list, false));
        }
        else {
            habilitation.setUpdateDate(EmsDate.getDateNow());

            savedHabilitation = habilitationRepository.save(HabilitationMapper.toEntity(habilitation, false));

        }


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
        return HabilitationMapper.toDto(habilitationRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Habilitation> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return HabilitationMapper.toDtos(habilitationRepository.findAll(Search.expression(search, UsrHabilitation.class)), false);
    }

    @Override
    public List<Habilitation> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return HabilitationMapper.toDtos(habilitationRepository.findAll(Search.expression(search, UsrHabilitation.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return habilitationRepository.count(Search.expression(search, UsrHabilitation.class));
    }

    @Override
    public void delete(Long id) {
        habilitationRepository.deleteById(id);
    }

    @Override
    public void delete(Habilitation habilitation) {
        habilitationRepository.delete(HabilitationMapper.toEntity(habilitation, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            habilitationRepository.deleteById(id);        }
    }


    @Override
    public List<Habilitation> findAll() {
        return HabilitationMapper.toDtos(habilitationRepository.findAll(), false);
    }

    @Override
    public List<Habilitation> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return HabilitationMapper.toDtos(habilitationRepository.findAll(pageable), false);
    }

    @Override
    public Habilitation findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }
}