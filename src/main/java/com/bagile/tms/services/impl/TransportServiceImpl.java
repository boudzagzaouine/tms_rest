package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Transport;
import com.bagile.tms.entities.TrpTransport;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.TransportMapper;
import com.bagile.tms.repositories.TransportRepository;
import com.bagile.tms.services.TransportService;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class TransportServiceImpl implements TransportService {

    @Autowired
    private TransportRepository transportRepository;

   private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS") ;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(TransportService.class);


    @Override
    public Transport save(Transport transport) {
        LOGGER.info("save Transport");
        transport.setUpdateDate(EmsDate.getDateNow());
        if (0 >= transport.getId()) {
            transport.setCreationDate(EmsDate.getDateNow());
        }
        TrpTransport trp = TransportMapper.toEntity(transport, false);
        TrpTransport trpTransport = transportRepository.saveAndFlush(trp);

        return TransportMapper.toDto(trpTransport,true);
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
        return transportRepository.existsById(id);
    }

    @Override
    public Transport findById(Long id) throws IdNotFound {
        Transport transport = TransportMapper.toDto(transportRepository.findById(id).get(), false);
        if (null != transport) {
            return transport;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Transport> find(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return TransportMapper.toDtos(transportRepository.findAll(Search.expression(search, TrpTransport.class)), false);
    }

    @Override
    public List<Transport> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "trpTransportUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return TransportMapper.toDtos(transportRepository.findAll(Search.expression(search, TrpTransport.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return transportRepository.count(Search.expression(search, TrpTransport.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Transport");
        TrpTransport trpTransport = transportRepository.findById(id).get();
        trpTransport.setTrpTransportIsActive(false);
        transportRepository.saveAndFlush(trpTransport);
    }

    @Override
    public void delete(Transport transport) {
        delete(transport.getId());
    }


    @Override
    public List<Transport> findAll() {
        return TransportMapper.toDtos(transportRepository.findAll(), false);
    }

    @Override
    public List<Transport> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        return find("", page, size);
    }

}