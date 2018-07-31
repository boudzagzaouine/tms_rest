package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Owner;
import com.bagile.tms.entities.OwnOwner;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.OwnerMapper;
import com.bagile.tms.repositories.OwnerRepository;
import com.bagile.tms.services.OwnerService;
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

@Service @Transactional
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;
 
 
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(OwnerService.class);


    @Override
    public Owner save(Owner owner) {
        LOGGER.info("save Owner");
        owner.setUpdateDate(EmsDate.getDateNow());
        if (0 >= owner.getId()) {
            owner.setCreationDate(EmsDate.getDateNow());
        }
        OwnOwner own = OwnerMapper.toEntity(owner, false);
        OwnOwner ownOwner = ownerRepository.saveAndFlush(own);
        Owner ownerr = OwnerMapper.toDto(ownOwner, false);
        return ownerr;
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
        return ownerRepository.existsById(id);
    }

    @Override
    public Owner findById(Long id) throws IdNotFound {
        Owner owner = OwnerMapper.toDto(ownerRepository.findById(id).get(), false);
        if (null != owner) {
            return owner;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Owner> find(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }

        return OwnerMapper.toDtos(ownerRepository.findAll(Search.expression(search, OwnOwner.class)), false);
    }

    @Override
    public List<Owner> findAllForHabilitation() throws AttributesNotFound, ErrorType {
        return OwnerMapper.toDtos(ownerRepository.findAll(), false);

    }

    @Override
    public List<Owner> find(String search, int page, int size) throws AttributesNotFound, ErrorType {

        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "ownOwnerUpdateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OwnerMapper.toDtos(ownerRepository.findAll(Search.expression(search, OwnOwner.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return ownerRepository.count(Search.expression(search, OwnOwner.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Owner");
        OwnOwner ownOwner = ownerRepository.findById(id).get();
        ownOwner.setOwnOwnerIsActive(false);
        ownerRepository.saveAndFlush(ownOwner);
    }

    @Override
    public void delete(Owner owner) {
        LOGGER.info("delete Owner");
        OwnOwner ownOwner = ownerRepository.findById(owner.getId()).get();
        ownOwner.setOwnOwnerIsActive(false);
        ownerRepository.saveAndFlush(ownOwner);
        //ownerRepository.delete(OwnerMapper.toEntity(owner, false));
        
    }

    @Override
    public List<Owner> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<Owner> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        return find("", page, size);
    }


    
}