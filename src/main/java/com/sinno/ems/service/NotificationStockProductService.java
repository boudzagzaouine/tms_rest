package com.sinno.ems.service;

import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 07/10/2016.
 */
public interface NotificationStockProductService {
    List<NotificationStockProduct> findAll();

    List<NotificationStockProduct> findAll(Pageable pageable);

    Long size();
}
