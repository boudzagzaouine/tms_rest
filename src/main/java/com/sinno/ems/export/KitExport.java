package com.sinno.ems.export;

import com.sinno.ems.entities.PdtKit;
import com.sinno.ems.mapper.wms.KitMapperWMS;
import com.sinno.ems.util.EmsDate;
import com.sinno.wms.crud.convert.ConvertManagerKit;
import com.sinno.wms.crud.utils.Utils;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salah on 05/05/2016.
 */
public class KitExport {
    private KitExport() {
    }

    public static void export(String path, PdtKit pdtKit, String operation, ServletContext servletContext) {
        com.sinno.wms.crud.model.Kit kit1 = KitMapperWMS.toModel(pdtKit, operation);
        List<com.sinno.wms.crud.model.Kit> kits = new ArrayList<>();
        kits.add(kit1);
        try {
            new ConvertManagerKit().writeFileAlias(path + File.separator + "KIT03" + Utils.dateToString(EmsDate.getDateNow(), true) + ".txt", kits);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
