package com.sinno.ems.sqlite.repositories;

import org.hibernate.SQLQuery;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Enissay on 18/11/2016.
 */
@Repository
public class WmsSorderStockRepository {
    @PersistenceContext(unitName = "entityManagerFactorySqlite")
    EntityManager em;

    public String getSourceContainerCode(Long lineNumber, String sorderCode, String containerTarget) {
        Query query = em.createNativeQuery("select container_source_no as containerSource from wms_sorder_stock_arch sorderstock,wms_sorder_arch sorder,wms_sorder_line_arch soline\n" +
                "where soline.line_number=?1 and\n" +
                "soline.sorder_id= sorder.sorder_id and\n" +
                "sorder.sorder_code=?2 and\n" +
                "sorderstock.container_target_no=?3\n");
        query.setParameter(1, lineNumber).
                setParameter(2, sorderCode).
                setParameter(3, containerTarget);
        query.unwrap(SQLQuery.class).addScalar("containerSource", StringType.INSTANCE);
        List resultList = query.getResultList();
        String sourceContainer = resultList.size() > 0 ? (String) resultList.get(0) : null;
        return sourceContainer;
    }
}
