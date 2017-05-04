package com.sinno.ems.export;

import com.sinno.ems.entities.StkStock;
import com.sinno.ems.mapper.wms.ChangesStatusStockMapperWMS;
import com.sinno.ems.util.EmsDate;
import com.sinno.wms.crud.convert.ConvertManagerCst;
import com.sinno.wms.crud.model.cst.ChangesStatusMaterial;
import com.sinno.wms.crud.utils.Utils;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TM161 on 31/05/2016.
 */
public class ChangesStatusStockExport {
    private ChangesStatusStockExport() {
    }

    public static void export(String path, StkStock stock, String operation, ServletContext servletContext) {
        ChangesStatusMaterial changesStatusMaterial =  ChangesStatusStockMapperWMS.toModel(stock,operation);
        List<ChangesStatusMaterial> cstList = new ArrayList<>();
        cstList.add(changesStatusMaterial);
        try {
            new ConvertManagerCst().writeFileStockStatusChangement(servletContext.getRealPath("/WEB-INF/classes")+ File.separator + "CST05" + Utils.dateToString(EmsDate.getDateNow(), true) + ".txt",cstList);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
