package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Transport;
import com.bagile.gmo.entities.TrpTransport;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TransportMapper;
import com.bagile.gmo.repositories.TransportRepository;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.services.TransportService;
import com.bagile.gmo.util.GmaoSearch;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TransportServiceImpl implements TransportService, GmaoSearch {
    private final TransportRepository transportRepository;
    @Autowired
    private SettingService settingService;

    public TransportServiceImpl(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    @Override
    public Transport save(Transport transport) {
        transport.setGmao(true);
        return TransportMapper.toDto(transportRepository.saveAndFlush(TransportMapper.toEntity(transport, false)), false);
    }

    @Override
    public Long size() throws AttributesNotFound, ErrorType {
        return transportRepository.count(Search.expression(addGmaoToSearch(""), TrpTransport.class));
    }

    @Override
    public Boolean isExist(Long id) {
        return transportRepository.existsById(id);
    }

    @Override
    public Transport findById(Long id) throws IdNotFound {
        return TransportMapper.toDto(transportRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Transport> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TransportMapper.toDtos(transportRepository.findAll(Search.expression(addGmaoToSearch(search), TrpTransport.class)), false);
    }

    @Override
    public List<Transport> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportMapper.toDtos(transportRepository.findAll(Search.expression(addGmaoToSearch(search), TrpTransport.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return transportRepository.count(Search.expression(addGmaoToSearch(""), TrpTransport.class));
    }

    @Override
    public void delete(Long id) {
        transportRepository.deleteById(id);
    }

    @Override
    public void delete(Transport transport) {
        transportRepository.delete(TransportMapper.toEntity(transport, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            transportRepository.deleteById(id);        }
    }
    @Override
    public List<Transport> findAll() {
        return TransportMapper.toDtos(transportRepository.findAll(), false);
    }

    @Override
    public List<Transport> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportMapper.toDtos(transportRepository.findAll(Search.expression(addGmaoToSearch(""), TrpTransport.class),pageable), false);
    }
    @Override
    public String getNextVal() {
        String value=settingService.generateCodeTransport() + transportRepository.getNextVal().get(0);
        return value;


    }


}

