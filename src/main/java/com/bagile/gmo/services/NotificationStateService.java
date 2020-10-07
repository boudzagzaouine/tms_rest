package com.bagile.gmo.services;

import com.bagile.gmo.dto.NotificationState;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface NotificationStateService {
    NotificationState save(NotificationState NotificationState);

    Long size();

    Boolean isExist(Long id);

    NotificationState findById(Long id) throws IdNotFound;

    List<NotificationState> find(String search) throws AttributesNotFound, ErrorType;

    List<NotificationState> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(NotificationState NotificationState);

    List<NotificationState> findAll();

    List<NotificationState> findAll(int page, int size);
}
