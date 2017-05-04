package com.sinno.ems.mapper.wms;

import com.sinno.wms.crud.model.pst.StockContrastRequest;

/**
 * Created by TM161 on 01/06/2016.
 */
public class StockContrastRequestMapperWMS {
    private StockContrastRequestMapperWMS() {
    }

    public static StockContrastRequest toModel(String requestType) {
        if (requestType == null) {
            return null;
        }
        StockContrastRequest stockContrastRequest = new StockContrastRequest();
        stockContrastRequest.setRequestType(requestType);
        return stockContrastRequest;
    }
}
