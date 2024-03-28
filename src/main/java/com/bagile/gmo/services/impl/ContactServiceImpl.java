package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Contact;
import com.bagile.gmo.dto.Contact;
import com.bagile.gmo.entities.PrmContact;
import com.bagile.gmo.entities.PrmContact;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ContactMapper;
import com.bagile.gmo.mapper.ContactMapper;
import com.bagile.gmo.repositories.ContactRepository;
import com.bagile.gmo.services.ContactService;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.util.AddActive;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService, AddActive {

    private final ContactRepository contactRepository;
    //@Autowired
    // private SettingService settingService;

    @Autowired
    private SettingService settingService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger (ContactService.class);

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact save(Contact contact) {
        LOGGER.info ("save Contact");
        // contact.setUpdate(EmsDate.getDateNow());
        if (0 >= contact.getId ( )) {
            contact.setCreationDate (EmsDate.getDateNow ( ));
        }
        return ContactMapper.toDto (contactRepository.saveAndFlush (ContactMapper.toEntity (contact, false)), false);
    }

    @Override
    public Long size() throws AttributesNotFound, ErrorType {
        return contactRepository.count(Search.expression(addActiveToSearch(""), PrmContact.class));
    }

    @Override
    public Boolean isExist(Long id) {
        return contactRepository.existsById(id);
    }

    @Override
    public Contact findById(Long id) throws IdNotFound {
        return ContactMapper.toDto(contactRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Contact> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ContactMapper.toDtos(contactRepository.findAll(Search.expression(addActiveToSearch(search), PrmContact.class)), false);
    }

    @Override
    public List<Contact> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ContactMapper.toDtos(contactRepository.findAll(Search.expression(addActiveToSearch(search), PrmContact.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return contactRepository.count(Search.expression(addActiveToSearch(""), PrmContact.class));
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.delete(ContactMapper.toEntity(contact, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            delete(id);        }
    }
    @Override
    public List<Contact> findAll() throws AttributesNotFound, ErrorType {
        return ContactMapper.toDtos(contactRepository.findAll(Search.expression(addActiveToSearch(""), PrmContact.class)), false);
    }

    @Override
    public List<Contact> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ContactMapper.toDtos(contactRepository.findAll(Search.expression(addActiveToSearch(""), PrmContact.class),pageable), false);
    }
    @Override
    public String getNextVal() {
        String value=settingService.generateCodeContact() + contactRepository.getNextVal().get(0);
        return value;

    }



}