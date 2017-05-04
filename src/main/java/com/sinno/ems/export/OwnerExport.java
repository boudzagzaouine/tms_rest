package com.sinno.ems.export;

import com.sinno.ems.entities.OwnOwner;
import com.sinno.ems.mapper.wms.OwnerMapperWMS;
import com.sinno.ems.util.EmsDate;
import com.sinno.wms.crud.convert.ConvertManagerOwn;
import com.sinno.wms.crud.model.own.Owners;
import com.sinno.wms.crud.utils.Utils;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALae on 06/05/2016.
 */
public class OwnerExport {
    private OwnerExport() {
    }

    public static void export(String path, OwnOwner owner, String operation, ServletContext servletContext) {
        Owners owners = OwnerMapperWMS.toModel(owner, operation);
        List<Owners> list = new ArrayList<>();
        list.add(owners);
        try {
            new ConvertManagerOwn().writeFileOwners(servletContext.getRealPath("/WEB-INF/classes") + File.separator + "OWN01" + Utils.dateToString(EmsDate.getDateNow(), true) + ".txt", list);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
