package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Trajet;
import com.bagile.gmo.entities.TmsTrajet;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TrajetMapper;
import com.bagile.gmo.repositories.TrajetRepository;
import com.bagile.gmo.services.TrajetService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TrajetServiceImpl implements TrajetService {
    
    private final TrajetRepository trajetRepository;

    public TrajetServiceImpl(TrajetRepository trajetRepository) {
        this.trajetRepository = trajetRepository;
    }

    @Override
    public Trajet save(Trajet trajet) {
        return TrajetMapper.toDto(trajetRepository.saveAndFlush(TrajetMapper.toEntity(trajet, false)), false);
    }

    @Override
    public List<Trajet> saveAll(List<Trajet> trajets) throws AttributesNotFound, ErrorType {

        List<Trajet> trajetList = new ArrayList<>();

        for (Trajet trajet : trajets) {
            trajetList.add(save(trajet));
        }

        return trajetList;

    }

    @Override
    public Long size() {
        return trajetRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return trajetRepository.existsById(id);
    }

    @Override
    public Trajet findById(Long id) throws IdNotFound {
        return TrajetMapper.toDto(trajetRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Trajet> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TrajetMapper.toDtos(trajetRepository.findAll(Search.expression(search, TmsTrajet.class)), false);
    }

    @Override
    public List<Trajet> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TrajetMapper.toDtos(trajetRepository.findAll(Search.expression(search, TmsTrajet.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return trajetRepository.count(Search.expression(search, TmsTrajet.class));
    }

    @Override
    public void delete(Long id) {
        trajetRepository.deleteById(id);
    }

    @Override
    public void delete(Trajet trajet) {
        trajetRepository.delete(TrajetMapper.toEntity(trajet, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            trajetRepository.deleteById(id);        }
    }


    @Override
    public List<Trajet> findAll() {
        return TrajetMapper.toDtos(trajetRepository.findAll(), false);
    }

    @Override
    public List<Trajet> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TrajetMapper.toDtos(trajetRepository.findAll(pageable), false);
    }

    @Override
    public Trajet findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

