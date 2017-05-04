package com.sinno.ems.export;

import com.sinno.ems.entities.PdtProduct;
import com.sinno.ems.mapper.wms.ProductMapperWMS;
import com.sinno.ems.util.EmsDate;
import com.sinno.wms.crud.convert.ConvertManagerPro;
import com.sinno.wms.crud.model.pro.ProductHeaderPresentations;
import com.sinno.wms.crud.utils.Utils;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TM161 on 05/05/2016.
 */
public class ProductExport {
    private ProductExport() {
    }

    public static void export(String path, PdtProduct p, String newCode, String operation, ServletContext servletContext) {
        ProductHeaderPresentations productHeaderPresentations = ProductMapperWMS.toModel(p, newCode, operation);
        List<ProductHeaderPresentations> list = new ArrayList<>();
        list.add(productHeaderPresentations);
        try {
            new ConvertManagerPro().writeFileProductHeaderPresentations(servletContext.getRealPath("/WEB-INF/classes") + File.separator + "PRO11" + Utils.dateToString(EmsDate.getDateNow(), true) + ".txt", list);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
