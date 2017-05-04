package com.sinno.ems.export;

import com.sinno.ems.entities.RcpReception;
import com.sinno.ems.mapper.wms.ReceptionOrderMapperWMS;
import com.sinno.ems.util.EmsDate;
import com.sinno.wms.crud.convert.ConvertManagerPre;
import com.sinno.wms.crud.model.pre.ReceptionOrderHeader;
import com.sinno.wms.crud.utils.Utils;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salah on 01/06/2016.
 */
public class ReceptionOrderExport {
    private ReceptionOrderExport() {
    }

    public static void export(String path, RcpReception rcpReception, String operation, ServletContext servletContext){
        ReceptionOrderHeader receptionOrderHeader = ReceptionOrderMapperWMS.toModel(rcpReception,operation);
        List<ReceptionOrderHeader> receptionOrderHeaders = new ArrayList<>();
        receptionOrderHeaders.add(receptionOrderHeader);
        try {
            new ConvertManagerPre().writeFileReceptionOrderHeader(path + File.separator + Utils.dateToString(EmsDate.getDateNow(), true) + "PRE05.txt", receptionOrderHeaders);
        }catch (Exception e){
            try {
                new ConvertManagerPre().writeFileReceptionOrderHeader(path + File.separator + Utils.dateToString(EmsDate.getDateNow(), true) + "PRE05.txt", receptionOrderHeaders);
            }catch (Exception e1){
                //e1.printStackTrace();
            }
        }
    }
}


