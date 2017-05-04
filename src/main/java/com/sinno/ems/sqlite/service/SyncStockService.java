package com.sinno.ems.sqlite.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.ProductControls;

/**
 * Created by Enissay on 17/11/2016.
 */
public interface SyncStockService {
    void syncStocks() throws ProductControls, AttributesNotFound, ErrorType;
}
