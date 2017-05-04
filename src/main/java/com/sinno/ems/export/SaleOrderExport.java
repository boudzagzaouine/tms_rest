package com.sinno.ems.export;

import com.sinno.ems.entities.CmdSaleOrder;
import com.sinno.ems.mapper.wms.SaleOrderMapperWMS;
import com.sinno.ems.util.EmsDate;
import com.sinno.wms.crud.convert.ConvertManagerSor;
import com.sinno.wms.crud.model.sor.OrderHeader;
import com.sinno.wms.crud.utils.Utils;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CODING on 31/05/2016.
 */
public class SaleOrderExport {
    private SaleOrderExport() {
    }

    public static void export(String path, CmdSaleOrder cmdSaleOrder, String operation, ServletContext servletContext) {

        OrderHeader orderHeader =  SaleOrderMapperWMS.toModel(cmdSaleOrder,operation);


        List<OrderHeader> orderHeaders = new ArrayList<>();
        orderHeaders.add(orderHeader);
        try {

            // new ConvertManagerSup().writeFileSuppliers(path+ File.separator+"SUP"+ Utils.dateToString(EmsDate.getDateNow(),true)+".txt",suppliersList);
            new ConvertManagerSor().writeFileOrderHeader(path+ File.separator+"Archive"+File.separator+"SOR"+ Utils.dateToString(EmsDate.getDateNow(),true)+".txt",orderHeaders);

        } catch (Exception e) {

        }
    }
}
