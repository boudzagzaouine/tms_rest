package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Road;
import com.sinno.ems.entities.TmsRoad;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.RoadMapper;
import com.sinno.ems.repositories.RoadRepository;
import com.sinno.ems.service.RoadService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;


/**
 * Created by bouzi on 4/3/2017.
 */
@Service
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
        return roadRepository.exists(id);
    }

    @Override
    public Road findById(Long id) throws IdNotFound {
        Road road = RoadMapper.toDto(roadRepository.findOne(id), false);
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
        roadRepository.delete(id);
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
