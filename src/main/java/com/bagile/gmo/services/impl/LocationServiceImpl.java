package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Location;
import com.bagile.gmo.dto.Stock;
import com.bagile.gmo.entities.LocLocation;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.LocationMapper;
import com.bagile.gmo.repositories.LocationRepository;
import com.bagile.gmo.services.LocationService;
import com.bagile.gmo.services.StockService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
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
    private StockService stockService;
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
            //LOGGER.error(e.getMessage(),e);
        }
        return 0L;
    }

    @Override
    public Boolean isExist(Long id) {
        return locationRepository.existsById(id);
    }

    @Override
    public Location findById(Long id) throws IdNotFound {
        Location location = LocationMapper.toDto(locationRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
        if (null != location) {
            return location;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public Location findOne(String search) throws AttributesNotFound, ErrorType {
        return LocationMapper.toDto(locationRepository.findOne(Search.expression (search, LocLocation.class)).orElseThrow (() -> new AttributesNotFound (search)), false);
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
        Sort sort =  Sort.by(Sort.Direction.DESC, "locLocationUpdateDate");
        Pageable pageable =  PageRequest.of(page, size, sort);
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
        //LocLocation locLocation = locationRepository.findOne(id);
//        locLocation.setLocLocationIsActive(false);
//        locationRepository.saveAndFlush(locLocation);
      //  locationRepository.delete(locLocation);
        locationRepository.deleteById(id);
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
        List<Stock> stocks = stockService.findAll();
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

    /**
     * get default location for reception
     * @return
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public Location getDefaultLocationForReception() throws AttributesNotFound, ErrorType {
        return findOne("defaultLocation:true,locationStatus.id:2");
         //return findOne("locationStatus.id:2");

    }

    /**
     * get default location for delivery
     * @return
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public Location getDefaultLocationForDelivery() throws AttributesNotFound, ErrorType {
        return find("defaultLocation:true,locationStatus.id:1").stream().findFirst().orElse(null);
    }


}