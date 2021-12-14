package com.bagile.gmo.services.impl;


import com.bagile.gmo.dto.Ville;
import com.bagile.gmo.entities.PrmVille;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.VilleMapper;
import com.bagile.gmo.repositories.VilleRepository;
import com.bagile.gmo.services.VilleService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ffamm on 07/06/2017.
 */
@Service
public class VilleServiceImpl implements VilleService {
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VilleService.class);
    @Autowired
    private VilleRepository villeRepository;

    @Override
    public Ville save(Ville ville) {
        LOGGER.info("Save Ville");
        ville.setUpdateDate(EmsDate.getDateNow());
        if (0 >= ville.getId()) {
            ville.setCreationDate(EmsDate.getDateNow());
        }
        return VilleMapper.toDto(villeRepository.saveAndFlush(VilleMapper.toEntity(ville, false)), false);
    }

    @Override
    public Long size() {
        return villeRepository.count();
    }

    @Override
    public Boolean isExist(Long villeId) {
        return villeRepository.existsById(villeId);
    }

    @Override
    public Ville findById(Long villeId) throws IdNotFound {
        Ville ville = VilleMapper.toDto(villeRepository.findById(villeId).orElseThrow(() -> new IdNotFound(villeId)), false);
        if (null != ville) {
            return ville;
        } else {
            throw new IdNotFound(villeId);
        }
    }

    @Override
    public List<Ville> find(String search) throws AttributesNotFound, ErrorType {
        return VilleMapper.toDtos(villeRepository.findAll(Search.expression(search, PrmVille.class)), false);
    }

    @Override
    public List<Ville> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return VilleMapper.toDtos(villeRepository.findAll(Search.expression(search, PrmVille.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return villeRepository.count(Search.expression(search, PrmVille.class));
    }

    @Override
    public void delete(Long villeId) {
        LOGGER.info("delete Ville");
        villeRepository.deleteById(villeId);
    }

    @Override
    public void delete(Ville ville) {
        LOGGER.info("delete Ville");
        villeRepository.delete(VilleMapper.toEntity(ville, false));
    }

    @Override
    public List<Ville> findAll() throws AttributesNotFound, ErrorType {
        return VilleMapper.toDtos(villeRepository.findAll(), false);

    }

    @Override
    public List<Ville> findAll(Pageable pageable) throws AttributesNotFound, ErrorType {
        return VilleMapper.toDtos(villeRepository.findAll(pageable), false);
    }
}
