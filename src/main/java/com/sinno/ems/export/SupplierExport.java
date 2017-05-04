package com.sinno.ems.export;

import com.sinno.ems.entities.RcpSupplier;
import com.sinno.ems.mapper.wms.SupplierMapperWMS;
import com.sinno.ems.util.EmsDate;
import com.sinno.wms.crud.convert.ConvertManagerSup;
import com.sinno.wms.crud.model.sup.Suppliers;
import com.sinno.wms.crud.utils.Utils;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CODING on 05/05/2016.
 */
public class SupplierExport {
    private SupplierExport() {
    }

    public static void export(String path, RcpSupplier supplier, String operation, ServletContext servletContext) {

        Suppliers suppliers = new SupplierMapperWMS().toModel(supplier, operation);
        List<Suppliers> suppliersList = new ArrayList<>();
        suppliersList.add(suppliers);
        try {

            new ConvertManagerSup().writeFileSuppliers(servletContext.getRealPath("/WEB-INF/classes")+ File.separator+"SUP03"+ Utils.dateToString(EmsDate.getDateNow(),true)+".txt",suppliersList);

        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
