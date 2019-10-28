package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Contact;
import com.bagile.tms.entities.PrmContact;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.ContactMapper;
import com.bagile.tms.repositories.ContactRepository;
import com.bagile.tms.services.ContactService;
import com.bagile.tms.util.EmsDate;
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
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
   // private SettingService settingService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ContactService.class);

    @Override
    public Contact save(Contact contact) {
        LOGGER.info("save Contact");
       // contact.setUpdate(EmsDate.getDateNow());
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
        return contactRepository.existsById(id);
    }

    @Override
    public Contact findById(Long id) throws IdNotFound {
        Contact contact = ContactMapper.toDto(contactRepository.findById(id).get(), false);
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
    public Contact findOne(String search) throws AttributesNotFound, ErrorType {
        return ContactMapper.toDto(contactRepository.findOne(Search.expression(search, PrmContact.class)).get(), false);

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
        PrmContact tmsContact=contactRepository.findById(id).get();
        tmsContact.setprmContactactive(false);
        contactRepository.saveAndFlush(tmsContact);
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