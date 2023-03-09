package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Company;
import com.bagile.gmo.dto.Transport;
import com.bagile.gmo.entities.TrpTransport;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.CompanyMapper;
import com.bagile.gmo.mapper.TransportMapper;
import com.bagile.gmo.repositories.TransportRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.GmaoSearch;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransportServiceImpl implements TransportService, GmaoSearch {
    private final TransportRepository transportRepository;
    @Autowired
    private SettingService settingService;
    @Autowired
    private CatalogTransportPricingService catalogTransportPricingService;
    @Autowired
    private CatalogTransportAccountPricingService catalogTransportAccountPricingService;
    @Autowired
    private TransportServiceService transportServiceService;
    public TransportServiceImpl(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    @Override
    public Transport save(Transport transport) throws ErrorType, AttributesNotFound {
        transport.setGmao(true);
        if(transport.getActive()==null){
            transport.setActive(false);
        }
        if(transport.getInterneOrExterne()==null){
            transport.setInterneOrExterne(false);
        }

        Transport transport1 =  TransportMapper.toDto(transportRepository.saveAndFlush(TransportMapper.toEntity(transport, false)), false);
        if(transport.getId()<=0) {
            if (transport.getCatalogTransportPricings() != null) {
                transport.getCatalogTransportPricings().forEach(
                        element -> element.setTransport(transport1)
                );
                this.catalogTransportPricingService.saveAll(transport.getCatalogTransportPricings());
            }
            if (transport.getCatalogTransportAccountPricings() != null) {
                transport.getCatalogTransportAccountPricings().forEach(
                        element -> element.setTransport(transport1)
                );
                this.catalogTransportAccountPricingService.saveAll(transport.getCatalogTransportAccountPricings());
            }
            if (transport.getCatalogTransportServices() != null) {
                transport.getCatalogTransportServices().forEach(
                        element -> element.setTransport(transport1)
                );
                this.transportServiceService.saveAll(transport.getCatalogTransportServices());
            }
        }
       return transport1;
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
    public List<Transport> findAll() throws AttributesNotFound, ErrorType {
        return TransportMapper.toDtos(transportRepository.findAll(Search.expression(addGmaoToSearch(""), TrpTransport.class)), false);
    }

    @Override
    public List<Transport> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportMapper.toDtos(transportRepository.findAll(Search.expression(addGmaoToSearch(""), TrpTransport.class),pageable), false);
    }
    @Override
    public String getNextVal() {
        String value="TRANS" + transportRepository.getNextVal().get(0);
        return value;


    }


}

