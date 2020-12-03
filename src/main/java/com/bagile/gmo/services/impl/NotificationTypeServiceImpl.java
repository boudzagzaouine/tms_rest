package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.NotificationType;
import com.bagile.gmo.entities.GmoNotificationType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.NotificationTypeMapper;
import com.bagile.gmo.repositories.NotificationTypeRepository;
import com.bagile.gmo.services.NotificationTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class NotificationTypeServiceImpl implements NotificationTypeService {

    private final NotificationTypeRepository notificationTypeRepository;
    public NotificationTypeServiceImpl(NotificationTypeRepository notificationTypeRepository) {
        this.notificationTypeRepository = notificationTypeRepository;
    }

    @Override
    public NotificationType save(NotificationType notification) {
        return NotificationTypeMapper.toDto(notificationTypeRepository.saveAndFlush(NotificationTypeMapper.toEntity(notification, false)), false);
    }

    @Override
    public Long size() {
        return notificationTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return notificationTypeRepository.existsById(id);
    }

    @Override
    public NotificationType findById(Long id) throws IdNotFound {
        return NotificationTypeMapper.toDto(notificationTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<NotificationType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return NotificationTypeMapper.toDtos(notificationTypeRepository.findAll(Search.expression(search, GmoNotificationType.class)), false);
    }

    @Override
    public List<NotificationType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return NotificationTypeMapper.toDtos(notificationTypeRepository.findAll(Search.expression(search, GmoNotificationType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return notificationTypeRepository.count(Search.expression(search, GmoNotificationType.class));
    }

    @Override
    public void delete(Long id) {
        notificationTypeRepository.deleteById(id);
    }

    @Override
    public void delete(NotificationType notification) {
        notificationTypeRepository.delete(NotificationTypeMapper.toEntity(notification, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            notificationTypeRepository.deleteById(id);        }
    }

    @Override
    public List<NotificationType> findAll() {
        return NotificationTypeMapper.toDtos(notificationTypeRepository.findAll(), false);
    }

    @Override
    public List<NotificationType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return NotificationTypeMapper.toDtos(notificationTypeRepository.findAll(pageable), false);
    }

}

