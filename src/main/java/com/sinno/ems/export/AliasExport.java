package com.sinno.ems.export;

import com.sinno.ems.entities.PdtAlias;
import com.sinno.ems.mapper.wms.AliasMapperWMS;
import com.sinno.ems.util.EmsDate;
import com.sinno.wms.crud.convert.ConvertManagerAli;
import com.sinno.wms.crud.utils.Utils;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salah on 04/05/2016.
 */
public class AliasExport {
    private AliasExport() {
    }

    public static void export(String path, PdtAlias pdtAlias, String newCode, String operation, ServletContext servletContext) {
        com.sinno.wms.crud.model.ali.Alias alias1 = AliasMapperWMS.toModel(pdtAlias,newCode, operation);
        List<com.sinno.wms.crud.model.ali.Alias> aliases = new ArrayList<>();
        aliases.add(alias1);
        try {
            //new ConvertManagerAli().writeFileAlias(path + File.separator+"ALI.txt" + Utils.dateToString(EmsDate.getDateNow(),true), aliases);
            new ConvertManagerAli().writeFileAlias(servletContext.getRealPath("/WEB-INF/classes") + File.separator+"ALI04" + Utils.dateToString(EmsDate.getDateNow(),true) + ".txt", aliases);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
