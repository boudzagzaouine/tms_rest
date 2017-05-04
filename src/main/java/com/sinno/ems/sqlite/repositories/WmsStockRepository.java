package com.sinno.ems.sqlite.repositories;

import com.sinno.ems.sqlite.entities.WmsStock;
import org.hibernate.SQLQuery;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.DateType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WmsStockRepository {

    @PersistenceContext(unitName = "entityManagerFactorySqlite")
    EntityManager em;

    public List<WmsStock> getWmsStocks() {
        Query query = em.createNativeQuery("select container.container_no as containerCode,\n" +
                "location.location_label as locationCode,\n" +
                "product.product_code as productCode,\n" +
                "sum(stock.quantity) as quantity,\n" +
                "stock.lot_code as lot,\n" +
                "stock.exp_date as dlc,\n" +
                "stock.serial_no as serial_No,\n" +
                "uom.uom_code as uomCode,\n" +
                "locktype_code as blockType,\n" +
                "owner.owner_code as ownerCode,\n" +
                "supplier.supplier_code as supplierCode\n" +
                "from wms_stock stock\n" +
                "left join \n" +
                "wms_container container on container.container_id=stock.container_id\n" +
                "left join \n" +
                "wms_location location on container.location_id= location.location_id and location.location_label<>'Q-REC' and location.location_label<>'P-REC'\n" +
                "left join\n" +
                "wms_productpack productpack on productpack.productpack_id=stock.productpack_id\n" +
                "left join\n" +
                "wms_product product on productpack.product_id=product.product_id\n" +
                "left join\n" +
                "wms_owner owner on owner.owner_id=product.owner_id\n" +
                "left join\n" +
                "wms_uom uom on productpack.uom_id=uom.uom_id\n" +
                "left join\n" +
                "wms_stock_lock stocklock on stocklock.stock_id=stock.stock_id\n" +
                "left join\n" +
                "wms_locktype locktype on stocklock.locktype_id=locktype.locktype_id\n" +
                "left join\n" +
                "wms_supplier supplier on stock.supplier_id=supplier.supplier_id\n" +
                "group by containerCode,productCode,lot,dlc,serial_No,uomCode,blockType,ownerCode,supplierCode");
        query.unwrap(SQLQuery.class).
                addScalar("containerCode", StringType.INSTANCE).
                addScalar("locationCode", StringType.INSTANCE).
                addScalar("productCode", StringType.INSTANCE)
                .addScalar("quantity", BigDecimalType.INSTANCE)
                .addScalar("lot", StringType.INSTANCE)
                .addScalar("dlc", DateType.INSTANCE)
                .addScalar("serial_No", StringType.INSTANCE)
                .addScalar("uomCode", StringType.INSTANCE)
                .addScalar("blockType", StringType.INSTANCE)
                .addScalar("ownerCode", StringType.INSTANCE)
                .addScalar("supplierCode", StringType.INSTANCE);

        List list = query.getResultList();
        List<WmsStock> wmsStocks = new ArrayList<>();
        for (Object element : list) {
            Object tab[] = (Object[]) element;
            WmsStock wmsStock = new WmsStock();
            wmsStock.setContainerCode(tab[0] != null ? tab[0].toString() : null);
            wmsStock.setLocationCode(tab[1] != null ? tab[1].toString() : null);
            wmsStock.setProductCode(tab[2] != null ? tab[2].toString() : null);
            wmsStock.setQuantity(tab[3] != null ? new BigDecimal(tab[3].toString()) : null);
            wmsStock.setLot(tab[4] != null ? tab[4].toString() : null);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            if (null != tab[5]) {
                try {
                    wmsStock.setDlc(formatter.parse(tab[5].toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            wmsStock.setSerial_No(tab[6] != null ? tab[6].toString() : null);
            wmsStock.setUomCode(tab[7] != null ? tab[7].toString() : null);
            wmsStock.setBlockType(tab[8] != null ? tab[8].toString() : null);
            wmsStock.setOwner_code(tab[9] != null ? tab[9].toString() : null);
            wmsStock.setSupplierCode(tab[10] != null ? tab[10].toString() : null);
            wmsStocks.add(wmsStock);
        }
        return wmsStocks;
    }

}
