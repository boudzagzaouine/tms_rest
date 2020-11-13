package com.bagile.gmo.services;

import com.bagile.gmo.dto.NotificationType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface NotificationTypeService {
    NotificationType save(NotificationType NotificationType);

    Long size();

    Boolean isExist(Long id);

    NotificationType findById(Long id) throws IdNotFound;

    List<NotificationType> find(String search) throws AttributesNotFound, ErrorType;

    List<NotificationType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(NotificationType NotificationType);

    List<NotificationType> findAll();

    List<NotificationType> findAll(int page, int size);
}
