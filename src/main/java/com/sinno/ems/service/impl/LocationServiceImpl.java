package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Stock;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.LocationMapper;
import com.sinno.ems.mapper.StockMapper;
import com.sinno.ems.repositories.LocationRepository;
import com.sinno.ems.repositories.StockRepository;
import com.sinno.ems.service.LocationService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private StockRepository stockRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(LocationService.class);

    @Override
    public Location save(Location location) {
        LOGGER.info("save Location");
        location.setUpdateDate(EmsDate.getDateNow());
        if (0 >= location.getId()) {
            location.setCreationDate(EmsDate.getDateNow());
        }
        return LocationMapper.toDto(locationRepository.saveAndFlush(LocationMapper.toEntity(location, false)), false);
    }

    @Override
    public Long size() {
        try {
            return size("");
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public Boolean isExist(Long id) {
        return locationRepository.exists(id);
    }

    @Override
    public Location findById(Long id) throws IdNotFound {
        Location location = LocationMapper.toDto(locationRepository.findOne(id), false);
        if (null != location) {
            return location;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Location> find(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return LocationMapper.toDtos(locationRepository.findAll(Search.expression(search, LocLocation.class)), false);
    }

    @Override
    public List<Location> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "locLocationUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return LocationMapper.toDtos(locationRepository.findAll(Search.expression(search, LocLocation.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return locationRepository.count(Search.expression(search, LocLocation.class));
    }

    @Override
    public void delete(Long id) {
        LocLocation locLocation = locationRepository.findOne(id);
//        locLocation.setLocLocationIsActive(false);
//        locationRepository.saveAndFlush(locLocation);
        locationRepository.delete(locLocation);
    }

    @Override
    public void delete(Location location) {
        LOGGER.info("delete Location");
        location.setActive(false);
        locationRepository.saveAndFlush(LocationMapper.toEntity(location, false));
    }

    @Override
    public List<Location> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<Location> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        return find("", page, size);
    }

    @Override
    public List<Location> findEmtyLocation(String search) throws AttributesNotFound, ErrorType {

        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        List<Stock> stocks = StockMapper.toDtos(stockRepository.findAll(), false);
        List<Location> locationsFromStocks = stocks.stream().map(e -> e.getLocation()).collect(Collectors.toList());
        List<Location> locations = new ArrayList<>();
        //remove duplicate element from locationsFromStocks
        Set<Location> locationSet=new HashSet<>();
        locationSet.addAll(locationsFromStocks);
        locationsFromStocks.clear();
        locationsFromStocks.addAll(locationSet);

        LocationMapper.toDtos(locationRepository.findAll(Search.expression(search,LocLocation.class)), false).stream().forEach(locLocation -> {
            if (!locationsFromStocks.contains(locLocation)) {
                locations.add(locLocation);
            }
        });
        return locations;
    }
}