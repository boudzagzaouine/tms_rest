package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Road;
import com.bagile.tms.entities.TmsRoad;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.RoadMapper;
import com.bagile.tms.repositories.RoadRepository;
import com.bagile.tms.services.RoadService;
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
public class RoadServiceImpl implements RoadService {
    @Autowired
    private RoadRepository roadRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(RoadService.class);

    @Override
    public Road save(Road road) {
        LOGGER.info("save Road");
        return RoadMapper.toDto(roadRepository.saveAndFlush(RoadMapper.toEntity(road, false)), false);
    }

    @Override
    public Long size() {
        return roadRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return roadRepository.existsById(id);
    }

    @Override
    public Road findById(Long id) throws IdNotFound {
        Road road = RoadMapper.toDto(roadRepository.findById(id).get(), false);
        if (null != road) {
            return road;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Road> find(String search) throws AttributesNotFound, ErrorType {
        return RoadMapper.toDtos(roadRepository.findAll(Search.expression(search, TmsRoad.class)), false);
    }

    @Override
    public List<Road> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return RoadMapper.toDtos(roadRepository.findAll(Search.expression(search, TmsRoad.class),pageable ), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return roadRepository.count(Search.expression(search, TmsRoad.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save Road");
        roadRepository.deleteById(id);
    }

    @Override
    public void delete(Road road) {
        LOGGER.info("delete Road");
        roadRepository.delete(RoadMapper.toEntity(road, false));
    }

    @Override
    public List<Road> findAll() {
        return RoadMapper.toDtos(roadRepository.findAll(), false);
    }

    @Override
    public List<Road> findAll(Pageable pageable) {
        return RoadMapper.toDtos(roadRepository.findAll(pageable), false);
    }

}
