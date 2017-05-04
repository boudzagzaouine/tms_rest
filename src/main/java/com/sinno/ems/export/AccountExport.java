package com.sinno.ems.export;

import com.sinno.ems.entities.CmdAccount;
import com.sinno.ems.mapper.wms.AccountMapperWMS;
import com.sinno.ems.util.EmsDate;
import com.sinno.wms.crud.convert.ConvertManagerAcc;
import com.sinno.wms.crud.model.acc.CustomerHeader;
import com.sinno.wms.crud.utils.Utils;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CODING on 05/05/2016.
 */
public class AccountExport {

    private AccountExport() {
    }

    public static void export(String path, CmdAccount account, String operation, ServletContext servletContext) throws Exception {
        CustomerHeader customerHeader = AccountMapperWMS.toModel(account, operation);
        List<CustomerHeader> customerHeaderList = new ArrayList<>();
        customerHeaderList.add(customerHeader);
        try {
            new ConvertManagerAcc().writeFileCustomerHeader(servletContext.getRealPath("/WEB-INF/classes") + File.separator + "ACC04" + Utils.dateToString(EmsDate.getDateNow(), true) + ".txt", customerHeaderList);

        } catch (Exception e) {
        }
    }
}
