package com.bagile.gmo.services;

import com.bagile.gmo.dto.Notification;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface NotificationService {
    Notification save(Notification Notification);
    List<Notification> saveAll(List<Notification> notifications);

    Long size();

    Boolean isExist(Long id);

    Notification findById(Long id) throws IdNotFound;

    List<Notification> find(String search) throws AttributesNotFound, ErrorType;

    List<Notification> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Notification Notification);
    Notification findOne(String search) throws AttributesNotFound, ErrorType;

    List<Notification> findAll();

    List<Notification> findAll(int page, int size);

    void verify () throws AttributesNotFound, ErrorType, IdNotFound;
}
