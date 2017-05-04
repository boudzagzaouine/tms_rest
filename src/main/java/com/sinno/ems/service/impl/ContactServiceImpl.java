package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Contact;
import com.sinno.ems.entities.PrmContact;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ContactMapper;
import com.sinno.ems.repositories.ContactRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.ContactService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ContactService.class);

    @Override
    public Contact save(Contact contact) {
        LOGGER.info("save Contact");
        contact.setUpdateDate(EmsDate.getDateNow());
        if (0 >= contact.getId()) {
            contact.setCreationDate(EmsDate.getDateNow());
        }
        return ContactMapper.toDto(contactRepository.saveAndFlush(ContactMapper.toEntity(contact, false)), false);
    }

    @Override
    public Long size() {
        try {
            return size("");
        } catch (AttributesNotFound attributesNotFound) {
            ////attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public Boolean isExist(Long id) {
        return contactRepository.exists(id);
    }

    @Override
    public Contact findById(Long id) throws IdNotFound {
        Contact contact = ContactMapper.toDto(contactRepository.findOne(id), false);
        if (null != contact) {
            return contact;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Contact> find(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",") ) {
                search += ",";
            }
            search += "active:true";
        }
        return ContactMapper.toDtos(contactRepository.findAll(Search.expression(search, PrmContact.class)), false);
    }

    @Override
    public List<Contact> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",") ) {
                search += ",";
            }
            search += "active:true";
        }
        return ContactMapper.toDtos(contactRepository.findAll(Search.expression(search, PrmContact.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",") ) {
                search += ",";
            }
            search += "active:true";
        }
        return contactRepository.count(Search.expression(search, PrmContact.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Contact");
        PrmContact prmContact=contactRepository.findOne(id);
        prmContact.setPrmContactActive(false);
        contactRepository.saveAndFlush(prmContact);
    }

    @Override
    public void delete(Contact contact) {
        LOGGER.info("delete Contact");
        contact.setActive(false);
        contactRepository.saveAndFlush(ContactMapper.toEntity(contact, false));
    }

    @Override
    public List<Contact> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<Contact> findAll(Pageable pageable) throws AttributesNotFound, ErrorType {
        return find("",pageable);
    }
}