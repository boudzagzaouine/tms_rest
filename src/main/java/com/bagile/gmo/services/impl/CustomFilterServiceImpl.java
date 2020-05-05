package com.bagile.gmo.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bagile.gmo.dto.CustomFilter;
import com.bagile.gmo.entities.FltrCustomFilter;
import com.bagile.gmo.mapper.CustomFilterMapper;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.repositories.CustomFilterRepository;
import com.bagile.gmo.services.CustomFilterService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;

@Service
@Transactional
public class CustomFilterServiceImpl implements CustomFilterService {

    private final CustomFilterRepository customFilterRepository;

    private final static Logger LOGGER = LoggerFactory
            .getLogger (CustomFilterService.class);

    public CustomFilterServiceImpl(CustomFilterRepository customFilterRepository) {
        this.customFilterRepository = customFilterRepository;
    }

    @Override
    public CustomFilter save(CustomFilter customFilter) {
        LOGGER.info ("save Contact");
        if (0 >= customFilter.getId ( )) {
        	customFilter.setCreationDate (EmsDate.getDateNow ( ));
        }
        return CustomFilterMapper.toDto (customFilterRepository.saveAndFlush (CustomFilterMapper.toEntity (customFilter, false)), false);
    }

    @Override
    public Long size() {
        try {
            return size ("");
        } catch (AttributesNotFound attributesNotFound) {
            ////attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public Boolean isExist(Long id) {
        return customFilterRepository.existsById (id);
    }

    @Override
    public CustomFilter findById(Long id) throws IdNotFound {
        return CustomFilterMapper.toDto (customFilterRepository.findById (id).orElseThrow (() -> new IdNotFound (id)), false);
    }

    @Override
    public List<CustomFilter> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        if (!search.trim ( ).contains ("active:false")) {
            if (!search.endsWith (",")) {
                search += ",";
            }
            search += "active:true";
        }
        return CustomFilterMapper.toDtos (customFilterRepository.findAll (Search.expression (search, FltrCustomFilter.class)), false);
    }

    @Override
    public List<CustomFilter> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        if (!search.trim ( ).contains ("active:false")) {
            if (!search.endsWith (",")) {
                search += ",";
            }
            search += "active:true";
        }
        Sort sort = Sort.by (Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of (page, size, sort);
        return CustomFilterMapper.toDtos (customFilterRepository.findAll (Search.expression (search, FltrCustomFilter.class), pageable), false);
    }

    @Override
    public CustomFilter findOne(String search) throws AttributesNotFound, ErrorType {
        return CustomFilterMapper.toDto (customFilterRepository.findOne (Search.expression (search, FltrCustomFilter.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        if (!search.trim ( ).contains ("active:false")) {
            if (!search.endsWith (",")) {
                search += ",";
            }
            search += "active:true";
        }
        return customFilterRepository.count (Search.expression (search, FltrCustomFilter.class));
    }

    @Override
    public void delete(long id) throws IdNotFound {
        LOGGER.info ("delete CustomFilter");
        FltrCustomFilter fltrCustomFilter = customFilterRepository.findById (id).orElseThrow (() -> new IdNotFound (id));
        customFilterRepository.saveAndFlush (fltrCustomFilter);
    }

    @Override
    public void delete(CustomFilter customFilter) {
        LOGGER.info ("delete CustomFilter");
        customFilterRepository.saveAndFlush (CustomFilterMapper.toEntity (customFilter, false));
    }

    @Override
    public List<CustomFilter> findAll() throws AttributesNotFound, ErrorType {
        return find ("");
    }

    @Override
    public List<CustomFilter> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        return find ("", page, size);
    }


}