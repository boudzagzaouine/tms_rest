package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.NotificationState;
import com.bagile.gmo.entities.GmoNotificationState;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.NotificationStateMapper;
import com.bagile.gmo.repositories.NotificationStateRepository;
import com.bagile.gmo.services.NotificationStateService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class NotificationStateServiceImpl implements NotificationStateService {

    private final NotificationStateRepository notificationStateRepository;
    public NotificationStateServiceImpl(NotificationStateRepository notificationStateRepository) {
        this.notificationStateRepository = notificationStateRepository;
    }

    @Override
    public NotificationState save(NotificationState notification) {
        return NotificationStateMapper.toDto(notificationStateRepository.saveAndFlush(NotificationStateMapper.toEntity(notification, false)), false);
    }

    @Override
    public Long size() {
        return notificationStateRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return notificationStateRepository.existsById(id);
    }

    @Override
    public NotificationState findById(Long id) throws IdNotFound {
        return NotificationStateMapper.toDto(notificationStateRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<NotificationState> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return NotificationStateMapper.toDtos(notificationStateRepository.findAll(Search.expression(search, GmoNotificationState.class)), false);
    }

    @Override
    public List<NotificationState> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return NotificationStateMapper.toDtos(notificationStateRepository.findAll(Search.expression(search, GmoNotificationState.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return notificationStateRepository.count(Search.expression(search, GmoNotificationState.class));
    }

    @Override
    public void delete(Long id) {
        notificationStateRepository.deleteById(id);
    }

    @Override
    public void delete(NotificationState notification) {
        notificationStateRepository.delete(NotificationStateMapper.toEntity(notification, false));
    }

    @Override
    public List<NotificationState> findAll() {
        return NotificationStateMapper.toDtos(notificationStateRepository.findAll(), false);
    }

    @Override
    public List<NotificationState> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return NotificationStateMapper.toDtos(notificationStateRepository.findAll(pageable), false);
    }

}

