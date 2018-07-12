package com.sinno.ems.service.impl;

import com.sinno.ems.repositories.NotificationStockProductRepository;
import com.sinno.ems.service.NotificationStockProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Enissay on 07/10/2016.
 */
@Service
public class NotificationStockProductServiceImpl implements NotificationStockProductService {
    @Autowired
    private NotificationStockProductRepository notificationStockProductRepository;

    @Override
    public List<NotificationStockProduct> findAll() {
        return notificationStockProductRepository.findAll();
    }

    @Override
    public List<NotificationStockProduct> findAll(Pageable pageable) {

        Iterator<NotificationStockProduct> notificationStockProductIterator = notificationStockProductRepository.findAll(pageable).iterator();
        List<NotificationStockProduct> notificationStockProducts = new ArrayList<NotificationStockProduct>();
        while (notificationStockProductIterator.hasNext()) {
            notificationStockProducts.add(notificationStockProductIterator.next());
        }
        return notificationStockProducts;
    }

    @Override
    public Long size() {
        return notificationStockProductRepository.count();
    }

}
