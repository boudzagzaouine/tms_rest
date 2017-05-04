package com.sinno.ems.export;

import com.sinno.ems.entities.TrpTransport;
import com.sinno.ems.mapper.wms.TransportMapperWMS;
import com.sinno.ems.util.EmsDate;
import com.sinno.wms.crud.convert.ConvertManagerCar;
import com.sinno.wms.crud.model.car.Carriers;
import com.sinno.wms.crud.utils.Utils;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALae on 06/05/2016.
 */
public class TransportExport {
    private TransportExport() {
    }

    public static void export(String path, TrpTransport transport, String operation, ServletContext servletContext) {
        Carriers carrierss = TransportMapperWMS.toModel(transport, operation);
        List<Carriers> list = new ArrayList<>();
        list.add(carrierss);
        try {
            new ConvertManagerCar().writeFileCarriers(servletContext.getRealPath("/WEB-INF/classes") + File.separator + "CAR01" + Utils.dateToString(EmsDate.getDateNow(), true) + ".txt", list);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
