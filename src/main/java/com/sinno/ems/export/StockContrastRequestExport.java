package com.sinno.ems.export;

import com.sinno.ems.mapper.wms.StockContrastRequestMapperWMS;
import com.sinno.ems.util.EmsDate;
import com.sinno.wms.crud.convert.ConvertManagerPst;
import com.sinno.wms.crud.model.pst.StockContrastRequest;
import com.sinno.wms.crud.utils.Utils;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TM161 on 01/06/2016.
 */
public class StockContrastRequestExport {
    private StockContrastRequestExport() {
    }

    public static void export(String path, String requestType , ServletContext servletContext) {
        StockContrastRequest stockContrastRequest =  StockContrastRequestMapperWMS.toModel(requestType);
        List<StockContrastRequest> pstList = new ArrayList<>();
        pstList.add(stockContrastRequest);
        try {
            new ConvertManagerPst().writeFileStockContrastRequest(servletContext.getRealPath("/WEB-INF/classes")+ File.separator + "PST04" + Utils.dateToString(EmsDate.getDateNow(), true) + ".txt",pstList);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
